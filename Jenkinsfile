pipeline{
    agent any
    triggers {
            pollSCM('* * * * *')
    }
    stages{
        stage('Build'){
            steps{
                bat 'gradlew clean build -x test'
            }
        }
        stage('test') {
             steps {
                bat 'gradlew test'
             }
        }
        stage('Coverage') {
              steps {
                 bat 'gradlew jacocoTestReport'
              }
        }
//         stage('Sonar') {
//                steps {
//                withSonarQubeEnv('SonarCloud')
//                  bat 'gradlew sonarqube'
//                }
//         }//SONAR_TOKEN=d37457c17e8f422a360e1b571c02ccfcfce327bb
         }
    }