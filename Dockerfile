FROM tomcat
ADD index.html /usr/local/tomcat/webapps/ROOT/index.html
EXPOSE 8080
CMD ["catalina.sh", "run"]