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
     eyJwYXlsb2FkIjoiMDE4V2pmeGJ1WmFkbjBGZjRIT28yUloyT1RHa1Zhc3ZvVnplZHJoVm1OellyajhDL1FUKzc5QVNuRnlRYUg4SGp3NEIzZWR5bnpvSlBaczY1am9zSVNWc1lkSm5rQ3pNMXYwWmNkdHd2cXMveW5leTBMMCtsU1EwTDcwMjAyWEkvaXpGb3phVFBxeHZvTGJ1M1hWMUZMK2NDYlc5MXRwTVdseVBDVStCUDhkTTdEdUxRbXlEQjZGejI2YUhpa2ZpOXdkM05BYW1vYkQvQTkvNkZ3TnFnNWkzdUtzSGVCT3FvTFR5YmFlTDUwUWg0Q2drQXU2R292TnlVcWlwUjRtdzdCK1RuM09zVWF1R1hHN2Y3SGR0R25DbHF3MXNwVEZQUS9tYXM1enk1UmNkZ1E3TFJuZFFZcVE3L3J5UmIxeUIvS2U4NmxtZ2pJUlhTNVVnQ1pjdFVzQStMU01BTElmWDMzU01nQWdDeUo5QW9TdUNMMXlRKzRYN3hmR29RU0Noa3ZOa0h0NEp5VTFpSzlzeDZSZ09Kelhad1RDVTBMTExWelRTRS9vVzZvOWdjQ1I4WUlQS0lYaWYwWmFwTWY4Snp1NHN6cUl3WG4xZit4aGRPUmlBbm1DRjJRY2txdWtiVVNlUUFpSG5pdkNBOVg0aktZZzliR3JPWUQzWU9jZC8yQkJ3RWg4ODlQNXJjVnkrQlZLOXpBODZ2TmNzUnd3bmdnME5vRzNHa3JlaVVuK1MvbXJ3b1pWU0QvVUFUQ2xLWGNnQTE3cjU4cVM0RUE0YjNKajA4V0x5UUdldEdpNjhkWXNDN2ZPSGkxZk1nTXBnQ3E2MFoyc3JzTHg2Qy9MeWhPMkZqSHFiK1VWY2Z1UFFvYnhXZENZTTlUQ2FuRFVUV3ZocStEN2xENDFlWHlJZ3VkZkFTVlNibzdsREYxV2E5a3FSMXByVEsrZmdrTGd2MHJ5MEtBQ3lLelYxcnh4VGJKbit5S1R5WGFlYVF2eDR5dDZVS2hJOUJPRnRPZXhHR3IvQ3QxNWJnV096S3JxK1dxVVhHb2xBTDg3Sk9ZYkJVQ2d5NTloQ0JkUVFtdWxzNndlOFNwYmdIZHBmdVRhbVhEbW44cGJBeW9XaEx2V0NiS3NmQTFSUVVEWUlzck1sWEFMdXlxZ040YXhIY1ZoK0I4L3RvMG1EdDZtWUlBVmQ2ZkU4ZFdYNWF4Qmh2M3UxSGVFemJYZG81OEdSWU4wUTZKZjZzNnFDZ1pvR1dWS1Rkam1xckNqM2M1SkUyOUxTY2ZmZVA4QkRtRnIySWw2RmVLbC9Ca0cvd1piRXZ4OU8wbmNqZGMrY1l3dENNOFBYT1daM0NBbGJSOWphREdDRmlyeW1tdEpJdFRUSm9vNmtrYS9pM294NlJoSXk3SGMyRmhGVHExdUJ1OERFNktFTXNEUmpBQldXWUxjeVJzZnRySGF4TUNHNWMxZmlTZVRoeGRHdDZ0aDdDd2s3blkvWjZLRFFqQnA0KzZlSFVBOFBmcU12cDY0ZUllU1V1aDl2c2x5VStyVUlMVUpnZ2dwRHVGNmt5WnVVYlBSMXFZaDdRU3RiRCtMODlCcElSM2REVjc4ZERwb1NsTE84NGc3d0tqZndwdURrNUVURVZXcXZqUkhwbUhHdTFoR0lEOGNvYTNMNmtaSzZEVFgwYjdKZWh6bkd6SlBUelBlUjBpeFdvQlBjVWdrRkg5L2hOMHcvMWJXWGNCZTBVMHMyK0VjVjdTcUJVTDVJZ1cvRGRxVlptMXJTKy9rPSIsImRhdGFrZXkiOiJBUUVCQUhod20wWWFJU0plUnRKbTVuMUc2dXFlZWtYdW9YWFBlNVVGY2U5UnE4LzE0d0FBQUg0d2ZBWUpLb1pJaHZjTkFRY0dvRzh3YlFJQkFEQm9CZ2txaGtpRzl3MEJCd0V3SGdZSllJWklBV1VEQkFFdU1CRUVESzQ4ZHgzdVlYUVUzZHRZS0FJQkVJQTdBdnhvMXBENW02bjN4WUhYNS9tTnV3OU9KWDV4a0NWbFJXWE9SOEZ1K1ZvS25vblRFdWpjYW9iZk1nZjZKL2U1Z1RROTNiQ2tqNmtXbGo0PSIsInZlcnNpb24iOiIyIiwidHlwZSI6IkRBVEFfS0VZIiwiZXhwaXJhdGlvbiI6MTY5NTM2MTc0Mn0=" ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
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
