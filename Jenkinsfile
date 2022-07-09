pipeline{
    agent any
    triggers{
        pollSCM '* * * * *'
    }
    stages{
        stage('Build'){
            steps{
                sh './gradlew assemble'
            }
        }
        stage('Test'){
            steps{
                sh './gradlew test'
            }
        }
        stage('Build Docker image'){
            steps{
                sh './gradlew docker'
            }
        }
        stage('Push Docker image'){
            enviroment{
                DOCKER_HUB_LOGIN = credentials('docker-hub')
            }
            s teps{
                sh './gradlew dockerPush'
            }
        }
    }
}