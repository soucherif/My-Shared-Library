def call(String imageName, String imageTag, String hubUser){
    
     sh """   
      trivy image ${hubUser}/${imageName}:${imageTag} > scan.txt
      cat scan.txt
     """
 }
