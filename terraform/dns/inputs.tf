variable "zone_name" {
  type = string
}

variable "blue_instance_ip" {
  type = string
}

variable "green_instance_ip" {
  type = string
}

variable "weight_on" {
  type = string
}

locals {
  blue = var.weight_on == "blue" ? 100 : 0
  green = var.weight_on == "green" ? 100 : 0
}