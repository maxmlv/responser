output "db_instance_endpoint" {
  value = module.rds.db_instance_endpoint
}

output "db_instance_port" {
  value = module.rds.db_instance_port
}

output "db_instance_engine" {
  value = module.rds.db_instance_engine
}

output "db_instance_name" {
  value = module.rds.db_instance_name
}

output "db_instance_username" {
  value = module.rds.db_instance_username
  sensitive = true
}

output "db_instance_password" {
  value = module.rds.db_instance_password
  sensitive = true
}

output "db_instance_az" {
  value = module.rds.db_instance_availability_zone
}

