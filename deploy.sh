pip install --user awscli
export PATH=$HOME/.local/bin:$PATH
aws configure set default.region us-west-2
aws configure set default.output json
APPNAME="lastappagain"

zip -r ${CIRCLE_SHA1}.zip Dockerfile index.html
aws s3 cp ${CIRCLE_SHA1}.zip s3://$my_bucket/
aws elasticbeanstalk create-application-version --application-name $APPNAME --version-label $CIRCLE_SHA1\
    --description "My first elasticbeanstalk app in Docker container"\
    --source-bundle S3Bucket=$my_bucket,S3Key=${CIRCLE_SHA1}.zip\
    --auto-create-application && sleep 20  &&\
aws elasticbeanstalk create-configuration-template --application-name $APPNAME\
    --solution-stack-name "64bit Amazon Linux 2014.09 v1.2.1 running Docker 1.5.0"\
    --template-name "my-app-template" && sleep 20 &&\
aws elasticbeanstalk create-environment --application-name $APPNAME\
    --environment-name "my-app-docker"\
    --template-name "my-app-template"\
    --cname-prefix "firstapp-test" && sleep 400 && \
aws elasticbeanstalk update-environment --environment-name "my-app-docker" --version-label $CIRCLE_SHA1
