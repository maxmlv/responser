#!/bin/bash

file=$1

current=$(aws route53 list-tags-for-resource --resource-type hostedzone --resource-id $HOSTED_ZONE_ID | jq -r '.ResourceTagSet.Tags[0].Value')

echo "current = $current" > $file

if [ $current == "blue" ]; then
    deploy_on="green"
else
    deploy_on="blue"
fi

echo "deploy_on = $deploy_on" >> $file