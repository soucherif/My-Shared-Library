def call(credentialsId){

    withSonarQubeEnv(credentialsId: credentialsId) {
         sh 'mvn clean package sonar:sonar -Dsonar.login=squ_3d6f3866ff24fa4187b8dc4b4adee2534bb7eef5'
    }
}