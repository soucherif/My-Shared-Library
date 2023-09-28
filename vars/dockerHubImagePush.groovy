def call(String imageName, String imageTag, String hubUser){
    
    
    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    
    sh """
    docker login -u \$DOCKERHUB_USERNAME --password-stdin << EOF
    \$DOCKERHUB_PSW
    EOF
    """
    //   sh "docker login -u '$USER' -p '$PASS'"
    }
    
    
    
    sh "docker image push ${hubUser}/${imageName}:${imageTag}"
    sh "docker image push ${hubUser}/${imageName}:latest"
     
}

 //dckr_pat_mFECZTpTPYBSWxiPhUDc_onBECw

 /*withCredentials([usernamePassword(
            credentialsId: "docker",
            usernameVariable: "USER",
            passwordVariable: "PASS"
    )]) {*/