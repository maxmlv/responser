data "aws_ami" "ubuntu" {

  most_recent = true

  filter {
    name   = "name"
    values = ["ubuntu/images/hvm-ssd/ubuntu-focal-20.04-amd64-server-*"]
  }

  filter {
    name = "virtualization-type"
    values = ["hvm"]
  }

  owners = ["099720109477"]
}

resource "aws_security_group" "this" {
  name   = "${var.project_name}-${var.deployment}-Instance-SG"
  vpc_id = var.vpc_id
}

resource "aws_security_group_rule" "allow_ssh" {
  from_port         = 22
  protocol          = "TCP"
  security_group_id = aws_security_group.this.id
  to_port           = 22
  cidr_blocks       = ["217.24.161.215/32"]
  type              = "ingress"
}
resource "aws_security_group_rule" "allow_http" {
  from_port         = 80
  protocol          = "TCP"
  security_group_id = aws_security_group.this.id
  to_port           = 80
  cidr_blocks       = ["0.0.0.0/0"]
  type              = "ingress"
}

resource "aws_security_group_rule" "allow_mysql" {
  from_port         = var.db_port
  protocol          = "TCP"
  security_group_id = aws_security_group.this.id
  to_port           = var.db_port
  cidr_blocks = [var.vpc_cidr]
  type              = "ingress"
}

resource "aws_security_group_rule" "allow_all" {
  from_port         = 0
  protocol          = "all"
  security_group_id = aws_security_group.this.id
  to_port           = 0
  cidr_blocks       = ["0.0.0.0/0"]
  type              = "egress"
}

module "ec2" {
  source = "terraform-aws-modules/autoscaling/aws"

  name   = "${var.project_name}-${var.deployment}-ASG"
  min_size = var.min_size
  max_size = var.max_size
  desired_capacity = var.desired_size
  key_name = "maxmlv"
  instance_type = "t3.micro"
  image_id = data.aws_ami.ubuntu.id
  network_interfaces = []

  create_iam_instance_profile = true
  iam_role_name = "${var.project_name}-${var.deployment}-Instance-Role"
  iam_role_path = "/ec2/"
  iam_role_description = "Instance role for ${var.project_name}-${var.deployment} EC2"
  iam_role_tags = {
    CustomIamRole = "Yes"
  }
  iam_role_policies = {
    AmazonSSMManagedInstanceCore = "arn:aws:iam::aws:policy/AmazonSSMManagedInstanceCore"
    AmazonS3FullAccess = "arn:aws:iam::aws:policy/AmazonS3FullAccess"
  }
  vpc_zone_identifier = var.public_subnets
  security_groups = [aws_security_group.this.id]

  tags = local.tags
}

data "aws_instance" "created" {
  instance_tags = local.tags

  depends_on = [module.ec2]
}