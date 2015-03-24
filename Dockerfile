FROM jboss/wildfly
ADD ./target/testmaven-maven.war ./opt/jboss/wildfly/standalone/deployments/testmaven-maven.war
EXPOSE 8080
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
