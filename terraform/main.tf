module "vpc" {
  source = "./vpc"

  azs                    = var.azs
  database_subnets_cirds = var.database_subnet_cidrs
  enabled_nat            = false
  environment            = var.environment
  private_subnets_cirds  = var.private_subnet_cidrs
  project_name           = var.project_name
  public_subnets_cirds   = var.public_subnet_cidrs
  vpc_cidr_block         = var.vpc_cidr_block
}

module "rds" {
  source = "./rds"

  allowed_cidr_blocks   = module.vpc.vpc_cidr_block
  database_subnet_group = module.vpc.db_subnet_group
  environment           = var.environment
  project_name          = var.project_name
  vpc_id                = module.vpc.vpc_id
}

module "s3" {
  source = "./s3"

  environment = var.environment
  project_name = var.project_name
}

module "ec2" {
  source = "./ec2"

  environment      = var.environment
  project_name     = var.project_name
  public_subnet_id = module.vpc.public_subnet_ids
  vpc_id           = module.vpc.vpc_id
}

data "aws_network_interface" "by_filter" {
  filter = {
    name = "tag:Name"
    values = [var.project_name]
  }

  depends_on = [module.ec2]
}

module "dns" {
  source = "./dns"

  ec2_public_ip = data.aws_network_interface.by_filter.association[0]["public_ip"]
  owner_email = var.owner_email
  zone_name = var.zone_name
  environment   = var.environment
}