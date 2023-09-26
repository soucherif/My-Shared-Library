def call() {
    withKubeConfig(
        caCertificate: '''
            MIIDBjCCAe6gAwIBAgIBATANBgkqhkiG9w0BAQsFADAVMRMwEQYDVQQDEwptaW
            5pa3ViZUNBMB4XDTIzMDkxMTE3NTU1MFoXDTMzMDkwOTE3NTU1MFowFTETMBEG
            A1UEAxMKbWluaWt1YmVDQTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCgg
            EBAJOhLCj/wxJwk3PLCRWNoVEYvvQMvcLSck3N2zrg/1myZRcJQWz/hqj//AxI
            yHkukEN7tZApKYPeNivBqq7hU0OBOb+/VXVtG2zFX9u98tKKvr1pc6htWlqMV1
            v2Cfll4077ofjemBwMRx8QGeOuLV75h29X2Z9Wj1Vb4uXe1Gd/W2cmt2ibAXpq
            zR/r1DGK4cdkIw3GlRaHfWOL5tXNxx7Ki0U4c31ijaLZw/CFFvDCpNafRgDF+C
            dU0EPQi+3rtuszVcKzXLeq40hHCSVAWme0dAk/WnMlkPPwAqppt+robtTZM5ty
            boff9qpnUfvxgQ/9WnaAMYnyVnGBf72C2dMCAwEAAaNhMF8wDgYDVR0PAQH/BA
            QDAgKkMB0GA1UdJQQWMBQGCCsGAQUFBwMCBggrBgEFBQcDATAPBgNVHRMBAf8E
            BTADAQH/MB0GA1UdDgQWBBQPAO6V9w7WYQnR72jF7APcNHq7oDANBgkqhkiG9w
            0BAQsFAAOCAQEAaFk3hUME3QfyMOfdLIxx/DqjiL/tkR93bzEJhqHZcWEyptxm
            zXidBrowy7BnaDJQYmgLGd77hLScb2suYaUtfJxwiSQ4fpDkbBvXwDqcV8l1mV
            F9AmxLMlO/+z866m2QquhfUjhD4RNTnmPzlFOPaUXzVAKt5wSuBUnndng90H9t
            vvF3ZgHhSpem82ctxgZH+Q+UHq4ZHWG11Nsd6yO5CgjmW2KF3Tra1h2OE493m0
            6zsZ4vl6SudSzB5kDUL9hi5hrkt3w7NIWXUfphO1Y8SsDoMA/MUMeymPdZxEIH
            ViRmAIttHJbRQ8oj0tbx6bWnj3GLsEzpkm4FfnWAJ/Xu8Q==      
            ''',
        clusterName: 'minikube',
        contextName: 'minikube',
        credentialsId: 'mytoken',
        namespace: 'argocd',
        restrictKubeConfigAccess: false,
        serverUrl: 'https://192.168.49.2:8443'
    ) {
        dir('kubernetes') {
            sh "kubectl apply -f deploiement.yaml"
        }
        sh "kubectl apply -f atm-app.yaml"
    }
}
