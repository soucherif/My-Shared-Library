def call(String imageName, String imageTag, String hubUser){
    
    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
       sh "docker login -u '${USER}' -p '${PASS}'"
    }
     sh """
      docker rmi ${hubUser}/${imageName}:${imageTag}
      docker rmi ${hubUser}/${imageName}:latest
     """
 }