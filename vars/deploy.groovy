def call() {
    withKubeConfig(caCertificate: ''' -----BEGIN CERTIFICATE-----
MIIDBjCCAe6gAwIBAgIBATANBgkqhkiG9w0BAQsFADAVMRMwEQYDVQQDEwptaW5p
a3ViZUNBMB4XDTIzMDkxMTE3NTU1MFoXDTMzMDkwOTE3NTU1MFowFTETMBEGA1UE
AxMKbWluaWt1YmVDQTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAJOh
LCj/wxJwk3PLCRWNoVEYvvQMvcLSck3N2zrg/1myZRcJQWz/hqj//AxIyHkukEN7
tZApKYPeNivBqq7hU0OBOb+/VXVtG2zFX9u98tKKvr1pc6htWlqMV1v2Cfll4077
ofjemBwMRx8QGeOuLV75h29X2Z9Wj1Vb4uXe1Gd/W2cmt2ibAXpqzR/r1DGK4cdk
Iw3GlRaHfWOL5tXNxx7Ki0U4c31ijaLZw/CFFvDCpNafRgDF+CdU0EPQi+3rtusz
VcKzXLeq40hHCSVAWme0dAk/WnMlkPPwAqppt+robtTZM5tyboff9qpnUfvxgQ/9
WnaAMYnyVnGBf72C2dMCAwEAAaNhMF8wDgYDVR0PAQH/BAQDAgKkMB0GA1UdJQQW
MBQGCCsGAQUFBwMCBggrBgEFBQcDATAPBgNVHRMBAf8EBTADAQH/MB0GA1UdDgQW
BBQPAO6V9w7WYQnR72jF7APcNHq7oDANBgkqhkiG9w0BAQsFAAOCAQEAaFk3hUME
3QfyMOfdLIxx/DqjiL/tkR93bzEJhqHZcWEyptxmzXidBrowy7BnaDJQYmgLGd77
hLScb2suYaUtfJxwiSQ4fpDkbBvXwDqcV8l1mVF9AmxLMlO/+z866m2QquhfUjhD
4RNTnmPzlFOPaUXzVAKt5wSuBUnndng90H9tvvF3ZgHhSpem82ctxgZH+Q+UHq4Z
HWG11Nsd6yO5CgjmW2KF3Tra1h2OE493m06zsZ4vl6SudSzB5kDUL9hi5hrkt3w7
NIWXUfphO1Y8SsDoMA/MUMeymPdZxEIHViRmAIttHJbRQ8oj0tbx6bWnj3GLsEzp
km4FfnWAJ/Xu8Q==
-----END CERTIFICATE-----
    ''', clusterName: 'minikube', contextName: 'minikube', credentialsId: 'certif', namespace: 'argocd', restrictKubeConfigAccess: false, serverUrl: 'https://192.168.49.2:8443') {
    sh " kubectl apply -f atm-app.yaml" 
}
      
    
}

