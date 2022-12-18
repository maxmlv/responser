variable "project_name" {
  type = string
}

variable "instance_type" {
  type = string
  default = "t3.micro"
}

variable "vpc_id" {
  type = string
}

variable "public_subnet_id" {
  type = string
}

variable "environment" {
  type = string
}