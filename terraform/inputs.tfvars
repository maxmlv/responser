project_name = "responser"
zone_name    = "responser.space"

vpc_id              = "vpc-084941534017532f7"
vpc_cidr_block      = "10.0.0.0/16"
public_subnets_ids  = ["subnet-004e9e2be4f9a5e97", "subnet-0c3c69b1e5cd5a71b"]
private_subnets_ids = ["subnet-07f4b66c0b9f63b68", "subnet-04e6de576ac13b68e"]

rds_engine               = "mysql"
rds_engine_version       = "8.0.28"
rds_major_engine_version = "8.0"
rds_family               = "mysql8.0"
rds_instance_class       = "db.t3.micro"
rds_port                 = "3306"
rds_master_user_name     = "responser"
rds_allocated_storage    = 20

ec2_instance_type = "t2.micro"
ec2_key_name      = "responser"