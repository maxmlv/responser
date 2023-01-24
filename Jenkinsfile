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
                terraform init
                terraform plan -var-file="inputs.tfvars"
                '''
            }
        }

        stage('Terraform apply') {
            steps {
                sh '''
                cd terraform
                terraform apply -var-file="inputs.tfvars" -auto-approve
                '''
            }
        }

        stage('Ansible PK and Vars retrieval') {
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

        stage('Ansible EFS Mount') {
            steps {
                sh '''
                cd ansible
                ansible-playbook efs-mount.yaml -i hosts.ini
                '''
            }
        }

        stage('Ansible Web') {
            steps {
                sh '''
                cd ansible
                ansible-playbook web-setup.yaml -i hosts.ini
                '''
            }
        }

        stage('Ansible Deployment') {
            steps {
                sh '''
                cd ansible
                ansible-playbook deployment.yaml -i hosts.ini
                '''
            }
        }
    }
}
