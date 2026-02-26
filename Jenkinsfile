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
        sh "./mvnw ${MVN_OPTS} clean package"
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

  post {
    success {
      echo "Build successful"
    }
    failure {
      echo "Build failed"
    }
  }
}