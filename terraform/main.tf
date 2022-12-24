module "vpc" {
  source = "./vpc"

  azs                    = var.azs
  database_subnets_cirds = var.database_subnet_cidrs
  enabled_nat            = false
  private_subnets_cirds  = var.private_subnet_cidrs
  project_name           = var.project_name
  public_subnets_cirds   = var.public_subnet_cidrs
  vpc_cidr_block         = var.vpc_cidr_block
}

module "rds" {
  source = "./rds"

  allowed_cidr_blocks   = module.vpc.vpc_cidr_block
  database_subnet_group = module.vpc.db_subnet_group
  project_name          = var.project_name
  vpc_id                = module.vpc.vpc_id
}

module "s3" {
  source = "./s3"
  project_name = var.project_name
}

module "ec2_blue" {
  source = "./ec2"

  deployment     = "blue"
  project_name   = var.project_name
  public_subnets = module.vpc.public_subnet_ids
  vpc_id         = module.vpc.vpc_id
  vpc_cidr     = module.vpc.vpc_cidr_block
  db_port        = module.rds.db_instance_port
}

module "ec2_green" {
  source = "./ec2"

  deployment     = "green"
  project_name   = var.project_name
  public_subnets = module.vpc.public_subnet_ids
  vpc_id         = module.vpc.vpc_id
  vpc_cidr     = module.vpc.vpc_cidr_block
  db_port        = module.rds.db_instance_port
}

module "dns" {
  source = "./dns"
  blue_instance_ip = module.ec2_blue.ec2_instance_public_ip
  green_instance_ip = module.ec2_green.ec2_instance_public_ip
  weight_on = var.deployment
  zone_name = var.zone_name
}