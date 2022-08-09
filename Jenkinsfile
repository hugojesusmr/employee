pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                sh './gradlew assemble'
            }
        }
      /*   stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage("Code coverage") {
            steps {
        	    sh "./gradlew jacocoTestReport"
        	 	publishHTML (target: [
         	        reportDir: 'build/reports/jacoco/test/html',
         			reportFiles: 'index.html',
         			reportName: 'JacocoReport'
         	    ])
         		sh "./gradlew jacocoTestCoverageVerification"
         	}
        }
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SonarQubePruebas') {
                    sh './gradlew sonarqube'
                }
            }
        } */
        stage('Build Docker image') {
            steps {
                sh './gradlew docker'
            }
        }
        stage('Push Docker image') {
            environment {
                DOCKER_HUB_LOGIN = credentials('docker-hub')
            }
            steps {
                sh 'docker login --username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW'
                sh './gradlew dockerPush'
            }
        } 
        stage('Deploy to k8s'){
            steps{
                script{
                    kubernetesDeploy (configs: 'k8s/mysql-configmap.yaml',kubeconfigId: 'kube')
                    kubernetesDeploy (configs: 'k8s/mysql-secret.yaml',kubeconfigId: 'kube')
                    kubernetesDeploy (configs: 'k8s/mysql-root-secret.yaml',kubeconfigId: 'kube')
                    kubernetesDeploy (configs: 'k8s/mysql-deployment.yaml',kubeconfigId: 'kube')
                    kubernetesDeploy (configs: 'k8s/backend-deployment.yaml',kubeconfigId: 'kube')
                }
            }
        }  
      
    }
}