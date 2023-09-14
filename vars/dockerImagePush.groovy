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
     
     docker login --username AWS --password "eyJwYXlsb2FkIjoibzZLeWlzcHJncGEwZWFYMk1TUlcvMmhsd3lUNFRMR3lpR1Y4bTBMeDRha0YrbzNCWjZoNzYvcG8ydmU3ZXc3OVVlQmJ4dVdSYWo3OUdjN0V6RHRDNVNYMlVwRXFXNVJaU0s4QmkvTmNXM3NSdHpDcmZlQnluQmJicEF6RHlKYTYzS09iMzhNTnk4dW5GM3N0VlRYMjZKOStXZFhNZHRjVnNGQUN3bCs2ZUpBN2ZXRk1vTncvdWhOdk9NMVBaRlJrLy9wckJaYXJDNE1Hd0RCbUlRSTdKYmllUmYyRHNnUWtROEtteG55bVRKdUlQTkRaUFBMa2JxRHI0N1dxRDk3eHVKbjJEYVlWQk93WkZuMXJWbHhmNk9Za09Bemc0dzNMbno1WXVuS29tVHA4OXZpdk1aNVkwTmZGTDhlTXFuTGMwQ3hTQ1JEellVSXRMVU5tZ0cvNWNaTkZVTDJnS1M5UGk4SW41MXFuamc3cnJwSWIyZlJIdWJRckI2TWNaUEhPYkVGbFVqM2lBcVgzdEk2ZkV2Zko3diswaGtkdVFmRDhpclJSU2lVZ0lDQVh2Q1RhaEY4OVBRRzVQYVIrQWoxRkdIbHlSRnRxTW9wdjN6TEV2ZVJ6VGFveTVEUmNHMHQ1aktwY1J4V09VQzJ0RGVxV1ZlZkJHTWdLYUEwSGRxcWxaK3BVYXFtNGRQSEJmRlhSYktvdEUzS201NmdnUTY2b0RMUThKRHBSKzhpYTBza2l1QU1qOFF4OTJWQVphSm51RUJQMW02bm1wRTdrNXFTNVpZZkZDdWxObTNML0R6bVJxOUlhUnFzSytxOEFDNmlIWEJvM01Fd3gyWVJrbHc3NXpkNGJyUDRFTEZIV2pHSmdOUEp3ZWlCVXZSdy8vRld5bzlrRThHcGUyaGJiRFlpL1V0L0JqQzdYTU9SaEEvSTV1MEtMVUxkQnYrQmx0djBWUG5Ta1o0TXU5SEJuaS9CL0xnQnhTVTFwUGR5a1hPTEgzM1RGcm9zRnNycXVhQjAzV0RqZUE5S0kzRUFpaEF1dWtJUnBHUUlGUE1PTFEzQjVqVWxEdVhBVS9QMkYyYjMzSzV5NFRFdGdveVU5MHE4QmZoSjNvVExmLzZOb21IME5aUzVQbDBYRnlwQnoyeGlscy9RTHk3TXhPSldvc0xHdFBqWjd4UCtZbWxEc0xLVWp5ZmNTR051cnpMbWVHSG1lZ3I1cGF1b2NXcjdXTVBtZzQvNFpxU3VKZ1VqSTFqWFN5U0EwUEZIMjNFbXdybDdoUlkyMGYxejRvbDZJM2ZyL3JkdDYwMEZWWWE2a2RtNlJQOC9mYlIzUW0yMkg1TFcyU2h1WElrMXdHTkVONjVGZUJ0cXFTMGF6L3luMlpwVDBFUC9qOWZ4N1NYTUNNUjdxK2d1anBISXBHSnpOY3IwWmd5RGdzcTdpUnNuMDRjR2FINkFrMDdOeVVEWDk5Qko4SmRJMFdRNUZTTnZhS2M4ZkI0ZUpmL3kycThOWXVVL1F3WnpBVmNocS9SRTI4Zm1sK2R2bDUwNmE2QTcxaUI1WTlzU2dJUkhWbUhSOEQ0QTFRcFNMcEhaRllxOWlSNFIzRkpJeFZjT0dhaWZwS1liUVpNUEtweS9EMDZGeHNhVytxUThxRlNkSWJyL1BzVzNGVlZFMGx4bU1ETk1zNE14dTNzS25WUE9obk9FTHcyZVdLM3p2N0I1ang2OWt2QXAxaVE4dFJNM0JWOElnOW5XTUIrdG0xcWN2cG5kUzdvbERNeGlZcDdjPSIsImRhdGFrZXkiOiJBUUVCQUhod20wWWFJU0plUnRKbTVuMUc2dXFlZWtYdW9YWFBlNVVGY2U5UnE4LzE0d0FBQUg0d2ZBWUpLb1pJaHZjTkFRY0dvRzh3YlFJQkFEQm9CZ2txaGtpRzl3MEJCd0V3SGdZSllJWklBV1VEQkFFdU1CRUVESDk4SDNjOWRFODVvdjdpYndJQkVJQTc2YWNmZnpJUkJPbHRFNXZ5VzRoWnpEcUJZU1k3NVM3T0hZSnd6dDAzaDQwUENreEJhcDJqc0o5T3k0TTFZY0hkQ0RJM1p4Wjl6bm1wbXpZPSIsInZlcnNpb24iOiIyIiwidHlwZSI6IkRBVEFfS0VZIiwiZXhwaXJhdGlvbiI6MTY5NDcyNTA3OX0=" ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
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
