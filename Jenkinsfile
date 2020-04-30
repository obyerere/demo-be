#!/usr/bin/env groovy
// see https://jenkins.io/doc/book/pipeline/syntax/

pipeline {

    agent any

    tools {
        maven "Maven"
    }

    triggers {
        pollSCM "* * * * *"
    }
    
    options {
        timestamps()
    }


    stages {
        stage("Compile  & Test") {
         parallel {
         stage('Compile') {
              agent {
                        label "master"
                      }
                steps {
                sh "mvn compile"
            }
         }
           stage('Test') {
              agent {
                        label "master"
                      }
                steps {
                sh "mvn test"
            }
         }
           
        }
    }

          stage("Package") {
        
            steps {
                sh "mvn test"
            }
        }

    }

    post {
        always {
            deleteDir()
        }
    }
}
