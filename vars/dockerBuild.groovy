/*def call(String project, String ImageTag, String hubUser){
    
     sh """
      docker image build -t ${hubUser}/${project} . 
      docker image tag ${hubUser}/${project} ${hubUser}/${project}:${ImageTag}
      docker image tag ${hubUser}/${project} ${hubUser}/${project}:latest
     """
 }*/

def call(String aws_account_id, String region, String ecr_repoName, String image_Name, String image_Tag){
    
    sh """
     
     docker build -t ${image_Name}:${image_Tag} .
     
    """
}
//sudo chmod 777 /var/run/docker.sock