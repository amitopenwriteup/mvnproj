pipeline{
    agent {label  "agentfarm" }
    stages {
        stage('Delete the workspace'){
            steps{
                cleanWs()
            }
        }
       stage('Installing Maven'){
           steps {
               sh 'sudo apt-get update -y && sudo apt-get upgrade -y'
               sh 'sudo apt install -y wget tree unzip openjdk-11-jdk maven'
           }
         }
        stage ('Download Java Code'){
            steps{
                git branch: 'main', credentialsId: 'git-repo-creds', url: 'git@github.com:devopstrainee001/java-devops-sample-app-boot-camp.git'
            }
        }
     }
 } 

