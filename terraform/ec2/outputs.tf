output "instance_name" {
  value = module.ec2.autoscaling_group_name
}

output "ec2_instance_public_ip" {
  value = data.aws_instance.created.public_ip
}

