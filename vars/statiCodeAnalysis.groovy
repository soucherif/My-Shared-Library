def call(credentialsId){

    withSonarQubeEnv(credentialsId: credentialsId) {
         sh 'mvn clean package sonar:sonar -Dsonar.login=squ_50d10cde9a0e5ede4bb31557c5d1bb551b70c556'
    }
}