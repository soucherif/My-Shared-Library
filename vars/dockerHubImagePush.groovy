def call(String imageName, String imageTag, String hubUser){
    
    sh "docker login -u 'soucherif' -p 'P@ssw0rdsou'"
    
    sh "docker image push ${hubUser}/${imageName}:${imageTag}"
    sh "docker image push ${hubUser}/${imageName}:latest"   
}

 //dckr_pat_mFECZTpTPYBSWxiPhUDc_onBECw

 /*withCredentials([usernamePassword(
            credentialsId: "docker",
            usernameVariable: "USER",
            passwordVariable: "PASS"
    )]) {*/