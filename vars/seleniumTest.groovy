def call(){
    sh """
        pip install selenium
        python3 seleniumTest.py
    """
}