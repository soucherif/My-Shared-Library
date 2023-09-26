def call(String imageName, String imageTag, String hubUser){
    
     sh "docker login -u 'soucherif' -p 'P@ssw0rdsou'"
     sh """
      docker rmi ${hubUser}/${imageName}:${imageTag}
      docker rmi ${hubUser}/${imageName}:latest
     """
 }