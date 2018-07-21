pipeline {
agent any
       stages {
        stage('Build') { 
            steps {
                sh 'cd ./building-system-spring-angular; mvn   clean package' 
            }
        }
    }
}
