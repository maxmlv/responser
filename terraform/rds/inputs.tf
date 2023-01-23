variable "project_name" {
  type = string
}

variable "private_subnets_ids" {
  type = list(string)
}

variable "engine" {
  type = string
}

variable "engine_version" {
  type = string
}

variable "major_engine_version" {
  type = string
}

variable "family" {
  type = string
}

variable "instance_class" {
  type = string
}

variable "port" {
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
}

variable "allocated_storage" {
  type = number
}

locals {
  dbname     = "${lower(var.project_name)}db"
  identifier = local.dbname
  sg_name    = "${var.project_name}-DB-SG"
}