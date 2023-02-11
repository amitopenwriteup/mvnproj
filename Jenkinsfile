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
        stage ('Third stage'){
            steps{
                echo "Third Stage"
            }
        }
     }
 } 

