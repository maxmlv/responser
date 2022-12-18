module "vpc" {
  source = "terraform-aws-modules/vpc/aws"

  name = local.vpc_name
  cidr = var.vpc_cidr_block

  azs             = var.azs
  private_subnets = var.private_subnets_cirds
  public_subnets  = var.public_subnets_cirds
  database_subnets = var.database_subnets_cirds

  enable_nat_gateway = false
  enable_vpn_gateway = false
  create_database_subnet_group = true
  create_database_subnet_route_table = true

  tags = {
    Terraform = "true"
    Environment = var.environment
  }
}