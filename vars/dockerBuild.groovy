

def call( String image_Name, String image_Tag){
    
    
    sh """
     
     docker build -t ${image_Name}:${image_Tag} .
     
    """
}
//sudo chmod 777 /var/run/docker.sock