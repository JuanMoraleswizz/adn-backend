pipeline {
    agent any
    triggers {
        pollSCM('* * * * *')
    }
    dir('microservicio') {
          sh "pwd"
        }
    stages {
     stage("Unit test") {
                steps {

                    sh "./gradlew test"
                }
            }
        stage("Compile") {
            steps {

                sh "./gradlew compileJava"
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