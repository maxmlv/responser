data "aws_route53_zone" "zone" {
  name = var.zone_name
}

resource "aws_route53_record" "root-blue" {
  name    = var.zone_name
  type    = "A"
  ttl     = 300
  zone_id = data.aws_route53_zone.zone.id

  weighted_routing_policy {
    weight = var.deployment == "blue" ? 100 : 0
  }

  set_identifier = "blue"
  records = [var.blue_public_ip]
}

resource "aws_route53_record" "root-green" {
  name    = var.zone_name
  type    = "A"
  ttl     = 300
  zone_id = data.aws_route53_zone.zone.id

  weighted_routing_policy {
    weight = var.deployment == "green" ? 100 : 0
  }

  set_identifier = "green"
  records = [var.green_public_ip]
}

resource "aws_route53_record" "www-blue" {
  name    = "www.${var.zone_name}"
  type    = "CNAME"
  ttl     = 300
  zone_id = data.aws_route53_zone.zone.id

  weighted_routing_policy {
    weight = var.deployment == "blue" ? 100 : 0
  }

  set_identifier = "www-blue"
  records = [aws_route53_record.root-blue.name]
}

resource "aws_route53_record" "www-green" {
  name    = "www.${var.zone_name}"
  type    = "CNAME"
  ttl     = 300
  zone_id = data.aws_route53_zone.zone.id

  weighted_routing_policy {
    weight = var.deployment == "green" ? 100 : 0
  }

  set_identifier = "www-green"
  records = [aws_route53_record.root-green.name]
}