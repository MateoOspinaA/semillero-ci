//properties([pipelineTriggers([githubPush()])])
pipeline{
    agent any
    triggers {
            //githubPush()
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
                        bat "gradlew sonarqube -Dsonar.branch.targe=${BRANCH_NAME} -Dsonar.branch.name=${BRANCH_NAME}"
                    }
               }
        }
    }
}
