aws --version
#aws configure set aws_access_key_id $AWSKEY
#aws configure set aws_secret_access_key $AWSSECRETKEY
#aws configure set default.region us-west-2
#aws configure set deafult.output json

echo "copy Dockerfile"
aws s3 cp Dockerfile s3://$EB_BUCKET/Dockerfile
