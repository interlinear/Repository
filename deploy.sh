pip install --user awscli
export PATH=$HOME/.local/bin:$PATH
#pwd
#zip -r App.zip Dockerfile target/
#ls -la
#unzip -t App.zip
#aws configure set default.region us-west-2
#aws configure set default.output json
#aws elasticbeanstalk describe-applications
APPNAME="first-app"

zip -r ${CIRCLE_SHA1}.zip Dockerfile target/
aws s3 cp ${CIRCLE_SHA1}.zip s://$my_bucket/
aws elasticbeanstalk create-application-version --application-name $APPNAME --version-label $CIRCLE_SHA1\
    --description "My first elasticbeanstalk app in Docker container"\
    --source-bundle S3Bucket=$mu_bucket,S3Key=${CIRCLE_SHA1}.zip\
    --auto-create-application
aws elasticbeanstalk create-configuration-template --application-name "first-app"\
    --solution-stack-name "64bit Amazon Linux 2014.09 v1.2.1 running Docker 1.5.0"\
    --template-name "first-app-template"
aws elasticbeanstalk create-environment --application-name "first-app"\
    --environment-name "first-app-docker"\
    --template-name "first-app-template"\
    --cname-prefix "cname-prefix"
aws elasticbeanstalk update-environment --environment-name "first-app-docker" --version-label $CIRCLE_SHA1
