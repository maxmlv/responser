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
                terraform plan
                '''
            }
        }
    }
}