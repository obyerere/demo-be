#!/usr/bin/env groovy

import hudson.model.*
import hudson.EnvVars
import java.net.URL


node{

    
     stage('Code Review'){
         try{
                 withMaven(maven: 'Maven') {
                 sh 'mvn pmd:pmd'
                }
            }finally{
                pmd canComputeNew: false, defaultEncoding: '', healthy: '', pattern: 'target/pmd.xml', unHealthy: ''
            }
    
    }
    
      stage('Test'){
        withMaven(maven: 'Maven') {
            try{
                  sh 'mvn test'
            } finally{
                junit 'target/surefire-reports/TEST-com.grokonez.jwtauthentication.TestBootUp.xml'
            }
          
        }
    }
    
       stage('Code Coverage'){
        withMaven(maven: 'Maven') {

			try{
		         sh 'mvn cobertura:cobertura -Dcobertura.report.format=xml'
			}
			
			finally{
			cobertura autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: 'target/site/cobertura/coverage.xml', conditionalCoverageTargets: '70, 0, 0', failUnhealthy: false, failUnstable: false, lineCoverageTargets: '80, 0, 0', maxNumberOfBuilds: 0, methodCoverageTargets: '80, 0, 0', onlyStable: false, sourceEncoding: 'ASCII', zoomCoverageChart: false
		
			}
        }
    }
    
      stage('Packagee'){
        withMaven(maven: 'Maven') {
            try{
			
					sh 'mvn package'
				}finally{ 
				archiveArtifacts 'target/*.jar'}
        }
    }
}
