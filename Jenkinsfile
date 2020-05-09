pipeline {
 environment {
  registry = "vens6910/demo-be"
  registryCredential = 'dockerhub'
  dockerImage = ''
 }
 agent any
 stages {
  stage('Cloning Git') {
   steps {
    git 'https://github.com/jamunakan2307/demo-be.git'
   }
  }

  stage('Prepare Package') {
   steps {
    withMaven(maven: 'Maven') {
     sh 'mvn package'
    }
   }
  }

  stage('Building image') {
   steps{
    script {
     dockerImage = docker.build registry + ":1.1"
    }
   }
  }
  stage('Deploy Image') {
   steps{
    script {
     docker.withRegistry( '', registryCredential ) {
      dockerImage.push()
     }
    }
   }
  }
  stage('Remove Unused docker image') {
   steps{
    sh "docker rmi $registry:1.1"
   }
  }
 }
}