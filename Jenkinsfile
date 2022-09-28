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
        stage('Test') {
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
                withSonarQubeEnv(installationName: 'SonarCloud') {
                    script {
                        bat "gradlew sonarqube -Dsonar.branch.name=${BRANCH_NAME}"
                    }
                }
            }
        }
        stage("Quality Gate") {
            steps {
                timeout(5) {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        stage("Generate and Publish Artifact") {
                    when {
                        allOf {
                            branch "main"
                            tag "v*.*.*"
                        }
                    }
                    steps {
                        echo "Generate Artifact ..."
                        echo "Publish Artifact ..."
                    }
                }
    }
}
