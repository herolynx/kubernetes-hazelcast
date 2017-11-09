#!/bin/bash

mvn clean package -DskipTests
mvn exec:java -Dgroup.name=k8s -Dgroup.password=k8s