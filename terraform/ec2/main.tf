data "aws_ami" "ubuntu" {
  most_recent = true

  filter {
    name   = "name"
    values = ["ubuntu/images/hvm-ssd/ubuntu-focal-20.04-arm64-server-*"]
  }

  filter {
    name   = "virtualization-type"
    values = ["hvm"]
  }

  owners = ["099720109477"] # Canonical
}

resource "aws_security_group" "web_sg" {
  name = "${var.project_name}-Instance-SG"
  vpc_id = var.vpc_id

  ingress {
    from_port = 80
    protocol  = "TCP"
    to_port   = 80
    cidr_blocks = [0.0.0.0/0]
  }

  egress {
    from_port = 0
    protocol  = "all"
    to_port   = 0
    cidr_blocks = [0.0.0.0/0]
  }
}

module "ec2_instance" {
  source = "terraform-aws-modules/ec2-instance/aws"

  key_name = "maxmlv"
  vpc_security_group_ids = [aws_security_group.web_sg.vpc_id]
  subnet_id = var.public_subnet_id

  tags = {
    Terraform = "true"
    Environment = var.environment
  }
}