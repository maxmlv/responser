variable "project_name" {
  type = string
}

variable "engine" {
  type = string
  default = "mysql"
}

variable "engine_version" {
  type = string
  default = "8.0.28"
}

variable "major_engine_version" {
  type = string
  default = "8.0"
}

variable "family" {
  type = string
  default = "mysql8.0"
}

variable "instance_class" {
  type = string
  default = "db.t3.micro"
}

variable "port" {
  type = string
  default = "3306"
}

variable "database_subnet_group" {
  type = string
}

variable "vpc_id" {
  type = string
}

variable "allowed_cidr_blocks" {
  type = string
}

variable "master_user_name" {
  type = string
  default = "responser"
}

locals {
  dbname = "${lower(var.project_name)}db"
  identifier = local.dbname
  sg_name = "${var.project_name}-DB"
}