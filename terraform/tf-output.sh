#!/bin/bash

ansible_vars=$1

declare -a outputs=("rds_engine" "rds_address" "rds_port" "rds_db" "rds_username" "rds_password" "s3_bucket")

for i in "${outputs[@]}"; do
        echo "$i: $(terraform output -raw $i)" >> $ansible_vars
done