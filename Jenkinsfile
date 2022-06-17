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
                    docker-compose up --build'''
            }
        }
    }
}