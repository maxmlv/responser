module "vpc" {
  source                 = "./vpc"
  project_name           = var.project_name
  vpc_cidr_block         = var.vpc_cidr_block
  azs                    = var.azs
  public_subnets_cidrs   = var.public_subnets_cidrs
  database_subnets_cidrs = var.database_subnets_cidrs
}

module "rds" {
  source                = "./rds"
  allowed_cidr_blocks   = module.vpc.vpc_cidr_block
  database_subnet_group = module.vpc.database_subnet_group
  project_name          = var.project_name
  vpc_id                = module.vpc.vpc_id
}

module "s3" {
  source       = "./s3"
  project_name = var.project_name
}

module "ec2" {
  source       = "./ec2"
  project_name = var.project_name
  rds_az       = module.rds.db_az
  vpc_id       = module.vpc.vpc_id
  vpc_name     = module.vpc.vpc_name
}

module "dns" {
  source        = "./dns"
  ec2_public_ip = module.ec2.public_ip
  zone_name     = var.zone_name
}