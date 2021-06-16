pipeline {
    agent any
    triggers {
        pollSCM('* * * * *')
    }
    stage("Unit test") {
                steps {
                    sh "./microservicio/gradlew test"
                }
            }
    stages {
        stage("Compile") {
            steps {

                sh "./microservicio/gradlew compileJava"
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