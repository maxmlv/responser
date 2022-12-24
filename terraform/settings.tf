provider "aws" {
  region = "eu-central-1"
  default_tags {
    tags = {
      Terraform = "true"
      Project   = var.project_name
    }
  }
}

terraform {
  backend "s3" {
    bucket = "responser-terraform-state"
    key = "responser"
    region = "eu-central-1"
  }
}