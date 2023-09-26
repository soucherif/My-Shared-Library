def call(){
    withKubeConfig(caCertificate: '''MIIDBjCCAe6gAwIBAgIBATANBgkqhkiG9w0BAQsFADAVMRMwEQYDVQQDEwptaW5pa3ViZUNBMB4XDTIzMDkxMTE3NTU1MFoXDTMzMDkwOTE3NTU1MFowFTETMBEGA1UEAxMKbWluaWt1YmVDQTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAJOhLCj/wxJwk3PLCRWNoVEYvvQMvcLSck3N2zrg/1myZRcJQWz/hqj//AxIyHkukEN7tZApKYPeNivBqq7hU0OBOb+/VXVtG2zFX9u98tKKvr1pc6htWlqMV1v2Cfll4077ofjemBwMRx8QGeOuLV75h29X2Z9Wj1Vb4uXe1Gd/W2cmt2ibAXpqzR/r1DGK4cdkIw3GlRaHfWOL5tXNxx7Ki0U4c31ijaLZw/CFFvDCpNafRgDF+CdU0EPQi+3rtuszVcKzXLeq40hHCSVAWme0dAk/WnMlkPPwAqppt+robtTZM5tyboff9qpnUfvxgQ/9WnaAMYnyVnGBf72C2dMCAwEAAaNhMF8wDgYDVR0PAQH/BAQDAgKkMB0GA1UdJQQWMBQGCCsGAQUFBwMCBggrBgEFBQcDATAPBgNVHRMBAf8EBTADAQH/MB0GA1UdDgQWBBQPAO6V9w7WYQnR72jF7APcNHq7oDANBgkqhkiG9w0BAQsFAAOCAQEAaFk3hUME3QfyMOfdLIxx/DqjiL/tkR93bzEJhqHZcWEyptxmzXidBrowy7BnaDJQYmgLGd77hLScb2suYaUtfJxwiSQ4fpDkbBvXwDqcV8l1mVF9AmxLMlO/+z866m2QquhfUjhD4RNTnmPzlFOPaUXzVAKt5wSuBUnndng90H9tvvF3ZgHhSpem82ctxgZH+Q+UHq4ZHWG11Nsd6yO5CgjmW2KF3Tra1h2OE493m06zsZ4vl6SudSzB5kDUL9hi5hrkt3w7NIWXUfphO1Y8SsDoMA/MUMeymPdZxEIHViRmAIttHJbRQ8oj0tbx6bWnj3GLsEzpkm4FfnWAJ/Xu8Q==''', clusterName: 'minikube', contextName: 'minikube', credentialsId: 'mytoken', namespace: 'argocd', restrictKubeConfigAccess: false, serverUrl: 'https://192.168.49.2:8443'){
        
        dir('kubernetes'){
            sh "kubectl apply -f deploiement.yaml"
        }
        sh "kubectl apply -f atm-app.yaml"
    }            

}