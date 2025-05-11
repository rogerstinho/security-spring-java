pipeline {
    agent {
        docker {
            image 'maven:3.9.9-eclipse-temurin-21-alpine'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -f ./spring-security64 -DskipTests clean package'
            }
        }
        stage('Test') { 
            steps {
                sh 'mvn -f ./spring-security64 test' 
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml' 
                    archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', fingerprint:true
                }
            }
        }
        stage('Package') {
            steps {
                // Package the application
                sh 'mvn -f ./spring-security64 package'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint:true
            }
        }
    }
}