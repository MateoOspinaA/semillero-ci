pipeline{
    agent any
    triggers {
            pollSCM('* * * * *')
    }
    stages{
        stage('Build'){
            steps{
                echo "------------>Clean and Build<------------"
                bat 'gradlew clean build -x test'
            }
        }
        stage('test') {
             steps {
                echo "------------>test<------------"
                bat 'gradlew test'
             }
        }
        stage('Coverage') {
              steps {
                 echo "------------>Coverage<------------"
                 bat 'gradlew jacocoTestReport'
              }
        }
        stage('Sonar') {
               steps {
                    echo "------------>SonarCloud<------------"
                    withSonarQubeEnv('SonarCloud'){
                        bat 'gradlew sonarqube'
                    }
               }
        }
    }
}