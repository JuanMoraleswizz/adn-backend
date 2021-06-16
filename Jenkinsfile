pipeline {
    agent any
    triggers {
        pollSCM('* * * * *')
    }

    stages {

        stage("Compile") {
            steps {
                dir('microservicio') {
                    sh "pwd"
                     sh "./gradlew compileJava"
                  }

            }
        }
  stage("Unit test") {
                steps {
            dir('microservicio') {
                    sh "pwd"
                     sh "./gradlew test"
                  }

                }
            }
        stage("Code coverage") {
            steps {
            dir('microservicio') {
        	    sh "./gradlew jacocoTestReport"
        	 	publishHTML (target: [
         	        reportDir: 'build/reports/jacoco/test/html',
         			reportFiles: 'index.html',
         			reportName: 'JacocoReport'
         	    ])
         		sh "./gradlew jacocoTestCoverageVerification"
         	}
         	}
        }
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SONAR800') {
                dir('microservicio') {
                    sh './gradlew sonarqube\
                     -Dsonar.projectKey=adn \
                     -Dsonar.host.url=http://localhost:9091 \
                     -Dsonar.login=2c64d2daa2249ba6a272df0c2cda0baee9b6f5e7'
                    }
                }
            }
        }
    }
}