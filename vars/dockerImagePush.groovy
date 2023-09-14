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
     
     docker login --username AWS --password "eyJwYXlsb2FkIjoiMlY2Q0FkTDN5b1JqWUh0Ni9FZFRQZ2JIbUNaRC81RmZDYkprVUw2cExxZnJGUDVCa2NJZ1ZlM09xMUZTclZ3SUpGRzd1N1U0N3pCU0F4L0tySzVtbGZuUjBZNkpFVHM2emJxUVB0WFQ3ZWNJM3kxVDF5SElWY2poN2FycGROTlJmSGorUGRiUFN2RjcrOXhYQXZrdFF0RThyY2FEWkZBQ2wrQnZHVUVVUUk5eDVHdHpnbjZFS29Qd3kveFQvci9KeHZINE9hK0dYWGo5RmZwNnQwdVNhdWY3NmdrWk55WUVwMzNtTmxVOXJKVXZka2p2STRUS0hjaEU3U0NvVE5TSk93eU55VFN1a3NtdGlXLy9nV1QrNENBK0tBQUFkZVBtUFFJU1hhVTlwbHpucnRNdG9VcThTR3N1NkZWOE9kd200TVVELzRmelNMdVhuV1ErYTlRME9keGdWVHI4cXZVUUtKMWFoT0pxM1hSOWkyUUhIZnRiQU9ZRCtzZE9BYmk1ZjNDa3RKM2tKNnVvUStKSTFmS3AydCtWMHExcXRXL0hycFpXZnBVSmwwSzBGWUZOaG9RU3JoTjhnRkkyUE5SeVh5U3V0S1VDdW5UT1Y0b3ZBQlFBL0tTbmtoUXhva1ZlMnBKTUU1ckRmeGRsbXF5UmREaVl6UmlzK3ZWMkM0NHZyajU0ZWgwVHdoZ0RlTklVQU5IY21JeWRMYXVyMk5UV3RtRzUyc0gwYUd2c1VML0lhY2ppaWdBT3g3dnFPamh3S2RRNmNmRkdrRkxXK3JCZGZNUjc5eXExMUQvNVM2Tkxib0VUSldUWGYzeWVMdGsyM2YwOGVmR3l2eWpta2pkNy9oUlluV0hOazRFQ3N4dDFjNmNGRjUwODdoMk92MkVaVGN6R2h1VGQwQmt3NXgyRjJYMEpkbkMyVTZrMVZNZ1BFSGdydGYreVhBQkhFbDdYRTFyUnByZFNYZG8zUGJibGo0d0J5VEoxSVhKZVFteVppRnd1TU5ESFFkbThOMG9VczAwd2ZuVjM2bWRUWWJhN1VyR0JxczVPTStZVFA5b1R0WDl0VEgxVEd3R3gvbWg3dGZIV3dYcmtjbERnV2wrNW5QRUVPWEI2MHg4R2RyUTk2Q0NEelF4UmZNeFVpTG9VNFdTeEhyVFN6M0ZBaCtjdHBnZ3NxcnpEV3pDRFZwVlpDMndDZktqMzh5RW1ScUp1cllFZmdOQzRKRGVZSkhzd1lKMkxEOFpaM1FWUXY4eFV4UHN1KzBGdWZqRG1xRzRhTFFheHFBQ3drMTFuSTF4ejF1UDVBSjhaUzcrbFZnK2lyalc3ejA5dW9wRERGQnloeUZaNjNHVG1jOEY4empndFJyb3lHVVRJOCtxMlQwWWU2RlJFS1hyWXpRQmZPM1F2S2s2bnl0UXFHRjN2TWYxcnZ0cjl3WERGQzdMQW0xWHFUU1pvc0ZqQlQ5TjdRTXBxbkRtdjc1T3FnN3IrNldKQ3dId2VGcEY5MEtmR2dmcU8zemxZMGhJMDJOV3BOaFBHY2hyOW9nK0ZSZGprTVhNQXZPZXhRNkZNWWsrZStJLzBOQWF0SkoxTU9uUlpmZGhNK0xKOGNqSDM5MjhQTUxiV3dVckJlOEZYdENPUzlXZVI4TjZuMjR0ZXllNExvZW82aUhkR0FsOHJXNHE5OXFpWWRvcGVlb2l4NWxRa0xjM3hqNlErSGw4czE5MkU4NDhtR0FjMG5TT1A4UzVqb0FVb2M5d281Ynh0Z1R6SVpIZ1E0M1V5SlVBPSIsImRhdGFrZXkiOiJBUUVCQUhod20wWWFJU0plUnRKbTVuMUc2dXFlZWtYdW9YWFBlNVVGY2U5UnE4LzE0d0FBQUg0d2ZBWUpLb1pJaHZjTkFRY0dvRzh3YlFJQkFEQm9CZ2txaGtpRzl3MEJCd0V3SGdZSllJWklBV1VEQkFFdU1CRUVETHI0TWFYUzFZQUpDelk4SVFJQkVJQTdybXpMMEZkYkpEUC9ERU1TZGhIS21raFl2eGJTNzE2YktLcU0wVDBFSDV0WWFNYTk0KzlqWW9lam8vRWJTa0ZxVHF4UmRXZCtkRFBMWWxnPSIsInZlcnNpb24iOiIyIiwidHlwZSI6IkRBVEFfS0VZIiwiZXhwaXJhdGlvbiI6MTY5NDcyNzkyOX0=" ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
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
