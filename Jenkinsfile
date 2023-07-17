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
stage('Creating Package') {
steps {
sh 'mvn package'
}
}
}
}
