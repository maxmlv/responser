resource "random_uuid" "random" {}

module "s3_bucket" {
  source = "terraform-aws-modules/s3-bucket/aws"

  bucket = lower("${var.project_name}-images-${random_uuid.random.result}")
  acl = "public-read"
  putin_khuylo = true

  tags = {
    Terraform = "true"
    Description = "${var.project_name} images S3 bucket"
  }
}
