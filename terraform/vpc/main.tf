module "vpc" {
  source = "terraform-aws-modules/vpc/aws"

  name = "${var.project_name}-VPC"
  cidr = var.vpc_cidr_block

  azs              = var.azs
  public_subnets   = var.public_subnets_cidrs
  database_subnets = var.database_subnets_cidrs

  enable_nat_gateway                 = false
  enable_vpn_gateway                 = false
  create_database_subnet_group       = true
  create_database_subnet_route_table = true
}