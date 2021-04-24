pipeline {
  agent none

    stages {
        stage('Example Build') {
            agent { label 'build-label' }
            steps {
                sh 'env'
                sh ' sleep 8'
            }
        }
        stage('Example Test') {
            agent { label 'deploy-label' }
            steps {
                sh 'env'
                sh ' sleep 5'
            }
        }
    }
}