output "vpc_id" {
  value = module.vpc.vpc_id
}

output "public_subnet_ids" {
  value = module.vpc.public_subnets
}

output "private_subnet_ids" {
  value = module.vpc.private_subnets
}

output "vpc_cidr_block" {
  value = module.vpc.vpc_cidr_block
}

output "db_subnet_group" {
  value = module.vpc.database_subnet_group_name
}