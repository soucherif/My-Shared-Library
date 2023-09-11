/*def call(String project, String ImageTag, String hubUser){
    withCredentials([usernamePassword(
            credentialsId: "docker",
            usernameVariable: "USER",
            passwordVariable: "PASS"
    )]) {
        sh "docker login -u '$USER' -p '$PASS'"
    }
    sh "docker image push ${hubUser}/${project}:${ImageTag}"
    sh "docker image push ${hubUser}/${project}:latest"   
}*/


def call(String aws_account_id, String region, String ecr_repoName){
    
    sh """
     
     docker login --username AWS --password "eyJwYXlsb2FkIjoidnM0MXE1eTc5QWJ0VTFGYWtuWHZrNW1jRWl0S01EeTcvYVN2dHc1bm41bFFiSHJCTmhzUGx1U09Yc1VIMXkrRnh3b3luVElBOUtxTDVaYmxOMzN0K0o5NkJISFdBWmxCaVhweG1DZG5rcWhoOHdhOTh1OEg2WXNrSlBiYXFLV3VreTNMdG5naGtLSWRKNHRuaWN1Wk5SMHZXTzMzOVdPc1lXMURWZTJEL29qSFQ5R1FtUE5Obk8zQU5STEVCeUVsS2pBZWRPYVo5OUwrbmZxMkF2OVZFaUg2ckVHRDRPZEQwSzUyWEdqN1JGL1VwZUF0bW5KM3dheEhmNVR1WWRkM3NGZzg0aW1pd1R0MlhENURvT0I0RG91aU5WRkd5blZOTnV3eldrbHcyTVliMS9hWUJrR0lvazVXcmdhWWd0V2JXYnVHeEtXV21US2pJRllUQnh0WVMxNXg0K05nUWczajlsYVJLMTU1aDVwZ2ZuYjBSSjBpL09jZjJ2bEd4dnhWengvZHRLT3prM21DQncreFJFVmNaTWZESThYS1NFbVRxRXMrbUNMQnZGZlZZUUdSOHdZM3QySEN4Q25rdHRZczc3S0JhVXlvaE1rQTk2QnZ6bUUvSFRsdjNJQmxSWEYxWW1TTjFXVHlOeTE0RDZ0WFRFWkNRbFhqb3QvcHh5YlowaDFVOXA4bnZjU1MrQnR4UVVxNHMzeFNFallGUWJrRDNDeFRDY3A3bHN2Qys4WVdhcXE0NzFkNVlHSTdsYVE2VldYQUFCMWdMajBEN29yb3NtMHI0Q3dheXp3SDFEaUk4aWttcUtrdnJ3UWwxbzk4UDFTOFdrTXd2cnZYSDh1cU4rZ2Yva2wwSXFCR1Myall3Rjh2d3pmM1pwczBsZ0Q0aXJaR3ovb3lqcTYvVXg1SjdSVXRwV1ZKdW1yb1RSTmxiRjlWSFY4MStyUWhOanIrdVFXdmRKbGxJMG12bmlOYjRiaHZ3Vk8vOVBEdkpvZlUyb2ozN0F0cDhkWktsb01PVzZWOTFVL0Ewc1FhTERsMWF2ejU2d3MzV2dON3dEbks5dU5kOXY1bG1FVGY0cWhPNXRZbUJMUXpIUHZEMndIZHM3QTlkM2hUaGJlaXI1TmRpUStuT0hJQnpUdmg5TC9wU1kwdytiZE40aGE4ZVZFYm1WUzhSR2pDL0QvVXFKOUh2K2NlZDhNRW9lb214VE1GTXlCaXhUUnZzbGlYa0dnd0xlMUlZSG03WDkrRDlZUlRVZURHU1Exdk1NRURsTW9oTURrNS8vVE8zR01kdVN5ZjdsQUFja2l0TUwzMWJhdjFmblVIdTRqNi9Ed1dzak5naVIrdm9MK0JsbWZBejl2Z1dhQ3o5aG9pWXp1dmQ1ejNtTFdOVjFYZ0I2dVJYQmpadVIwTWV4b2pKeFdEa3IzUmlPYUdabnBLL1hDa3h4UlNERFRaeVdkdWN3OUlQVXV1ZU4wNUtEUTQrV1czd0NJVXdpY01rM2kxRng2bTZFaWU4c0RPMmdyeUZDTnEybk5ZUEhYMWlqQ3RoZVVmQnV0bFIrU3psSXB3a0VieklFMWdnN0Q2M1VuNVNIbk5CSnUrWEVXVUk2TEMrMlloQm01VHhVenFRSlJXUW1VOWp3cDZqcTZHeDI4UFZib1RKWGVtUGQ1SW1Ya2hHRjVEc0ZYckNzdTlpK0tNTitmdDFTYkFsR2tmQjdJM01lUmgrOCtJRnZId25aN3pTWFlHY1o2QVkxZWswR213L21hdmFTMVkvKzZacWtvPSIsImRhdGFrZXkiOiJBUUVCQUhod20wWWFJU0plUnRKbTVuMUc2dXFlZWtYdW9YWFBlNVVGY2U5UnE4LzE0d0FBQUg0d2ZBWUpLb1pJaHZjTkFRY0dvRzh3YlFJQkFEQm9CZ2txaGtpRzl3MEJCd0V3SGdZSllJWklBV1VEQkFFdU1CRUVEQk5qZHkrQmZ0NnpxTFQ5N2dJQkVJQTcxWXlqeVlRdUtuaUJzYXVKbG5kb0FaaTVpalp0bHRkS0JPUExxSFc0QVEyb0VzMDNoS1NRVlFIcTlMZmcrV1ljNFpvbnhkTHpYOVdsYU9NPSIsInZlcnNpb24iOiIyIiwidHlwZSI6IkRBVEFfS0VZIiwiZXhwaXJhdGlvbiI6MTY5NDUwMDA1OH0==" ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
     docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
    """
}


//aws ecr get-login-password --region us-east-1


//docker login --username AWS --password "$ECR_PASSWORD" 454709238396.dkr.ecr.us-east-1.amazonaws.com





/*def call(String aws_account_id, String region, String ecr_repoName) {
    
    def ecrPasswordCommand = "aws ecr get-login-password --region us-east-1".execute()
    ecrPasswordCommand.waitFor()

    if (ecrPasswordCommand.exitValue() == 0) {
        def ECR_PASSWORD = ecrPasswordCommand.text.trim()
        
        sh """
            docker login --username AWS --password '$ECR_PASSWORD' 454709238396.dkr.ecr.us-east-1.amazonaws.com
            docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
        """
    } else {
        error "Failed to get ECR login password"
    }
}*/
