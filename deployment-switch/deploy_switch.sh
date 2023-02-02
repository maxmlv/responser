#!/bin/bash

json_file=$1
json_template=$(cat $json_file)
deploy_on=$2
dns=$3

aws route53 change-tags-for-resource --resource-type hostedzone --resource-id $HOSTED_ZONE_ID --add-tags Key=current,Value=$deploy_on

jq '.Changes[].ResourceRecordSet.ResourceRecords[].Value = $dns' --arg dns $dns <<< "$json_template" > $json_file

aws route53 change-resource-record-sets --hosted-zone-id $HOSTED_ZONE_ID --change-batch file://$json_file