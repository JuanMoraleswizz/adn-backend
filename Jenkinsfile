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
                    sh './gradlew sonarqube \
                    -Dsonar.login='69e097e14061cf6ea52aa2151a09157b45b8378d'
                    }

                }
            }
        }
    }
}
