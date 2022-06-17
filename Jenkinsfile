pipeline {
    agent any 
    stages {
        stage('Build') { 
            steps {
                sh '''cd /Users/guoguanglin/.jenkins/workspace/test-dubbo/provider
                    mvn clean package
                    cd /Users/guoguanglin/.jenkins/workspace/test-dubbo/consumer
                    mvn clean package'''
            }
        }
        
        stage('Deploy') {
            steps {
                sh '''cd /Users/guoguanglin/.jenkins/workspace/test-dubbo
                    docker-compose build'''
            }
        }
    }

    post {
        always {
            echo 'One way or another, I have finished'
        }
        success {
            sh '''cd /Users/guoguanglin/.jenkins/workspace/test-dubbo
                docker-compose up -d'''
            echo 'success!'
        }
        unstable {
            echo 'unstable!'
        }
        failure {
            echo 'failure!'
        }
        changed {
            echo 'Things were different before...'
        }
    }

}