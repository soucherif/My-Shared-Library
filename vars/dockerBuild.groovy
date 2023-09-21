/*def call(String project, String ImageTag, String hubUser){
    
     sh """
      docker image build -t ${hubUser}/${project} . 
      docker image tag ${hubUser}/${project} ${hubUser}/${project}:${ImageTag}
      docker image tag ${hubUser}/${project} ${hubUser}/${project}:latest
     """
 }*/

def call(String aws_account_id, String region, String image_Name, String image_Tag){
    
    sh """
     
     docker build -t ${image_Name} .
     docker tag ${image_Name}:${image_Tag} ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${image_Name}:${image_Tag}
    """
}
//sudo chmod 777 /var/run/docker.sock