output "db_instance_endpoint" {
  value = module.this.db_instance_endpoint
}

output "db_instance_port" {
  value = module.this.db_instance_port
}

output "db_instance_engine" {
  value = module.this.db_instance_engine
}

output "db_instance_name" {
  value = module.this.db_instance_name
}

output "db_instance_username" {
  value = module.this.db_instance_username
  sensitive = true
}

output "db_instance_password" {
  value = module.this.db_instance_password
  sensitive = true
}