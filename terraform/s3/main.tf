resource "random_uuid" "random" {}

module "s3_bucket" {
  source = "terraform-aws-modules/s3-bucket/aws"

  bucket = "${var.project_name}-images-${random_uuid.random.result}"
  acl = "public"
  putin_khuylo = true
  policy = <<EOT
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "PublicRead",
            "Effect": "Allow",
            "Principal": "*",
            "Action": [
                "s3:GetObject",
                "s3:GetObjectVersion"
            ],
            "Resource": "arn:aws:s3:::${module.s3_bucket.s3_bucket_arn}/*"
        }
    ]
}
EOT

  tags = {
    Terraform = "true"
    Environment = var.environment
  }
}
