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
     docker login --username AWS --password "eeyJwYXlsb2FkIjoiUEtKUlJqc1J3NHNlW
     UFXaFE1VUhtOFhycnhJY2F6R0QvZjVaSjJrUXFtY3JvQktFM2xGUlBJSEE1dmZ3dFZJVVlEa0V
     XSDRDZDRheXhIeWZXNVZmM2FpMkhPN2MwUndXZWs4dlJMK04va1hKY1N3NEJDRkZMWEprVCsvd
     kp5Z0JzOStWTlYzVndtQjM1Tmtidzk4dGU3eSs5dEppcE16Y2RzSmNmQnh4ZDN1a0tTWDUyK2c
     2NHdZcmxPS08rTUY0VGFwSVFOY0ttMnZjSE1ZejVBQWVoWHR3U1VZeHpxd0M4Vmd2WHY0ZlBiO
     G56VlVDNUFzUjdCeE0zanQvYnJKZWdERVE0a3BlSW9pc2N1cWFSN2ZNWWtxd1ZHcjRnZE9MSkt
     QNEN2VHBLdnFmV3FMby8wa3RJOE9vbTNIN3hDRWV5ZW1pbDdCTXBRelRZYURjcGZWbXZBY2lWT
     1Nqd1lkVzJ4N05rRi9iZkdoT1dZWmJXSitXTStlblJNU0FOcVAxVXVYdEV1K3g4UlR0Z2VSdzR
     mS3dubTJJSU9McEtCYU56eEx6RVp0NGNtUHBuZE5GNEdyeEtOUFFmK1BhZGtoMzg3STFiV3huM
     0V1SlVQMExzZndKdmRZckR1L0VXOUdGNnRFbCt0b252cFZZeVltczNWVnBmdnVUcElNOHhPbi9
     NOVZ0eEhNak9uWTFqZUFnVEdST3UvMjNCTXE3YVI2dFBVeHRFK1Q5Z3dPY0Rma0E4ay9HdzNod
     Ss1WkdiSzc5NG1qeFVDKzBacUpCWTJGNWI4WDNWZ2gxUFhKKzB3L0NrVCt0SUt5Zk9wTEpERXB
     taSs1LzYwQ2kwd1Q2Mk4wVlZyV2lobFg0MXg1VG5NeWdkREJyYWdiVWt6bWFFUHlQdm9BQ3JVe
     ml3bVBlc3lrTGVJZWNscnd2YzN1MlVSSXI4SU00SXRIbFY5K0tVU0JEb1NwQjB2YmV6dklyMVM
     4dWJMUjd0dGYzdkJqSXlFNjEyaEFhd3lUeEN2WThyS3kzOEVtc3Nyc3ZVSVBkM0thUk41OEFvU
     EdBRFd0MkptZGRQeU43czNPbkJxV3pPSk9NYjJEOENDWWFEeWhkSU5lLytWZXo3am5ia0xhODd
     0L2FTNFduTzlDTDd0MG9oUnVYblQ2eFVuc2FzSTVWaWRYNldmNkhjLzlSVm1yOHFxdGNMTjRiL
     zFkTHVZYXFMblo3cHF5SHgxUUJVNzJrbG80N3dwUExKT2ZEcXBaMnJVZTcrbWtSWG0vdnJHTHp
     WYi9TSWhtOHpiUmRGZ1cxWHFqNHowVkU3OEVvUWp6YkVyMHdIazhJb2lJOHVXaytURThDOHI3c
     mM2b0I0eEoxYkRGWml6LzBOeW1LTmNhUytUcSs2MXV0Y3Bicm9rMXZrVE5uQWhXckZwYU9BdlV
     6U2F0dHBUNFYyQnNIYjVpV2ZoQ3hNQVJla0lCKzdKbWZEbDlQUzc0aitTRllKTEM4K3BRbTk4b
     TlSajMzb0h5TnAzaFJlV29HRXlNTHc2Sms5YzNxekNuUzd1TEoya2FkREFtVDY4RkMyZFlBVDE
     vUGFpOXpjYVMxZnp4dUdVRVA0d1JVVkxmdzV4b0RFclBrTldZOEVxNmhXaGlWby9IR3p2MUF2V
     mFmNHkzbC80Vks5cDJldnYwUHZhalJiRVd2RVEwblhkNGsvbk1qYUxucWRlMHRGTlFnNGZDRTU
     5elJtY0pVNmQxeElCVEQ2MThtSDlmaGdBSkFoTkdEV0VEY1hRTVBIZHhaditrPSIsImRhdGFrZ
     XkiOiJBUUVCQUhod20wWWFJU0plUnRKbTVuMUc2dXFlZWtYdW9YWFBlNVVGY2U5UnE4LzE0d0F
     BQUg0d2ZBWUpLb1pJaHZjTkFRY0dvRzh3YlFJQkFEQm9CZ2txaGtpRzl3MEJCd0V3SGdZSllJW
     klBV1VEQkFFdU1CRUVEQlVwWmtSNzBSbk0vbEFUTlFJQkVJQTdZMGROTS9qR2FRdERydER6ZEl
     6T0oxZnhWdmRuM3JrQVE5QUdtYWJIUTJIYmJ3Y2NEenFQcU9UcGZmNDZ2OFhwRXVWc3Y1TWlDZ
     TJZTmxRPSIsInZlcnNpb24iOiIyIiwidHlwZSI6IkRBVEFfS0VZIiwiZXhwaXJhdGlvbiI6MTY
     5NTM0OTI5MX0=" ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
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
