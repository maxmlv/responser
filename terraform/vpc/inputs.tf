variable "vpc_cidr_block" {
  type = string
}

variable "azs" {
  type = list(string)
}

variable "public_subnets_cidrs" {
  type = list(string)
}

variable "database_subnets_cidrs" {
  type = list(string)
}

variable "project_name" {
  type = string
}