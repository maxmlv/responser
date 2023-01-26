variable "project_name" {
  type = string
}

variable "deployment" {
  type = string
  default = "blue"
}

variable "zone_name" {
  type = string
}

variable "vpc_id" {
  type = string
}

variable "vpc_cidr_block" {
  type = string
}

variable "public_subnets_ids" {
  type = list(string)
}

variable "private_subnets_ids" {
  type = list(string)
}

variable "rds_engine" {
  type = string
}

variable "rds_engine_version" {
  type = string
}

variable "rds_major_engine_version" {
  type = string
}

variable "rds_family" {
  type = string
}

variable "rds_instance_class" {
  type = string
}

variable "rds_port" {
  type = string
}

variable "rds_master_user_name" {
  type = string
}

variable "rds_allocated_storage" {
  type = number
}

variable "ec2_instance_type" {
  type = string
}

variable "ec2_key_name" {
  type = string
}