pipeline {
    agent any
    tools{
     gradle "gradle-7.0.1"
    }
    triggers {
        pollSCM('* * * * *')
    }
    stages {
        stage("Compile") {
            steps {
                sh "gradle compileJava"
            }
        }
        stage("Unit test") {
            steps {
                sh "gradle test"
            }
        }
        stage("Code coverage") {
            steps {
        	    sh "gradle jacocoTestReport"
        	 	publishHTML (target: [
         	        reportDir: 'build/reports/jacoco/test/html',
         			reportFiles: 'index.html',
         			reportName: 'JacocoReport'
         	    ])
         		sh "gradle jacocoTestCoverageVerification"
         	}
        }
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SONAR800') {
                    sh 'gradle sonarqube'
                }
            }
        }
    }
}