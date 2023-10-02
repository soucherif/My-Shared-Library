


def call(String aws_account_id, String region, String ecr_repoName, String image_Name ,String image_Tag){
    
    sh """
     docker login --username AWS --password "eyJwYXlsb2FkIjoiREdnQjUvczI2WHhTcnhIQTY4UXk5RC9nUGZ3WjJNZDhjRFU0N1FYS3hYc1QvNlRNa01EczBSZjlHTUVQNENLY3VBM0I1NG5TTGJhdW1KSGtSSXpkc3Z6U2ZRVS8zb0RoR2V3WHc4L2t2aGVtYWlVZ2lYUXBPNHNXTW9OMSt1T1lFZGlDd3Y1WDIwOGFRRzdRY2x5bXR3Y0pXaXNyQ1EraWtwSE41V2NtUFNRSlpGcS9QSDNNYzk5SC9qck5sOEY4N094Snd3NGxnL281eGNrYjlSTzI1RkFqZ2tZeWk1cERZU1phQUlIRVJDOFVFL1d3S1FsTzJqMlkvWC9GRER3U1VoOXQ0aVc4dXpJb0lBL0dkNmtLQjRzL0FycHBBSVh4RlkzSjdnWlE3a3ZHeXBHTjZOYzlVb0dWUWp5QXhQdmJFMkw0MHVUVVhhcE9CdjMxTVNvem5iTkFVVmNjY29MOVNDcDdveEVEalNEckQzaE5aaVNvTkJ2cDZ4eGZzTFpmUjFNK29nL3NZMHQ0akR4SGVPdENwSWZTcTMwVnNZSjAyUGxHOXFEYTdHMDBXa3dXRGtnWHNQOS8wWlpzeUR2YTE3VzlIQmc5WE9vbVZ1b3d1Skx5TndTZ3F1dkFXOWUyZXdkZnhFOXZqS1BnTWt5UG5MUHp2VDkrMzhRbWw0TThuWm5zQVhnRndMaEYwSW41MnF0NmtxOC9pY2R0ajVHWVFhZk1PZ1pIalBIR0tCYkNiTGdnRGtKN2ZWcEhDdUF0Ni9hZUZPR0Q0cVBHRkg1V2hZcjdtQkNPM0tPTlQ3cVhiK2VVSk1EQ0lFMUppZWdwWTBXZ0JIR2Q1K2djSTVMam9IaTYwSyt1b0JaeHl3NXREbkdoVkR4Y0ZEMWdMcldvall2RldHd1VWVWtkMWF2cFc3M0Jlcm5KVXBaSGdFd09zd3ptMVdQRjRleE4zcVFUWXl3NEJFbEdpam4xVmtuYk13b2ZRNVpELzhhSEFOclF1aU5ER0FoR3Y1dkVESFBsY095eFFqTnRLV2x2cW1zS2JPRE1TRFUveTRBektxbkFBcnp0RnpXcU9SZ2lZbjh1LytjUklRWG9sUEV0SkQrdm5lK0ZoV0pvbVkwNTR3eXEzVk5IcXZLcWhNM0RabXVVQS9vbXlHb2k3aW5LWXdPOXduNm96K3FjVlNrWHlvNHhuWmt0RUY2Qk0xSDRSKy9DY1orR0RtRno0ajEwUHZnK1F0Z1lWenh4UkdNT0xBWjFSaE1wOURERGgySE9mMklKaHZwYVlYbzZlcGlpK2FkanVlZE9Lc0RDU0lhZndZUXc0QmJNSC9xdU1tS2MrME84K3dWN0hjdkVDZEZ4VjhYdTVEUU9Ob3F6aEw2VDd2YjhaTU9JWHIwdkJaVFlIMkphL3VNTGhnanpPZkcxeG9VRWY5YlhxcE9kUXZhK2gxbFJ0TjVzWUJBa0sxeWpzdSt0NmsvbmR0YUZWWmZEcDFST3BCNDQzZk92MXJ5Y25EbU9jalJvcE5vZlJZMmQ3ZERYbzg1YVR5NE5Xa1hsUEg1Vlptck5ieGdxVUtYM2Q2dCtnZjhmTjBDMVlzanJ6VTlhcnpaem9lY2JYMHA4SW5EK2xGYmVNZUZ2MWptTjV5cWZiSWlybFVYUS9odlh6OFpaR05XK0pmdUxqWkJwQ2doMlF4ZFdkc2tlQytmUjVzRTNGeGRkM1FsZFpJVjcvQW5CSGY1WHZ3bVE1Q1JicHkxQlNqdWtxNzNjY295RWx4UnYyaDc0V1RrPSIsImRhdGFrZXkiOiJBUUVCQUhod20wWWFJU0plUnRKbTVuMUc2dXFlZWtYdW9YWFBlNVVGY2U5UnE4LzE0d0FBQUg0d2ZBWUpLb1pJaHZjTkFRY0dvRzh3YlFJQkFEQm9CZ2txaGtpRzl3MEJCd0V3SGdZSllJWklBV1VEQkFFdU1CRUVETmpvbWpjMWZObytFMTZvamdJQkVJQTdMSHIvVENqaHFyWjg1VWwwbmNnUUU5MGxYQlJzbVVWRC9ZNE1VWXphdjBTdWQ5bS9QYkRhZWRuamRIdERUUEVmYkp2ckl6bVNEYzhYSkljPSIsInZlcnNpb24iOiIyIiwidHlwZSI6IkRBVEFfS0VZIiwiZXhwaXJhdGlvbiI6MTY5NjMyNTg4N30=" ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
     
     docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:${image_Tag}
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
