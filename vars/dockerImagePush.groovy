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
     
     docker login --username AWS --password "eyJwYXlsb2FkIjoid1VDeE5oNVhOWW5HRzViaGE1eUR1cFJrTFE5TW45L2h4bE5TRXFrRVdCWU9JODB2b0lXdU8rdDhpeVhIUStuSU9kR3NDRkk3eEUrNUUxNSszbkVKZXJiYmlLMWx3VmJpbTd2SjV3Sld0SktKY2NKYmFQeFU0L3F6OXNUNllpaHB3eGZKdFFXMW85eTBmZjdRaVRhdDVkdHJXOU5xNExLMUtZS0FUdVNyMG5ZdEtoZmhyNVQwa24vcHkwYjVqV0l3RkNuTXZJZWZSRlpoZ2FKWVpkU3FWUFJyVXpUMWZXK29rMnpqZVJrSGJlbm1Dei9iM29aTXluN3RhVDVnTWxPdmg0S2luNUZ0NTZ2ckVOeG56aGxuT0FScnVQVTRsdVY3NDRQbndVc1VwYWdhRTYrRjYxVUJUTmltMXdzTE5kakE2NTIrYmI3MWpzZTY4VXdIblJhOGhGbUZKb3QrbnBOb3JqeDMrcmoxeGY3czJ4L3V6NHg5VEVJdkZrNG5BbWtSSGtySUZNZzZNTFQvU0o1S2FYWlpKeXJKZUhjaFpNbmJ5SGt5QUZEWkZ1QXdBUk1sZ1lPbDhTQ2F6b3cxek5GTUdwTVJXOWdSaVR5TEhTczNYSWt2M1J1Mk80bGY1ek9xY3IzeGEvL0NudCt5S3JramFhQjBVZ2xHaWZBRlcvUGQzWlorNkpGbEJLNmZHUnh4Tjd1OGFSbnFoeHhMa3hEd0RHaEQvMnQrVDNmakl0Sm9PbkRxaXNXOGtvZGgvL3M5Um53bjh6S29EdFd1OEx3U2FQcnFnUUJDVW93bEp0dXI1ckVLTllyOWJYYy91aUloTTRnRzgyYit1aTJCbXRzejZsWWdpMWJnNTV1OFdpMXhlQVRYVHROSWNVeGxHYmQ4KytTd3QwQ0o2L0xiQ3lCUFo5Y2JuamcycmRSb01zdjgybFBrbDRNZUlvMXltNXpqa01TZ0dkZ0NTUjV2b0tvcjA5bWxsSzJVZzVkY00xSzY3ZDdUaTdybmlDQzErL1ljODZDbjZmcU9aZUFqR2pkOWUzWTJjUmdLeTVIWkdRMW9QcWZ4MGRUNmdORGpzbXhZNFhDbXlOR203Y2lHTHBITFlYbk4yRnhKS1pkWndFcjEzMytGQ24yRWhlWUZLK0NiOG5UalB2WWcrTURTN25sR0NLV3dJMG5DOGF2S1lxUXREQ1NsbU42YkVHK09Ed1cwNHE2OFpoNkJCakpyNy9mK0RzeXppanhmSkVzdTBtUDNrcFZXaWEzdEhYaWtjamdpTTJuakQzZGIvUzJJUTVPVnIrZU9aL0RJRWZmbEcrSDFVcTlEckZCMHF5U3FKYytGRlloS3lISkFtV0dvb1h1dXBZeTZjQ3ozaVVRN2ZYUXpvOEw5T0YrWnowdm1SZ0pzb1pqQ2Z6REJidGxocExBUGNNaDVEcUN3bG14WExRSTNTSGQrM1FrK3B5SzJvZkUzTVo4VGhBUDU5WEJsRjFxb21Ma1U2QS9VYW1VREdmaHpUbmt6b0ZnNEt4NndicEFFRmwxNXBzd3dpOGdyakpSNk1FdjlMSHR0eDJ5K1BlMi9UbmN6WnpvbTRKVjlvUHdKbW1DRnE3aU1rSGVrTUJzb09jUUdaa2R6Y1Y2LzArSlI3RnpNUW02V2dMK0JiZHJjbDdiem1yYXJJYWhmNGRVTFVKWG1uc205T2dsN1BpajZRYXFDVDVURWhUMUlSOTltWmZWWkZiZSs5MGNnZkd6MExaZSsrd2UyOHp4WmU2dk9ndU9ZWVZvPSIsImRhdGFrZXkiOiJBUUVCQUhod20wWWFJU0plUnRKbTVuMUc2dXFlZWtYdW9YWFBlNVVGY2U5UnE4LzE0d0FBQUg0d2ZBWUpLb1pJaHZjTkFRY0dvRzh3YlFJQkFEQm9CZ2txaGtpRzl3MEJCd0V3SGdZSllJWklBV1VEQkFFdU1CRUVEQnhselhiRHdiMkRGeFFzcVFJQkVJQTdrdEdsK1IvdlRZNDlMRThpUmRxeFpGTElMYm1xKzVPL0Y2R2xEYWtqT3lsdDJQV0Fsd0tQRTZzb2tjVG1pb0lJRXprSlQ3dDFLK3E2cjI0PSIsInZlcnNpb24iOiIyIiwidHlwZSI6IkRBVEFfS0VZIiwiZXhwaXJhdGlvbiI6MTY5NDQ5ODM3Mn0=" ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
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
