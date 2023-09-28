def call() {
    withKubeConfig(caCertificate: '', clusterName: 'minikube', contextName: 'minikube', credentialsId: '', namespace: 'argocd', restrictKubeConfigAccess: false, serverUrl: 'https://192.168.49.2:8443
') {
    sh " kubectl apply -f atm-app.yaml" 
}
      
    
}

