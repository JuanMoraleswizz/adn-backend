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
                     -Dsonar.host.url=http://localhost:9000 \
                     -Dsonar.login=a48a1d07923a65d5152d195d521dccd3f96fc129'
                    }
                }
            }
        }
    }
}