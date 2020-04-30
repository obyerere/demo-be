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

        stage("Build & Deploy") {
            steps {
                sh "mvn compile"
            }
        }

        stage("Code review"){
          try {
                sh "mvn pmd:pmd"

        } finally {
            pmd canComputeNew: false, defaultEncoding: '', healthy: '', pattern: 'target/pmd.xml', unHealthy: ''
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
