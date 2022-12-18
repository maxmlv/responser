variable "environment" {
  type = string
}

variable "project_name" {
  type    = string
  default = "Responser"
}

variable "vpc_cidr_block" {
  type    = string
  default = "10.0.0.0/24"
}
variable "azs" {
  type    = list(string)
  default = ["eu-central-1a", "eu-central-1b"]
}

variable "public_subnet_cidrs" {
  type    = list(string)
  default = ["10.0.0.0/26", "10.0.0.64/26"]
}

variable "private_subnet_cidrs" {
  type    = list(string)
  default = ["10.0.0.128/27", "10.0.0.160/27"]
}

variable "database_subnet_cidrs" {
  type    = list(string)
  default = ["10.0.0.192/27", "10.0.0.224/27"]
}

variable "enabled_nat" {
  type    = bool
  default = false
}

variable "zone_name" {
  type    = string
  default = "responser.space"
}

variable "owner_email" {
  type = string
  default = "max.mlv.aws@gmail.com"
}