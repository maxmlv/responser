data "aws_route53_zone" "public_zone" {
  name = var.zone_name
}

resource "aws_route53_record" "blue" {
  name    = data.aws_route53_zone.public_zone.name
  type    = "A"
  zone_id = data.aws_route53_zone.public_zone.id
  ttl = 300
  set_identifier = "blue"
    records = [var.blue_instance_ip]

  weighted_routing_policy {
    weight = local.blue
  }
}

resource "aws_route53_record" "green" {
  name    = data.aws_route53_zone.public_zone.name
  type    = "A"
  zone_id = data.aws_route53_zone.public_zone.id
  ttl = 300
  set_identifier = "green"
  records = [var.green_instance_ip]

  weighted_routing_policy {
    weight = local.green
  }
}