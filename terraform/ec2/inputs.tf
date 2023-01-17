variable "project_name" {
  type = string
}

variable "vpc_name" {
  type = string
}

variable "vpc_id" {
  type = string
}

variable "rds_az" {
  type = string
}

variable "instance_type" {
  type    = string
  default = "t2.micro"
}

variable "key_name" {
  type    = string
  default = "responser"
}

locals {
  instance_name = "${var.project_name}-EC2-Instance"
}