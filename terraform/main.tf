module "rds" {
  source               = "./rds"
  allowed_cidr_blocks  = var.vpc_cidr_block
  project_name         = var.project_name
  vpc_id               = var.vpc_id
  private_subnets_ids  = var.private_subnets_ids
  allocated_storage    = var.rds_allocated_storage
  engine               = var.rds_engine
  engine_version       = var.rds_engine_version
  family               = var.rds_family
  instance_class       = var.rds_instance_class
  major_engine_version = var.rds_major_engine_version
  master_user_name     = var.rds_master_user_name
  port                 = var.rds_port
}

module "s3" {
  source       = "./s3"
  project_name = var.project_name
}

module "blue" {
  source        = "./ec2"
  rds_az        = module.rds.db_az
  vpc_id        = var.vpc_id
  instance_type = var.ec2_instance_type
  key_name      = var.ec2_key_name
  public_subnets_ids = var.public_subnets_ids
  instance_name = "${var.project_name}-blue"
}

module "green" {
  source = "./ec2"
  instance_type = var.ec2_instance_type
  key_name = var.ec2_key_name
  public_subnets_ids = var.public_subnets_ids
  rds_az = module.rds.db_az
  vpc_id = var.vpc_id
  instance_name = "${var.project_name}-green"
}

resource "local_file" "hosts_cfg" {
  content = templatefile("${path.module}/templates/hosts.tpl",
    {
      blue = [module.blue.public_ip]
      green = [module.green.public_ip]
    }
  )
  filename = "../ansible/hosts.ini"

  depends_on = [module.blue, module.green]
}