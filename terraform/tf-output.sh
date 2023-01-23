#!/bin/bash

declare -a outputs=("rds_engine", "rds_address", "rds_port", "rds_db", "rds_username", "rds_password", "s3_bucket")

for i in ${#outputs[@]}; do
    if [ $i == 0 ]; then
        echo "${outputs[$i]}: $(terraform output -raw ${outputs[$i]})" > ../ansible/vars/vars.yaml
    else
        echo "${outputs[$i]}: $(terraform output -raw ${outputs[$i]})" >> ../ansible/vars/vars.yaml
    fi
done