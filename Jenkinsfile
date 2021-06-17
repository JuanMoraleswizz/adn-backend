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
        }
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SONAR800' {
                    dir('microservicio') {
                    sh './gradlew sonarqube \
                    -Dsonar.login=fb46365d54796e8e771767ffb163f670240097d3'
                    }

                }
            }
        }
    }
