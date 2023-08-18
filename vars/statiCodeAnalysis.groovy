def call(credentialsId){

    withSonarQubeEnv(credentialsId: credentialsId) {
         sh 'mvn clean package sonar:sonar -Dsonar.login=squ_3a35c76bd29ceb9ba93664d77d0d7f9125cbb7aa'
    }
}