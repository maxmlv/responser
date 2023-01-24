output "rds_address" {
  value = module.rds.rds_address
}

output "rds_username" {
  value     = module.rds.rds_master
  sensitive = true
}

output "rds_password" {
  value     = module.rds.rds_password
  sensitive = true
}

output "rds_port" {
  value = module.rds.rds_port
}

output "rds_engine" {
  value = module.rds.rds_engine
}

output "rds_db" {
  value = module.rds.rds_db
}

output "s3_bucket" {
  value = module.s3.bucket_name
}