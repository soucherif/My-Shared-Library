def call(credentialsId){

    withSonarQubeEnv(credentialsId: credentialsId) {
         sh 'mvn clean package sonar:sonar -Dsonar.login=squ_ae262dfcb4e4d97ce2f1b0d528e5ff78335dd545'
    }
}