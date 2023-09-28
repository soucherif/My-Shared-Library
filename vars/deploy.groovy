def call() {
    withKubeConfig(caCertificate: '', clusterName: 'minikube', contextName: 'minikube', credentialsId: '', namespace: 'argocd', restrictKubeConfigAccess: false, serverUrl: 'https://kubernetes.default.svc') {
    sh " kubectl apply -f atm-app.yaml" 
}
      
    
}

