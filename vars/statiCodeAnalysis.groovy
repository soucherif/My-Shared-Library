def call(credentialsId){

    withSonarQubeEnv(credentialsId: credentialsId) {
         sh 'mvn clean package sonar:sonar -Dsonar.login=squ_ac15a2d9b2a3072e4a65bd46aeb71f54c85be58d'
    }
}
