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
     
     docker login --username AWS --password "eyJwYXlsb2FkIjoiMjFxNmRqWG03K0ladzRPSHB5czF2c0s3amswVlgwa3pIUGkwRFh3bFA5WXNTMG5FS3FsTGJYRXZzN3RjcmFENHBJUG8zS2N3eTNtUFRtM3dKalR1YTY2YWNrazYwSGt5TGlQdDRVUWE5ZEYwYWdFODRrLzZ2ZFpEaE93dVVwTi9KNWpkd2Q3OWQ5WWM1MXVrVWlwRHF5Vkt1MXdJVExiRFJ2UVFnZW0xSlJxVXI2VXRpd2Y4ZlJkbWhWdjFsT2grcDRkZEdiWWVTNm82QlBOYVA3QjNPbkxGbUxXSFFCQlo3U3JITEk5TDdvZmRvbHJSU01NYmpvVDdqOE52YkRjTyt3Q2JiZktxZjJoYTJuempnQVV2N2YxTEVyTUJ4RGdYNWdWN0E3dnJFOUZUOE00WEdsNkU2UkJWWkRtVDhwaFljcGJ0NlMrUlBlcU5qSWR3bzlKcVdVd3crazQ3MUoycGQ5L0VaZ3Fpc3ZtRGtoUXIySWg1UVZ3MVlKeUwrbUF3VzFTSEl2TDJIbTg0eXJYVHZZK2Erb1IyUFNHSzduMzVGTjB2MXB2bmZjK09VbzJQTzRscTYwaG5qQ3Bqa0dEOGpBL0dycVNleWxNTElkVzAwS3BmWXh0WmwwSTNianp3bWF1NDhQSjlQQzRhV0VRMnZOd055RFI5MEMwMzZDeTlMMWozazJ4Z0xNZ05uQmYvSGRHNkJQZTMvK1VaRWJaZDc5UTZXcXlvWWxQOGt0QzhsenBxT0NneGZxY013ZWovbDFCRHp2RGR1S3o0RXB6MHVIbHFBUGFiT1p1RlViT1pCN1BKN1FIcytMR3ZYTDl1ejk5VmpzZE1kNHQ4S01TMWVVdUE3c25xa0xyQXhwVDJiUU5HTjVJUHhPV2owcS8zK3dSaWpuUVRHQnRDUWhsbVBta1pzd3VPQytoMS9JRENyc0xnYUVIcUZXVzVZNCt1RmljZENjaFJJYnB6aUFlRUR2ckZ6ZU5iVnJOKzNLR3NKS2xFTHFuRTRNRm5lSGswbXV1UU5GbXkwWjI1LzlxVXYvNXR4SjBjcVFURUJhMlRDOGxQdWhpQXA0OWlSQ0tWQXl5Zkc4dENzYTV3WjF6eStyNktuY2d4RWQzS2xpQ00zY3c2RUNXeG40RFZOeGh1MU15MHlUallmcnpRWElaeXlteGhXTVN0RCt4WHVueG5TbmRIajBzUnJ4S0xGQ1FsOXNnUjViajI1cFFwOFkrODh5Q3g5ZXAycDlXSmZVRDNRWHZ1Rlo2K1NaY1JDTWJacGVibUFudERtV0pPcXh3dGZQa0trVDc4M3BlNVFqTWQwZm1QdzRRckwxOWRKMUlKYzBBbm9Fek1ZVUtTb1ZWK2VKbk9hdjhLenlndjl1TFRRbUhQWjJFWW4rSkIwMjdzS3czbTh4VEd1d2Z5NGRWZTlac0I2ZlNwN0lXNDhHcmJaaEJuUlNnY2V1N0tLaDhPOVBBUHRkNkpkbXJQdmpjR0VqZjJsTVRveXhpMUF3NzRPdmFKRUFPWXFrMUs2Lzh6QlVWZTE0TlpSL1ZwdVFZbDB4UXRHNnh3Mkc1UzZOaVVEWmhyV2Fld0YvUmdCZVZONUhieXhBaUVuVjVQbkRjTko3L0liTVNCOUtGcGNORXVVZktrNXhkTHBXZTBzK0ZiY0xCeHdJQ3dUalBPMUN3TlVvY3Zsa2dqWGJuTUIwVUR4a2FnS1ZWVEtWT1dQcnZKMHBjMkwydm9QZnYydllWWjRwRi9Wa0N3Zzd6b091bVFlT0wvNWw0PSIsImRhdGFrZXkiOiJBUUVCQUhod20wWWFJU0plUnRKbTVuMUc2dXFlZWtYdW9YWFBlNVVGY2U5UnE4LzE0d0FBQUg0d2ZBWUpLb1pJaHZjTkFRY0dvRzh3YlFJQkFEQm9CZ2txaGtpRzl3MEJCd0V3SGdZSllJWklBV1VEQkFFdU1CRUVEQ2RIVTVaUUU2OGJxc3Z3dGdJQkVJQTdMV1hyVnU1Vzc5YXdLcEVlYTFGZ0c0MkpLdlhuSTRoRWQzTHU3K1dUanVzNVlwUnRpTjYrSGUrdDNPbkMrMGhTQW51QjNEVEdERlc2K0FVPSIsInZlcnNpb24iOiIyIiwidHlwZSI6IkRBVEFfS0VZIiwiZXhwaXJhdGlvbiI6MTY5NTMzMTg0NH0=" ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
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
