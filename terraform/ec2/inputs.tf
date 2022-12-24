variable "project_name" {
  type = string
}

variable "deployment" {
  type = string
}

variable "min_size" {
  type = number
  default = 1
}

variable "max_size" {
  type = number
  default = 1
}

variable "desired_size" {
  type = number
  default = 1
}

variable "vpc_id" {
  type = string
}

variable "vpc_cidr" {
  type = string
}

variable "public_subnets" {
  type = list(string)
}

variable "db_port" {
  type = number
}

locals {
  tags = {
    Name = "${var.project_name}-${var.deployment}-ASG"
  }
}