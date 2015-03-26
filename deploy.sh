#aws --version
#aws configure set aws_access_key_id $AWSKEY
#aws configure set aws_secret_access_key $AWSSECRETKEY
#aws configure set default.region us-west-2
#aws configure set deafult.output json

#echo "copy Dockerfile"
#aws s3 ls s3://
#aws configure help

pip install --user awscli
export PATH=$HOME/.local/bin:$PATH
#aws configure set aws_access_key_id $AWSKEY
#aws configure set aws_secret_access_key $AWSSECRETKEY
#aws s3 ls s3://interlinear101
pwd
zip -r App.zip Dockerfile target/
ls -la
unzip -t App.zip

aws elasticbeanstalk describe-applications
