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
     
     docker login --username AWS --password "eyJwYXlsb2FkIjoidVh4QmE2NUlMVzFuR3Faa1hCamxvRTRJbmNKamdWNkJWOWJROVhmSVEreU1DYnBrNXNGNTFmODlrYmI4WHQ2SUhMZHJsSzZabjFFT1V0YU9oQm45YklEcjQ2dCtTRGVyZ0pUT0UzK1ZkV2VmZzYrVXJhVjJkMCtYRzNuOHMveWpzZm5vUVIrUkc2MnBZRU13aVVBWEVERlZPSVRJdTB3Wk9sWlNqdTJ5WmpmQkpCZjVvWGZsTTd0d2ZuazU0aEVtajNFVHNNUWNOdFdZUEpYdzljTmFZaFArN1FFSXBSU3IyemsvcGRaYXowMEE4b0hhTHhXdVExY01IZThvekIzZ0RCUEdvQjJmWm5OTVJQM2N5OUwyYS80L3plWGRvSWlUQ2pEQ1lCUDZmenR1SjVPQklkT0xuOXEyUmxQcG85YUc2YmNnV3ZhK2pZNTF3R1NyT1NBMWdhV3phb1FERnlBcEFXcXNUU3pReFVZdGVJclRkMDJvOXBoNmQyOHQ3MFlWNDlnNVhIQU1zVGoyOHdkd3FuNWRZcmVTUGZhemhURlJaelA3U3pXdUVaQ1ZDb1BJdFh1eXBjR29JdFgyV2VKbGxNdVN0Q2lIZ0xlK3JzQlIzdTdNWFQvM3VzWGxxek8wWEIrOFdxRXU4djh4aXNJN3Vnb2FWcTJpT055MFZmSkR5S2I2Tm9Yd1IrU1ZkMHYwelh4NkRzVXZMSXhCSFRlUjc0dWlXK0x3dTZnN2tiVkFSQW5hblh6Y3ZPUzFsUG9IVmpGdWkvS0RLcnBjZWZaYmM3Wlc3NlhVMmJGNTJiei9Odm9GNzV1TTRhMlZDVG13MXhUVjVYM0lnUG1ZQXpwYjRTcnBZUXFqL0VwVUNkdDh6Q2EvblQ4NEhyQnVzS0E3MEJGTXM1Nmd5NXFyYThMck5SOWVyei9DZUQ4d3FjZEdJTHJMR2s3UWlOSFVyYVBHVFd1WTNpYXZRdkNQQklEWUpUdmFuR3JydTc5bTV5ZGVqT29wNkJNL1YwVmt4cEgyd1dqbWx2dWZrWHdLbGtob3l0V1RZaDczdS9QOVFESHJ4b1ZGWEdhR1ZZZ05sN1dkaXJHenBWSnZnTjZsT3ZlQWZXREI3TDg4Z0dWMFA4bTlwaEdRMys1NE1uWWNrVEpxdGl3L2tNWWhsK1V4RGpwQjdZRlBYc0N0cms1UC9LbHYxcHRVeGh4SGExV3J5cEdCRFo2ZE5LWkwzblAwUmdHTHl6YzZNcHB2Uk54cXJJNnd4UzdRa05iNTBMWDA4NlU5bFBkV2ZrM2FJSzNmc09pd2FEa0RqOENROGtjM0tZZHU2NWFjN2lBME4xRXRJa3JVY2lGUEMyeUQzLzRrSlM4SHVPOWp3NlYyUytPWXc0c1pqeWMwcHFkRjd3QnBmSVFKVVRCc3B4aE9wRCtRNWh5K3hqT21TK3hXRTgxWnN4eGdyNXlQZXZZazFMbUFUSXlhbDlnTWUvQjdWcFEyRGxHZE12YTRNQWVpL2swV2FhVWpEc1ZJNmlEczgrYnhOdFdQbEJXb0QyVzRScTZtdUxHMlRtTlZhamM3ZVEyYkd1YVBuR0VqMUQ4WHA2TW83RmZUTUZEei9SRlRHZnVTU082SUhLYlp4Qk1OVWxla3YyUnpqR1VFaENLVEVFWE5jcklnbVh4bXM5eUN0MGV2VEJNaVNTN2hSbjJJTXlMenhMdFJoVERTSjNNSVdQNmJFL2FQbThIVVJ6R3lJWEFUUUtaV0Q1a00wNEUzZ3Qrdk1aNUFOSkNZS2ZFPSIsImRhdGFrZXkiOiJBUUVCQUhod20wWWFJU0plUnRKbTVuMUc2dXFlZWtYdW9YWFBlNVVGY2U5UnE4LzE0d0FBQUg0d2ZBWUpLb1pJaHZjTkFRY0dvRzh3YlFJQkFEQm9CZ2txaGtpRzl3MEJCd0V3SGdZSllJWklBV1VEQkFFdU1CRUVES0JLNHN4bW4zbm4yYVFIN3dJQkVJQTdFOGhaTFVxVk5XWFB0UUJxdU5QamQxMTVsZXJQNStjdVlyWUNzd05PZWUvTERoSGtkNHMxMGM5QWhTbjZkc2hQWndYVFp1alFhaG1ZaTBrPSIsInZlcnNpb24iOiIyIiwidHlwZSI6IkRBVEFfS0VZIiwiZXhwaXJhdGlvbiI6MTY5NTMzMzkxMX0=" ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
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
