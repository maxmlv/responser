resource "random_uuid" "random" {}

module "s3_bucket" {
  source = "terraform-aws-modules/s3-bucket/aws"

  bucket = lower("${var.project_name}-images-${random_uuid.random.result}")
  acl    = "public-read"

  block_public_acls   = false
  block_public_policy = false
  ignore_public_acls  = false
  force_destroy       = true

  versioning = {
    enabled = false
  }

  tags = {
    Terraform   = "true"
    Description = "${var.project_name} images S3 bucket"
  }
}

resource "aws_s3_bucket_policy" "bucket_policy" {
  bucket = module.s3_bucket.s3_bucket_id
  policy = <<EOF
{
"Version": "2012-10-17",
"Statement": [
    {
        "Sid": "PublicRead",
        "Effect": "Allow",
        "Principal": "*",
        "Action": [
            "s3:GetObject"
        ],
        "Resource": "${module.s3_bucket.s3_bucket_arn}/*"
    }
]
}
EOF
}