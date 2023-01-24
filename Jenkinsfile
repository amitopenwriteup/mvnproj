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
//        stage('Download Java Code'){
//           steps{
//             git branch: 'main', credentialsId: 'git-repo-creds', url: 'git@github.com:devopstrainee001/java-springboot-sample-app-Java-Jenkins.git'
//             }
//         }
//        stage('Compiling and Running Test Cases') {
//        steps {
//              sh 'mvn clean'
//              sh 'mvn compile'
//              sh 'mvn test'
//        }
//      }
//        stage('Creating Package') {
//            steps {
//                sh 'mvn package'
//       }
//    }
//        stage('Deploying Application') {
//            steps {
//                script{
//                    withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
//                    sh 'nohup java -jar ./target/jenkin-java-training-0.0.1-SNAPSHOT.jar &'
//                     }
//           	   }
//              }
          }

    }

