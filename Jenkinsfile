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

    stage('Generating a Cucumber Reports') {
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
stage ('Install sonarqube cli') {
steps {
sh 'wget -O sonar-scanner.zip https://binaries.sonarsource.com/Distribution/sonar-scanner-cli/sonar-scanner-cli4.6.2.2472-linux.zip'
sh 'unzip -o -q sonar-scanner.zip'
sh 'sudo rm -rf /opt/sonar-scanner'
sh 'sudo mv --force sonar-scanner-4.6.2.2472-linux /opt/sonar-scanner'
sh 'sudo sh -c \'echo "#/bin/bash \nexport PATH=\\\"$PATH:/opt/sonar-scanner/bin\\\"" > /etc/profile.d/sonar-scanner.sh\''
sh 'chmod +x /opt/sonar-scanner/bin/sonar-scanner'
sh '. /etc/profile.d/sonar-scanner.sh'
}
}
stage ('Analyzing Code Quality') {
steps {
sh '/opt/sonar-scanner/bin/sonar-scanner -Dsonar.projectKey=amitopenwriteup_mvnproj -Dsonar.organization=amit -Dsonar.qualitygate.wait=true -Dsonar.qualitygate.timeout=300 -Dsonar.sources=src/main/java/ -Dsonar.java.binaries=target/classes -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=5e608b307d89c17066fe612b7ad418857b10c5f8'
}
}

  }


  post {
    always {
    cucumber buildStatus: 'null', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', jsonReportDirectory: 'target/cucumber-reports', pendingStepsNumber: -1, reportTitle: 'report', skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
    }
  }
}
