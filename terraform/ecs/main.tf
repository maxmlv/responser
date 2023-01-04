module "ecs" {
  source = "terraform-aws-modules/ecs/aws"

  cluster_name = "${var.project_name}-ECS-Cluster"

  cluster_configuration = {
    execute_command_configuration = {
      logging = "OVERRIDE"
      log_configuration = {
        cloud_watch_log_group_name = "/aws/ecs/aws-ec2"
      }
    }
  }

  autoscaling_capacity_providers = {
    blue = {
      auto_scaling_group_arn = var.asg_blue_arn
    }
    green = {
      auto_scaling_group_arn = var.asg_green_arn
    }
  }
}