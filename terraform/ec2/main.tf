data "aws_ami" "ubuntu" {

  most_recent = true

  filter {
    name   = "name"
    values = ["ubuntu/images/hvm-ssd/ubuntu-focal-20.04-amd64-server-*"]
  }

  filter {
    name   = "virtualization-type"
    values = ["hvm"]
  }

  owners = ["099720109477"]
}

resource "aws_security_group" "this" {
  name   = "${var.project_name}-Instance-SG"
  vpc_id = var.vpc_id
}

resource "aws_security_group_rule" "allow_ssh_owner" {
  from_port         = 22
  protocol          = "TCP"
  security_group_id = aws_security_group.this.id
  to_port           = 22
  cidr_blocks       = ["217.24.161.215/32"]
  type              = "ingress"
}

resource "aws_security_group_rule" "allow_ssh_ansible" {
  from_port         = 22
  protocol          = "tcp"
  security_group_id = aws_security_group.this.id
  to_port           = 22
  cidr_blocks       = ["3.120.233.223/32"]
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

resource "aws_security_group_rule" "allow_https" {
  from_port         = 443
  protocol          = "TCP"
  security_group_id = aws_security_group.this.id
  to_port           = 443
  cidr_blocks       = ["0.0.0.0/0"]
  type              = "ingress"
}

resource "aws_security_group_rule" "allow_nfs" {
  from_port         = 2049
  protocol          = "TCP"
  security_group_id = aws_security_group.this.id
  to_port           = 2049
  cidr_blocks       = ["0.0.0.0/0"]
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
  source = "terraform-aws-modules/ec2-instance/aws"

  name = local.instance_name

  ami                    = data.aws_ami.ubuntu.id
  instance_type          = var.instance_type
  key_name               = var.key_name
  vpc_security_group_ids = [aws_security_group.this.id]
  subnet_id              = local.rds_related_subnet
  associate_public_ip_address = true

  create_iam_instance_profile = true
  iam_role_name               = "${var.project_name}-Instance-Role"
  iam_role_path               = "/ec2/"
  iam_role_description        = "Instance role for ${var.project_name} EC2"
  iam_role_tags = {
    CustomIamRole = "Yes"
  }
  iam_role_policies = {
    AmazonS3FullAccess = "arn:aws:iam::aws:policy/AmazonS3FullAccess"
  }
}