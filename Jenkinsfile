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
        }
}