pipeline {
agent any
stages {
stage('Installing Maven') {
steps {
sh 'apt-get update -y && sudo apt-get upgrade -y'
sh 'apt-get install -y wget tree unzip maven'
}
}
stage('Compiling and Running Test Cases') {
steps {
sh 'mvn clean'
sh 'mvn compile'
sh 'mvn test'
}
}
stage('Creating Package') {
steps {
sh 'mvn package'
}
}
}
}
