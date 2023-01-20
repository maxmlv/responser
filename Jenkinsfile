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
            when {
                branch 'main'
            }

            steps {
                sh '''
                cd terraform
                terraform init
                '''
            }
        }

        stage('Terraform plan') {
            when {
                branch 'main'
            }

            steps {
                sh '''
                cd terraform
                terraform plan
                '''
            }
        }

        stage('Test webhook on main') {
            when {
                branch 'main'
            }

            steps {
                sh 'echo "Triggered auto from main branch"'
            }
        }

        stage('Test webhook') {
            when {
                branch 'feature/*'
            }

            steps {
                sh 'echo "test webhook on pull requests....Configured jenkins to build on any branch...Test 2"'
            }
        }
    }
}
