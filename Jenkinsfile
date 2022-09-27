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
                        bat "gradlew sonarqube -Dsonar.branch.name=${BRANCH_NAME}"
                    }
               }
        }
        stage("Quality Gate") {
                    steps {
                        timeout(time: 1, unit: 'HOURS') {
                            waitForQualityGate abortPipeline: true
                        }
                    }
                }
    }
}
