data "aws_route53_zone" "zone" {
  name = var.zone_name
}

resource "aws_route53_record" "root" {
  name    = var.zone_name
  type    = "A"
  ttl     = 300
  zone_id = data.aws_route53_zone.zone.id
  records = [var.ec2_public_ip]
}

resource "aws_route53_record" "www" {
  name    = "www.${var.zone_name}"
  type    = "CNAME"
  ttl     = 300
  zone_id = data.aws_route53_zone.zone.id
  records = [aws_route53_record.root.name]
}