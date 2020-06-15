pipeline {
 environment {
  registry = "obyerere1/tea-be"
  registryCredential = 'Dockerhub'
  dockerImage = ''
 }
 agent any
 stages {
  stage('Cloning Git') {
   steps {
    git 'https://github.com/obyerere/demo-be.git'
   }
  }

  stage('Prepare Package') {
   steps {
    withMaven(maven: 'maven') {
     sh 'mvn package'
    }
   }
  }

  stage('Building image') {
   steps{
    script {
     dockerImage = docker.build registry + ":1.2"
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
    sh "docker rmi $registry:1.2"
   }
  }
 }
}
