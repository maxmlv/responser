provider "aws" {
  region = "eu-central-1"
  default_tags {
    tags = {
      Terraform = "true"
      Project   = var.project_name
    }
  }
}

provider "acme" {
  server_url = "https://acme-staging-v02.api.letsencrypt.org/directory"
}