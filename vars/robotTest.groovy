def call(){
    sh """
        pip install robotframework
        pip install robotframework-seleniumlibrary
        robot robotTest.robot


    """
}