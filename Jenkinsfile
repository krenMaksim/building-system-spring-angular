pipeline {
agent any
       stages {
        stage('Build') { 
            steps {
                sh 'mvn clean package; cp ./building-system-web/target/building-system.war /home/kren/Documents/POPDACTION-building-system/apache-tomcat-building-system/webapps' 
            }
        }
    }
}
