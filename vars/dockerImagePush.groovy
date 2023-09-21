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
     
     docker login --username AWS --password "eyJwYXlsb2FkIjoiL0xtbmhpMGNZNXJRMURaTGdvQ2paK2FZcHFSU2dnSzE2aUpiOCtYa0taOGFZazFuWDdhN0txekFldnc4Tm9uWEd2TnAyeVVDRzFJWEpuSHZ2VSs1Q1VIeXluZk5BbGc3NVRpZTk0V2JGRlZJaGM4M0dIQzBrcHNoa0JWQ0JzNmpsRnRzMTlMSURsREQ2bS8vY04zd2REUnVyeC9yMVRLS3laUlhtek5vaGxjTkphd3M1eTVFY0ZoVGN3MktGQ3RicWh5TTRYTzFuKyt0NXVmOFcxN081bDZybHVoSEc3Um94SjBkZjBnUFVkYXNXK2xBTGtaZzViYTc5WVdUaHdVVllEeTlDVE9zM3c2T3pZRTBYUlY4VHMrL3Bjd0MwZHJVNEJSVUIvWU4yNS9QT3NVaEE0dHJKL0hJdllaYUV4ZllocjdwTVJrOVFhRVJsVzhHWHRRTWZJOVNYcGE1MGtXeC8xZWx3aVVMd1BHcDVFMGx4OEt2R0FnL3hVRG5qMVBDcWZBL2s0YXl3a05FY0pEOWtjZVhEaU9GSU91VFM0Z1BkQjBSR2VNc3JGbkZWOG9KT2g5ZERTRzhZU1ZWWERrV0hFMExQdHk3TW9ndzhWaUdKM3FWaEpyQkl0azA5cUprNCsvbDhad0hTenNncWQvVG1uQXh1a3hTOXdQbHNYcStqMk1yWkRpTWl2OGhqTnl2MFd2bXJiZCsramp1c3NpSzJZMDVyZHFZTnpMQkhIc1lidUVmc3QvcHZnOGpKSklRSXhZQVNRbEVnOS8zbzdiSlRIWlNOSmF5dnUzbjBYRlFxNzZzd2JzbTlKcmRZd2o3ZGVKdTF1ZnU0RzJEM1RtUEoyeE5CZ0NSTmdzK0t0KzhSTkd0NnpmbkdHTEhKUUVOS0lVVVk0Mjgxc2U0bXZheDRiamZRVmc3SnFVbW9NM1FpdlJacVBId21sUEtXeGk4Q0hmTFMrdysyOW01c291OTBITlcrV250Si9UUk9sdUNrZ09tTlNSdjNBL2J3QzhkckZBekNKam85bEZHRUM4VVFZbGFueXlPdHRxTFUyTTBrQllkSU9LM0hzdFViNm9MZkM5ak13TnowNStyOHFEM2dHQnk2R2F3V0paYXZmUG03WGl1bFZTZ1ZaaXliMmdhZUdVQ2kzcXBEMXAxOUhqSStVTUpONEdwbmEyS3hsMjZFTC9nTkM0aVhUZWZ5bURiZVpkeUJzT1dHMzhnRkVYNy9VWGx2YnYzNzdGSENwb3RkOUtvM2t1V0w2d3o1WTZObTU0VVU5S1VqYWg3TXJ4YTZCRmk1bExaYXZoQW5rVnJXOWhuOThTVVhXV0hueWh6OWxvTXIrWE1nanZDaEFxSkpWcVdKaHZHR3NUVWNyVWJoeVd0ZlVOUllCK2RWaVBWWEFGTzRwK0ZQZko3NWtQQVFWaVBheUo0Q004aHgyZDlMVW81bjFLOU1NdGwzNEtqWkpiWjdRcnAzYTJCTXZncUtUTlhsSEJvdzMvTElMUVVwY0U4MUJpMXN3R0dDbmhMYlBmVnMzeWJ0cWNYQ2FibmRxTVowVzhLbExZR0VYUzRVZnNPVHkvcndPVjFZSCtaUXh5aEhRNDBROWFQOXNLZkQ0Uk5SdjhrUzFYNEpEeHVwaWlDQWJaY3BwZ3l4MFJxY21hdUxyalROZlNkRkEzLzFyM0tiMEwrOVY4K04rei9DQjhHcGVYamJ1dXBUQVYxZGtJQmk3dTArMW9Ga2srbFpCTkRPZEpLWW5mUTVMZlZCYk9DWUpNPSIsImRhdGFrZXkiOiJBUUVCQUhod20wWWFJU0plUnRKbTVuMUc2dXFlZWtYdW9YWFBlNVVGY2U5UnE4LzE0d0FBQUg0d2ZBWUpLb1pJaHZjTkFRY0dvRzh3YlFJQkFEQm9CZ2txaGtpRzl3MEJCd0V3SGdZSllJWklBV1VEQkFFdU1CRUVETkQ1RUw4WTFYRWJDTTNSakFJQkVJQTdkaHdmazhpUTlCNmhycXpMWmhxZGpQQUw2MEM2c2JHZHdUbk9KN0Yxb01ZaVQ0dEEwOXF4aWtlWE5tU3gwK1JUTStCTktxeUI4WW5vTW40PSIsInZlcnNpb24iOiIyIiwidHlwZSI6IkRBVEFfS0VZIiwiZXhwaXJhdGlvbiI6MTY5NTM0NDkxMn0=" ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
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
