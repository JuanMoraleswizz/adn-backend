pipeline {
    agent any
    triggers {
        pollSCM('* * * * *')
    }

    stages {
     stage("Unit test") {

        stage("Compile") {
            steps {
                 dir('microservicio') {
                                    sh "pwd"
                      }
                sh "./gradlew compileJava"
            }
        }
    steps {
            dir('microservicio') {
                    sh "pwd"
                  }
                    sh "./gradlew test"
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
         		sh "./microservicio/gradlew jacocoTestCoverageVerification"
         	}
        }
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SONAR800') {
                    sh './microservicio/gradlew sonarqube'
                }
            }
        }
    }
}