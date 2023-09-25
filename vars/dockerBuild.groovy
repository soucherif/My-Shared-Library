

def call( String image_Name, String image_Tag){
    
    sh "sudo chmod 660 /var/run/docker.sock"
    sh """
     
     docker build -t ${image_Name}:${image_Tag} .
     
    """
}
//sudo chmod 777 /var/run/docker.sock