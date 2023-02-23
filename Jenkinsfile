pipeline {
    agent {
        node {
            label 'jenkins-docker-agent'
        }
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Terraform init and plan') {
            steps {
                sh '''
                cd terraform
                terraform init -no-color
                terraform plan -var-file="inputs.tfvars" -no-color
                '''
            }
        }

        stage('Terraform apply') {
            when {
                branch 'main'
            }

            steps {
                sh '''
                cd terraform
                terraform apply -var-file="inputs.tfvars" -auto-approve -no-color
                '''
            }
        }

        stage('Deployment Strategy State') {
            steps {
                sh '''
                cd deployment-switch
                chmod +x deploy_state.sh; chmod +x export_state.sh; chmod +x deploy_switch.sh
                ./deploy_state.sh deploy_state
                '''
            }
        }

        stage('Ansible PK and Vars retrieval') {
            when {
                branch 'main'
            }

            steps {
                sh '''
                [ ! -d ~/.ssh ] && mkdir ~/.ssh
                aws secretsmanager get-secret-value \
                --secret-id responser.pem \
                --query SecretString \
                --output text > ~/.ssh/responser.pem
                chmod 400 ~/.ssh/responser.pem
                ls -al ~/.ssh
                cd terraform
                chmod +x tf-output.sh
                ./tf-output.sh ../ansible/vars/vars.yaml
                cd ..
                echo "app_version: $(basename ./target/*.jar | tr -cd "0-9." | sed 's/.$//')" >> ./ansible/vars/vars.yaml
                cat ./ansible/vars/vars.yaml
                '''
            }
        }

        stage('Ansible Syntax Check') {
            steps {
                sh '''
                cd deployment-switch
                . export_state.sh deploy_state
                cd ../ansible
                ansible-playbook efs-mount.yaml -i hosts.ini --syntax-check
                ansible-playbook web-setup.yaml -i hosts.ini --syntax-check
                ansible-playbook deployment.yaml -i hosts.ini --syntax-check
                '''
            }
        }

        stage('Ansible EFS Mount') {
            when {
                branch 'main'
            }

            steps {
                sh '''
                cd deployment-switch
                . export_state.sh deploy_state
                cd ../ansible
                ansible-playbook efs-mount.yaml -i hosts.ini
                '''
            }
        }

        stage('Ansible Web') {
            when {
                branch 'main'
            }

            steps {
                sh '''
                cd deployment-switch
                . export_state.sh deploy_state
                cd ../ansible
                ansible-playbook web-setup.yaml -i hosts.ini
                '''
            }
        }

        stage('Ansible Deployment') {
            when {
                branch 'main'
            }

            steps {
                sh '''
                cd deployment-switch
                . export_state.sh deploy_state
                cd ../ansible
                ansible-playbook deployment.yaml -i hosts.ini
                '''
            }
        }

        stage('Post-Deployment Traffic Switch') {
            when {
                branch 'main'
            }

            steps {
                sh '''
                cd deployment-switch
                . export_state.sh deploy_state
                cd ../terraform
                export DEPLOY_IP_ADDRESS=$(terraform output -raw $DEPLOY_ON -no-color)
                cd ../deployment-switch
                ./deploy_switch.sh record_update.json $DEPLOY_IP_ADDRESS
                '''
            }
        }
    }
}
