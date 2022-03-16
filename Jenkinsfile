pipeline {
    agent any
    triggers {
        pollSCM('* * * * *')
    }
    stages {
        stage("Compile") {
            steps {
                sh "./microservicio/gradlew compileJava"
            }
        }
        stage("Unit test") {
            steps {
                sh "./microservicio/gradlew test"
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
         		sh "./microservicio/gradlew jacocoTestCoverageVerification"
         	}
        }
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SonarQubePruebas') {
                    sh './microservicio/gradlew sonarqube'
                }
            }
        }
    }
}
