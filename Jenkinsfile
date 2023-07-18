pipeline {
  agent any

  stages {
    stage('Compiling and Running Test Cases') {
      steps {
        sh 'mvn clean'
        sh 'mvn compile'
        sh 'mvn test'
      }
    }

    stage('Generating Cucumber Reports') {
      steps {
        script {
          // Run Cucumber tests and generate reports
          sh 'mvn verify'
        }
      }
    }

    stage('Creating Package') {
      steps {
        sh 'mvn package'
      }
    }
  stage('adding genrerate report'){
     steps {
      sh 'mvn verify'
    }
  }
  }

  post {
    always {
    cucumber buildStatus: 'null', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', jsonReportDirectory: 'target/cucumber-reports', pendingStepsNumber: -1, reportTitle: 'report', skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
    }
  }
}
