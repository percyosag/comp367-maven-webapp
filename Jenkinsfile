pipeline {
  agent any

  tools {
    maven 'Maven'          // optional: the name of a Maven installation in Jenkins (if configured)
    // if you don't have a named Maven tool, the pipeline will still run 'mvn' if available on PATH
  }

  environment {
    MVN_OPTS = "-B -DskipTests" // batch mode, skip tests for speed (remove skipTests if you want tests run)
  }

  stages {
    stage('Checkout') {
      steps {
        // Checkout from the SCM that triggered the build
        checkout scm
      }
    }

    stage('Build') {
      steps {
        // Build using Maven
        sh "mvn ${MVN_OPTS} clean package"
      }
    }

    stage('Archive artifact') {
      steps {
        // Archive the generated jar so Jenkins stores it with the build
        archiveArtifacts artifacts: 'target/*.jar', onlyIfSuccessful: true
      }
    }

    stage('Smoke-run (optional)') {
      steps {
        // show the produced artifact(s) and list files (quick verification)
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