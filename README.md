# Shipment Management Service – End-to-End DevOps Project

## Project Overview

This project demonstrates the implementation of an end-to-end DevOps lifecycle for a Java-based Shipment Management REST API application using AWS and industry-standard DevOps tools.

The objective is to automate the application build, testing, code quality analysis, containerization, deployment, infrastructure provisioning, and monitoring.

The project follows a CI/CD approach to deliver application changes consistently across environments.

## Technology Stack

| Category | Tools |
|---|---|
| Application | Java 21, Spring Boot |
| Source Code Management | Git, GitHub |
| CI/CD | Jenkins |
| Build Automation | Maven |
| Code Quality | SonarQube |
| Containerization | Docker |
| Container Registry | Docker Hub |
| Infrastructure as Code | Terraform |
| Configuration Management | Ansible |
| Cloud Platform | AWS |
| Container Orchestration | Kubernetes, Amazon EKS |
| Monitoring | Prometheus, Grafana, CloudWatch |
| Scripting | Shell, Python |

## DevOps Architecture

The project follows this end-to-end workflow:

Developer → GitHub → Jenkins → SonarQube → Maven → Docker → Docker Hub → Kubernetes (EKS) → Monitoring

## CI/CD Pipeline Workflow

### 1. Source Code Management
- Application source code is maintained in GitHub.
- Developers work on feature branches.
- Changes are pushed to the remote repository.
- Jenkins monitors the repository for code changes.

### 2. Continuous Integration – Jenkins
- Jenkins triggers the CI pipeline when code changes are detected.
- Source code is checked out from GitHub.
- Maven executes unit tests and builds the application.
- SonarQube performs static code quality analysis.
- Docker images are built after successful validation.
- Docker images are pushed to Docker Hub.

### 3. Containerization – Docker
- The Spring Boot application is packaged into a Docker image.
- Docker images are tagged with appropriate version numbers.
- Images are pushed to Docker Hub for deployment.

### 4. Infrastructure Provisioning – Terraform
- AWS infrastructure is provisioned using Terraform.
- Infrastructure configuration is maintained as code.
- Reusable Terraform modules are used to organize infrastructure resources.

### 5. Configuration Management – Ansible
- Ansible automates server configuration.
- Required packages and dependencies are installed.
- Application deployment prerequisites are configured.

### 6. Continuous Deployment – Kubernetes
- Application containers are deployed to Kubernetes.
- Amazon EKS is used for container orchestration.
- Kubernetes Deployments and Services manage application availability and access.
- Separate environments are maintained for development and production deployment.

### 7. Monitoring and Observability
- Prometheus collects Kubernetes metrics.
- Grafana provides monitoring dashboards.
- Amazon CloudWatch monitors AWS infrastructure and application logs.
- Alerts help identify infrastructure and application issues.

## Project Objectives

- Implement an automated CI/CD pipeline using Jenkins.
- Automate application builds and testing using Maven.
- Integrate SonarQube for code quality analysis.
- Containerize applications using Docker.
- Provision AWS infrastructure using Terraform.
- Automate configuration management using Ansible.
- Deploy containerized applications using Kubernetes and Amazon EKS.
- Implement monitoring using Prometheus, Grafana, and CloudWatch.

## Repository Structure

The repository is organized to maintain application source code, CI/CD configurations, infrastructure code, and deployment manifests separately.

```text
shipment-management/
│
├── src/
├── pom.xml
├── Dockerfile
├── Jenkinsfile
├── .gitignore
├── README.md
│
├── terraform/
│   ├── modules/
│   └── environments/
│
├── ansible/
│
├── kubernetes/
│   ├── deployment.yaml
│   └── service.yaml
│
└── scripts/
```

## Project Status

This is a hands-on DevOps implementation project. Components and automation workflows will be developed and integrated incrementally as the project progresses.
