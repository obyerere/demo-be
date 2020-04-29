
pipeline {
    agent none
    stages {
        stage('Git Checkout2'){
        git 'https://github.com/jamunakan2307/demo-be.git'
            }
    
    stage('Compile Code2'){
        withMaven(maven: 'Maven'){
            sh 'mvn compile'
            }
        
            }
    stage('Code Review2'){
     try {
         withMaven(maven: 'Maven'){
            sh 'mvn pmd:pmd'
        }
        } finally {
            pmd canComputeNew: false, defaultEncoding: '', healthy: '', pattern: 'target/pmd.xml', unHealthy: ''
    }
        
    }
        stage('Run Tests2 and Code Coberage2') {
            parallel {
                stage('Test') {
                    agent {
                        label "agent-1"
                    }
                     try {
        withMaven(maven: 'Maven'){
            sh 'mvn test'
            } 
        } finally {
            junit 'target/surefire-reports/TEST-com.grokonez.jwtauthentication.TestBootUp.xml'
                }
                }
                stage('Code Coverage') {
                    agent {
                        label "master"
                    }
                        try {
        withMaven(maven: 'Maven'){
            sh 'mvn cobertura:cobertura -Dcobertura.report.format=xml'
        } 
        } finally {
            cobertura autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: 'target/site/cobertura/coverage.xml', conditionalCoverageTargets: '70, 0, 0', failUnhealthy: false, failUnstable: false, lineCoverageTargets: '80, 0, 0', maxNumberOfBuilds: 0, methodCoverageTargets: '80, 0, 0', onlyStable: false, sourceEncoding: 'ASCII', zoomCoverageChart: false
    }
                }
            }
        }
    stage('Prepare Package2'){
         try {
        withMaven(maven: 'Maven'){
            sh 'mvn package'
        } 
        } finally {
            archiveArtifacts 'target/*.jar'
    }
    }

    }
}
