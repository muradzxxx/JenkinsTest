pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean compile' // Maven projeyseniz
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test' // Selenium ve Cucumber testlerini çalıştırın
            }
        }
    }
}