pipeline{
    agent agent {label  "agentfarm" }
    stages {
        stage('Delete the workspace'){
            steps{
                cleanWs()
            }
        }
       stage('Second Stage'){
           steps {
               echo "Second stage"
           }
         }
        stage ('Third stage'){
            steps{
                echo "Third Stage"
            }
        }
     }
 } 

