module "security_group" {
  source = "terraform-aws-modules/security-group/aws"
  version = "~> 4.0"

  name        = local.sg_name
  description = "${var.project_name} DB security group"
  vpc_id      = var.vpc_id

  ingress_with_cidr_blocks = [
    {
      from_port   = 3306
      to_port     = 3306
      protocol    = "tcp"
      description = "MySQL access from within public network"
      cidr_blocks = var.allowed_cidr_blocks
    },
  ]
}

resource "random_password" "password" {
  length = 16
  special = true
  override_special = "!#$%&*()-_=+[]{}<>:?"
}

module "this" {
  source = "terraform-aws-modules/rds/aws"

  identifier = local.identifier

  engine = var.engine
  engine_version = var.engine_version
  family = var.family
  major_engine_version = var.major_engine_version
  instance_class = var.instance_class
  allocated_storage = 20

  db_name = local.dbname
  username = var.master_user_name
  password = random_password.password.result
  port = var.port

  vpc_security_group_ids = [module.security_group.security_group_id]
  db_subnet_group_name = var.database_subnet_group

  deletion_protection = false
  storage_encrypted = false

  tags = {
    Terraform = "true"
    Environment = var.environment
  }
}