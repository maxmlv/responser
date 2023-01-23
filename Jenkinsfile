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

        stage('Terraform init') {
            steps {
                sh '''
                cd terraform
                terraform init
                '''
            }
        }

        stage('Terraform plan') {
            steps {
                sh '''
                cd terraform
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

        stage('Ansible PK') {
            steps {
                sh '''
                aws secretsmanager get-secret-value \
                --secret-id responser.pem \
                --query SecretString \
                --output text > ~/.ssh/responser.pem
                chmod 400 ~/.ssh/responser.pem
                ls -al ~/.ssh
                '''
            }
        }

        stage('Ansible vars') {
            steps {
                sh '''
                cd terraform
                chmod +x tf-output.sh
                ./tf-output.sh ../ansible/vars/vars.yaml
                cd ..
                basename ./target/*.jar | tr -cd "0-9." | sed 's/.$//' >> ./ansible/vars/vars.yaml
                cat ./ansible/vars/vars.yaml
                '''
            }
        }
    }
}
