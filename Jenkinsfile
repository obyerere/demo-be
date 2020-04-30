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
        ansiColor("xterm")
    }


    stages {

        stage("Build & Deploy SNAPSHOT") {
            steps {
                sh "mvn compile"
            }
        }

        stage("Release") {
        
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
