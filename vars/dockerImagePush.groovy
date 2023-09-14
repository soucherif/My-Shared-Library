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
     
     docker login --username AWS --password "eyJwYXlsb2FkIjoicHpOdVA0bnZMQUZRcE0xL294ZGlFb3g5UTI3VTdBUS9od21kV01icTNUdlVhQ29XaFNkNlh5bFBaQXR0Wm4rcjkzNFNUMWtYVFBCZlhUZlFiaEw5eE90SVJkTkVSMGNhWnBzaytWeUd0bitNQlpIOHNVS3JtK016UnZkaXp4cDJwVjhzeFJMdDcrS09mN2hKZFBPTzRNZi9FOS9kL0hOd0NpejY0a2FLOEZLbWpRUzlZaHQ4VHlSd0NEQ0ZvKzZwNUpWS3p4ZHdldjFIdC8yVGFndGVSa3FiOFo5RXZ4SWZneHlKVGpBRmRGRk1VZ0dLSlg2MjF4VkNPMTdHd1hpTE5DbXpmbVRMQTdRZ2xsT1F0bEE4L1d1d255QjlOQ3JLZVpEblZWdHNTRmdSaVhwci95NzRLMVZhQkFPK3pEeFVGQnliRExqNUpQZzB5TjYwS2g0SDNybzNaMHloU0UweEVSSGZ6UmZCWWNzUXJiMmVxcm05U2IxdWcreWYzdTAyKzdRTXZLTlJ2bk1vMUhwZkxkVTcxbUtEWi9wNkhOUkorZFNNcXNOVUtwcTFXMDllTnJYRXpwa3NXNjhIWDI5RU8vdVFMZHNUT2hYaFI5OWFPUU9uZGlIa2sxNk01aCtQcWZzT2RkMWk3bS93Z2MyNUZsSUFFL3Q3WGZMWEdKY01iSFFZUXluNG1MS1VlWUh5WEpGZDhPY3VCV0xDd3U0S0FiaXRBeGFHNTVrZXdDaVJ4TTFFVXpKK0lUcVlaaERMRGRwaEQrY1dVL2JUMEhPVEZadFFaUzRPMWlBanlmUGdvYi8zbDljOC9OM09sMTZUcWZWcGVzb1Yva3BzNi9LV2xRSDJWZHFkYTUrbXlEQlR5QWVrWGJsNXdSQkowK0FrT3lnU2RFUGZuYzRoQ0g1SUZHNUdDbUYrNGE4ZkdiUzZOZGFhMzR0TDFHUm1rOXQ0UjZrdHU2QmE3VGRwdWFuOTNiYk5PV0dIM2g4djMxbHNISThQRW1wakVBRjBJOUl6RnNlR1U0ZndSaVZGVXBPajRCMnc3WW1uWmJKZEVmaTNGSUx3YjhzTkFsTmpYOS9QMmEvYTJHM1lrUU90QzBUSHBBQ1RURUxFdXN4eXlDbHp4RUNKT1NiR0VHbEs3NmZTa1BKaDRoTmpjRWtVQlYxTzFidUVRRFo2RUJ2S0VhZ1hvTUlibVJjUUpkNnNBTDNhNVh5d1loNksrdUtHd1JXTVF1VTVDU3pha2hmbEhRVDJ1d1U1alZLbUhkR3BNYjVYN2x3b0w3Ti90N1pFM2YvTmFaKzZuYjM3dVp3L3ZMUENvMWhoNFpIaG4xNUQybzdlYlgxUThIeFVTb2dhZlNqbTFEVHcxUzc2TU9pZm1iRU5YUkk4bzUxWFhIbWEyQnBPNXZtSXRCUkNaV1dFaDFsVHlOQURVWTRqMm8xWTJuWWxmTGVWNnU3VmlvVHRLMU94aUg3NzJRWmpmbGRXNExnT0lmVEpydnNUdkpPZmU4K2ErQ1NKS3duL2ZvcGdJUHVqSlgwdGdLSGRRUjl2bmhGMmlwMWQ4NHFkZzcybEVsc0Z1RGcvaDh5cnIrQ01ST0E1TkFMbFphWGpLWTJnRzdBVTR3QnBNblYvck16cjJxK1hoWXJwK2VtNFpWNVZoL3VDdEE5cHVHclppVDJTS0NKNSs0V2lZaUdyVFBkZnhCM2JjYkg1Q0JXVUF5SUJvSFJaRy8xUzVjYWcxOTdoL3FMaWtxOVAwQmJNTDkzeENZL1RDazNveUZzPSIsImRhdGFrZXkiOiJBUUVCQUhod20wWWFJU0plUnRKbTVuMUc2dXFlZWtYdW9YWFBlNVVGY2U5UnE4LzE0d0FBQUg0d2ZBWUpLb1pJaHZjTkFRY0dvRzh3YlFJQkFEQm9CZ2txaGtpRzl3MEJCd0V3SGdZSllJWklBV1VEQkFFdU1CRUVES1lRaGx5M1NCeGJkMDY3K1FJQkVJQTdObHJ3WUdidHRPY1E0RjVFZi9LUnAyRzdybEFGZXRNOG9KbUkzaTAyMnhYZ0FUYjZnREZMNmx6aHlTMU9ZOWJaS1paOGRmRkdmazFyRVo4PSIsInZlcnNpb24iOiIyIiwidHlwZSI6IkRBVEFfS0VZIiwiZXhwaXJhdGlvbiI6MTY5NDcyNjg5Nn0=" ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
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
