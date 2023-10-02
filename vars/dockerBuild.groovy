

def call( String aws_account_id, String region, String ecr_repoName, String image_Tag){
    
    
    sh """
     
     docker build -t ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName} .
     docker image tag ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName} ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:${image_Tag}
     docker image tag ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName} ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
    """
}
//sudo chmod 777 /var/run/docker.sock