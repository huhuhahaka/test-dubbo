pipeline {
    agent any 
    stages {
        stage('Build') { 
            steps {
                sh "cd /Users/guoguanglin/.jenkins/workspace/test-dubbo/provider"
                sh "mvn clean package"
                sh "cd /Users/guoguanglin/.jenkins/workspace/test-dubbo/consumer"
                sh "mvn clean package"
            }
        }
        
        stage('Deploy') { 
            steps {
                sh "cd /Users/guoguanglin/.jenkins/workspace/test-dubbo"
                sh "docker-compose up --build"
            }
        }
    }
}