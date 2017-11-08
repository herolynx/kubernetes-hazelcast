# kubernetes-hazelcast
Hazelcast prepared with discovery mechanism for Kubernetes


## Build

1) Build project

```
mvn clean build
```

or

```
mvn clean istall
```

2) Build and push docker image

```
mvn clean package docker:build -DpushImage -DpushImageTags -DdockerImageTags=<VERSION>
```

## Local development

Pre-requisites:

    * [minikube](https://github.com/kubernetes/minikube)
    * Maven
    * Java 8

1) Run locally

```
./run.sh
```

##### Run on local Kubernetes (using minikube)

1) Deploy all

```
kubectl create -f devops
```

2) Access local cluster

```
minikube dashboard
```

3) Checking address of local service

```
minikube service k8s-java-sample --url
```

## DevOps with Kubernetes

Service is prepared to be deployed in Kubernetes.

1) Deploy all

```
kubectl create -f devops
```

2) Access cluster

```
kubectl proxy
```

Then open dashboard in web-browser: http://localhost:8001/ui

3) Make new deployment (after changing image version in `devops/deployment.yaml`)

```
kubectl apply -f devops/deployment.yaml
```

##### Basic operations

1) Get pods

```
kubectl get pods
```

2) Get services

```
kubectl get services
```

3) Check logs of single pod

```
kubectl logs -f <pod_name>
```

If you have many containers in pod, name of container must be specified:

```
kubectl logs -f <pod_name> -c <container_name>
```

4) Deleting stuff

```
kubectl delete service|deployment|pod <name>
```

5) Rollout (provided that `revisionHistoryLimit` > 0 in `devops/deployment.yaml`)

```
kubectl rollout undo deployment/<name>
```

6) Scaling 

```
kubectl scale --replicas=<number> deployment/<name>
```

7) Get basic info about your services

```
watch -n 1 kubectl get configmap,secrets,deployments,services,ingress,nodes,pods
```