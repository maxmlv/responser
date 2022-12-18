resource "aws_route53_record" "certificate" {
  allow_overwrite = true
  name =  tolist(aws_acm_certificate.certificate.domain_validation_options)[0].resource_record_name
  records = [tolist(aws_acm_certificate.certificate.domain_validation_options)[0].resource_record_value]
  type = tolist(aws_acm_certificate.certificate.domain_validation_options)[0].resource_record_type
  zone_id = data.aws_route53_zone.zone.zone_id
  ttl = 60

  depends_on = [aws_acm_certificate.certificate]
}

resource "aws_acm_certificate_validation" "certificate_validation" {
  certificate_arn = aws_acm_certificate.certificate.arn
  validation_record_fqdns = [aws_route53_record.certificate.fqdn]

  depends_on = [aws_route53_record.certificate]
}

resource "aws_route53_record" "root" {
  count = var.environment ? "Prod" : "Stage"

  name    = var.zone_name
  type    = "A"
  zone_id = data.aws_route53_zone.zone.zone_id
  ttl = 300
  records = [var.ec2_public_ip]
}

resource "aws_route53_record" "www" {
  count = var.environment ? "Prod" : "Stage"

  name    = "www.${var.zone_name}"
  type    = "A"
  zone_id = data.aws_route53_zone.zone.zone_id
  ttl = 300
  records = [var.ec2_public_ip]
}

resource "aws_route53_record" "stage" {
  count = var.environment ? "Stage" : "Prod"

  name    = "stage.${var.zone_name}"
  type    = "A"
  zone_id = data.aws_route53_zone.zone.zone_id
  ttl = 300
  records = [var.ec2_public_ip]
}