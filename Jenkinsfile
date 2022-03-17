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
                withSonarQubeEnv('SonarQubePruebas') {
                    dir('microservicio') {
                     sh './gradlew sonarqube \
                    -Dsonar.login=9ef35a061a831e09ff6ea3ddf0721965a42e89a3'
                    //   sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner  -Dproject.settings=sonar-project.properties"
                   //  sh './gradlew sonarqube \
                   // -Dproject.settings=sonar-project.properties'
                       //sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner  -Dproject.settings=sonar-project.properties"
                    }

                }
            }
        }
    }
}

