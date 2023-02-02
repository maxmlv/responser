#!/bin/bash

file=$1

current=$(aws route53 list-tags-for-resource --resource-type hostedzone --resource-id $HOSTED_ZONE_ID | jq -r '.ResourceTagSet.Tags[0].Value')

echo "CURRENT=$current" > $file

if [ $current == "blue" ]; then
    deploy_on="green"
else
    deploy_on="blue"
fi

echo "DEPLOY_ON=$deploy_on" >> $file