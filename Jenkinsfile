pipeline {
  agent any

  environment {
    MVN_OPTS = "-B -DskipTests"
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build') {
      steps {
        sh "mvn ${MVN_OPTS} clean package"
        // If mvn isn't found on Jenkins, switch to: sh "./mvnw ${MVN_OPTS} clean package"
      }
    }

    stage('Archive artifact') {
      steps {
        archiveArtifacts artifacts: 'target/*.jar,target/*.war', onlyIfSuccessful: true
      }
    }

    stage('Smoke-run') {
      steps {
        sh 'ls -lah target || true'
      }
    }
  }
}