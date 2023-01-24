output "db_az" {
  value = module.rds.db_instance_availability_zone
}

output "rds_master" {
  value     = module.rds.db_instance_username
  sensitive = true
}

output "rds_password" {
  value     = module.rds.db_instance_password
  sensitive = true
}

output "rds_address" {
  value = module.rds.db_instance_address
}

output "rds_port" {
  value = module.rds.db_instance_port
}

output "rds_engine" {
  value = module.rds.db_instance_engine
}

output "rds_db" {
  value = local.dbname
}