variable "instance_name" {
  type = string
}

variable "vpc_id" {
  type = string
}

variable "rds_az" {
  type = string
}

variable "public_subnets_ids" {
  type = list(string)
}

variable "instance_type" {
  type = string
}

variable "key_name" {
  type = string
}

locals {
  instance_name = "${var.instance_name}-application"
  rds_related_subnet = var.rds_az == "eu-central-1a" ? var.public_subnets_ids[0] : var.public_subnets_ids[1]
}