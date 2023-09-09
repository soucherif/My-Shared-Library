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
     
     docker login --username AWS --password "eyJwYXlsb2FkIjoiblFKb3dQSXE5aFdqczYxQ3FzYm54ZmJZdmNiVi9WYWpIL0c2MVp4QWR3L0hvKzNhQmNmemNKeVlPazcvWHRiWWZMUm5MSGxHQ294cXZIcDkvVWFteDZJR2g1MmovUmpOWEQrbkNmaE1pVzdOMmRhZUVMR1BZbVNRMDB4SlR5ZWliN0ZYQlhHbTkyT2p3Q2RJaThuZGx4UzBDYlJ3ODB2cUFHY2lsUTQ3L09CYVdmT0ZUa1V2cjVMVG1uR2NoQWJHZmJtSzZlS0NUejk2UFRwWlFKTStJSGRpM2FKUEcwWjlReU9sU2phK0YxY3NyZlg1dzlpNTgya3dSZkdZaFNaN0RiSE1rUGlRSmdsbFVaaSs2M2J4T0xYNEV6cEQxYWVMMTM5eTJFckN3VDlwRkIvc0dGNjRtUVQyQVJOTFVkaFZLblpXbi9rb0N3WUpUR0NJQ1FmdXhyaVo1bmErMmZFdU9VSTdrUXg3QndhSEpmK0w0WVk0YVhvejJiRGpHWXc4V1FuSWhkbEZmT1QyNWZkNXRJc2JwT2N1Q1dXT2twLzN6a1RaNElNWS9QZTk4dUNLRk9qRTN3Qk95TEFRbENIdDZlYzI2SEZVVFV3eWYrTVpOaDFjSHJiRGh4bjZERStNRTZFd29xak56bHRxTlB0eUphSm9WZStWZWZtMFBXMGJZZ0NoUlpYbEI5Q0MweHhPa0FkT3pwMjdaOUpkditWbzlwc1o4STJPbGhwRzF1RlBWOGthbFdkT0JHOWlEcHBDNVRlSmd2L29YWDNwdW5xY2U4MHI1UTVXTWRsMVV1RWZMaU1QRDZJRE1EcGprNmdpZ0FjZzhQdy9LWWw0L0lhd2VxbmdqTVRRVHcxbTZ4b2xVeXJtazZKWTdqU3M1bVVxcGUvT01XWDQ4aXBITk9hTmROMzUxR05ieWpUU2hrQUFTOE83bXAyRGRDblBOMUhHeWZaK0Roa2w2dEdMSkpWL1VFK21KNm9TZGhJeWp2bFRsdkt5MzRnYXdtdDVGZTBoSkl3T3JDaHp2bEtlM3FZYlpyM0ZjTWpqd0NnVWdUb2xnZUZBS1k1SWVuV1dBZCtWOTNOMFdLcGRzYlBUVE9OUkM1RVl5RE9VUWRULzZFQkphczlqNld6bmswalBxY0NHVmU1T3lhVHBqdXNVMVJMc2ZmOWFudlNNNGg2T2d2RFJWYTlYckdaVFY5bGxnaWQxUkNIWWEwWGZERTQ1TGFKRWRUZGpwcFpJS3MyOWVROUFqdU13OU81Zkc1RUVYcHI3RWJSYjJuK0tSdFBOamNJRDJ1QXZNMVVNTWdwU3BxRHhseHl1dTFqSTlHVThDMmJ1OXFXdTlRdHN4YkxjS0J0VmtxZkRIam0wNjI0cmYvdUZPa1FRZFJhaFJlM3BXbkJCY2pBSlJzRjJheEJqekZ4ZHlla1FKSmxMaS91Z1RUMC9DNFBLK2QrM082b1VlVytmall1Q2JFTXBoSm5UeVVtYm5KT255YkpiaTJscUlFUmJkNWw2Q2htNG5ERFpnS0dTRFcxUFBTTC9kdmk3NkhJaHhQdWlCbUZ2QUNodld0N3FTMmJybm5BSDM2TFRuNkRMWXVjS2Y3MXVtQVdzNEZ5UDNtYXRPS3dsenkvV1daeGdGMWlJQ0ZyRnZVN3pzT1hzSXVhb2VzaDk3by9SYXhycWZFWCtjWW5uNkNnczNZbzBJNzdtMWMzcjBMbFJ2LytBdGZ4QXFTVWdpaWJsTWJhd1pVN0NkVXFqWEJYYXNWanRJZUVGS3dvOFFwakh5WlpxK0QyRE0rWT0iLCJkYXRha2V5IjoiQVFFQkFIaHdtMFlhSVNKZVJ0Sm01bjFHNnVxZWVrWHVvWFhQZTVVRmNlOVJxOC8xNHdBQUFINHdmQVlKS29aSWh2Y05BUWNHb0c4d2JRSUJBREJvQmdrcWhraUc5dzBCQndFd0hnWUpZSVpJQVdVREJBRXVNQkVFREUwaklZQXl1N0xzb25hV2xnSUJFSUE3a2ZRUm4xKytacXNsTEIzMzE0WkN3K0s5QVZsekhlLzUvMEt3UG9HdGMwc2Jqc1prUFRMV01zMXhBNVhwZGk4Ni9LeGVrc1RJcnJDWHNjZz0iLCJ2ZXJzaW9uIjoiMiIsInR5cGUiOiJEQVRBX0tFWSIsImV4cGlyYXRpb24iOjE2OTQyOTg4Nzl9" ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
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
