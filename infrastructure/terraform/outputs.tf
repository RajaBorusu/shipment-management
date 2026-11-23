
output "ecr_repository_url" {
  description = "Amazon ECR repository URL"
  value       = aws_ecr_repository.shipment_app.repository_url
}

output "eks_cluster_name" {
  value = aws_eks_cluster.main.name
}

output "eks_cluster_endpoint" {
  value = aws_eks_cluster.main.endpoint
}

output "eks_node_group_name" {
  value = aws_eks_node_group.main.node_group_name
}
