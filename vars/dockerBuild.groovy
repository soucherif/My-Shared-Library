

def call( String image_Name, String image_Tag, String aws_account_id, String region, String ecr_repoName){
    
    
    sh """
     
     docker build -t ${image_Name}:${image_Tag} .
     docker tag ${image_Name}:${image_Tag} ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:${image_Tag}
     docker tag ${image_Name}:${image_Tag} ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
     
    """
}
//sudo chmod 777 /var/run/docker.sock