FROM jenkins/agent:alpine-jdk11

USER root

# install maven
RUN apk add maven

# install ansible
RUN apk add ansible

# install terraform
RUN apk add terraform --repository=https://dl-cdn.alpinelinux.org/alpine/edge/community

# install aws cli
RUN apk add --no-cache aws-cli

USER jenkins
