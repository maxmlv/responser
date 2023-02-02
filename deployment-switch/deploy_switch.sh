#!/bin/bash

json_file=$1
json_template=$(cat $json_file)
ip_address=$2

aws route53 change-tags-for-resource --resource-type hostedzone --resource-id $HOSTED_ZONE_ID --add-tags Key=current,Value=$DEPLOY_ON

jq '.Changes[].ResourceRecordSet.ResourceRecords[].Value = $ip_address' --arg ip_address $ip_address <<< "$json_template" > $json_file

aws route53 change-resource-record-sets --hosted-zone-id $HOSTED_ZONE_ID --change-batch file://$json_file