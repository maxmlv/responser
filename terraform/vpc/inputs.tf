variable "project_name" {
  type = string
}

variable "vpc_cidr_block" {
  type = string
}

variable "azs" {
  type = list(string)
}

variable "private_subnets_cirds" {
  type = list(string)
}
variable "public_subnets_cirds" {
  type = list(string)
}
variable "database_subnets_cirds" {
  type = list(string)
}
variable "enabled_nat" {
  type = bool
}

variable "environment" {
  type = string
}

locals {
  vpc_name = "${var.project_name} VPC"
}