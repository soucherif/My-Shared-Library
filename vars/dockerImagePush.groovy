


def call(String aws_account_id, String region, String ecr_repoName, String image_Name ,String image_Tag){
    
    sh """
     docker login --username AWS --password "eyJwYXlsb2FkIjoiUVFjcW1IWnpIamtZem5iQkJWZTJDVDVmelFLNFI0QkZWRTZ5eDQzMjV0OFFhWHZ6YUVpeFM3c2hsb0hVUmswNmJ3bUtwYmpkKzhBUzVuNHVSaHR1eWN0S2lmd0xLem13a2VVT3ZqQm85RURCTW1CKzE0aVBTU3pzM3RJMW9XaWljWitENGpNaXY2cjdkdyt1US9oOWhtb1ZKWDcyS0JzQ1ZNL1oyekg4ZGZhZE5Gblg3MHNvWmUwOHlRU1NnNnNlZVVkMVQwSkFuSm03NnI5d2lRT0pSaEpycU5ObTVmMnp4bnBmdGJHKzEwaGNqUEJWRGlsYmx1VkYvOUhpUmRLVkV5YldJbENMbU4xQVRiRzBCZTFSZnhyNmRDdmFDTHQ3aGVoYmt2UTVkeGFSM292MHAvZjIzd1VyM250U2ZsQng5RHFBYTVQVXRRT3hBbW1nM2dmTGJZT2toVXJUZFJrRjZweFIvVG9JejZudWVqYlhqMG9SQWpTN0FJcTNUU3hmaFBNUW9pYktSdWk5eVhmVStCTW9lS0puZWhuZzA1Wm00QUwrTVhoVW1LRmM1ekw4b1VOTmY4TTdOZm5lcHpQVGFBYTJ2MWVGUFFjQThHRFFRd1hNbFFoV1pocnVacjJEajk3VU1ndmIzaGV6MWluQWppRnhZT3FGRWhLZXFBN0dlMlo4Z3N3cXZqeEc4ZUh0dFZhcUVPVm1PRFdYWDdwblB5TGVqcnNuZDdQRkJ3N1FRV0l5TzNpY1MwaktMVVpkMjJLa2M3Y2p0UWh4dml5YjJtVlFVYWJqWmxmYUJEM0lJcmpzQWtSZjIycUxsSHlyRWEzUTI2V0hDNGQrMW8xaWJvNHBncjNkSUZ4ZlhaakJvTXJzK3poNHc1bU84U005c0s1R2JKZDhGSmtzN0tiUzZTcjlvZVNmU3UvL0hPM1ZrTDNvblBFSndBSnNEVkQxSEF0eFpqc1d0RWdBN2xQVjdRckRISStnL3NMdEpDNEVIaHVpM0xVR3o5MG40blhWdFFsbG9JRk42QnV1ZlFhMVJaMm8xeXdhemM0d1FnUldQcGNIa0dpZ2xoZXNadFRnLy9IdUZQc2pzNWRqcUhUSW1Kem9oVTZmZjhNVUxqQXBUZUMxU2tTaWMrV3hLaXdCb29XdFhuK0tGVVQwUERhcG00ZHRzaWp3c25QZ05DeTMzL2todjI2SGdGK3AyQWtGRUVyQTRzQlk1d0MvYVV0cWR3ZGxkemFxT281RkxhNUNOSmd5OHByaWR4K0FNemgwUFhMMlljZGZhTXVUMWRUcGlIeVdnUjhqRithcWN6b1VGaDFtc3dnc3JCcVNOWXVlTFd5ZXFjU1dtSncwQldOa2NBbGJ6SmtQd2tWbXlEQ3g4ZGxHN2V6TlNVelNobUU5Q0RRcmdhTk1SdEhlcmQ2cHNQV3g4VS9VdHQwaGJyRE8wZXhOWmVUVFZ2VGZublB1UmxkTVdOeUE5VWNXbW5CeE1FZ2Z3UHNuNk5HSWRiNGt5dHk2NW9FS2U2U2dGZzVydSt2RWFLWFJnL1dreWlJMklaUEc1THd1UDB4NFZNa3RseDJBeHZpNFEyemsrRytCWDN1TktxUTIvbXF4eFZHMWw3NnVneDlDbzVVbkhvTFJEc0w4cnFPMEJtUWxWQ2J2MC93UUFzem16d0ZBRWU4aU1OaG45M0ppQTI1dFZ1blVkZmYxa0V0eU94cUxuNk9XSUYzcWdQVU9qUmpHbWhUWldmS3YwN3k0NHhIcUpBNVdxK0FYWHhZPSIsImRhdGFrZXkiOiJBUUVCQUhod20wWWFJU0plUnRKbTVuMUc2dXFlZWtYdW9YWFBlNVVGY2U5UnE4LzE0d0FBQUg0d2ZBWUpLb1pJaHZjTkFRY0dvRzh3YlFJQkFEQm9CZ2txaGtpRzl3MEJCd0V3SGdZSllJWklBV1VEQkFFdU1CRUVER29RUHV3dk02SEF5VXU0a3dJQkVJQTd0QmcrWHFrRXBFa0VYbWRUM0FlR2pTUlErV2NRaktmNGt0eEFTYVZ3VEFMZ3Nyc2tjak80WTJoV3hTbU1KQ2RRRm1JUlUySGgxYVlxc2Q0PSIsInZlcnNpb24iOiIyIiwidHlwZSI6IkRBVEFfS0VZIiwiZXhwaXJhdGlvbiI6MTY5NjM3Mjk1Mn0=" ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
     
     docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:${image_Tag}
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
