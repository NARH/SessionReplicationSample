FROM            centos:latest

ADD     supervisord.conf /etc/supervisord.conf
ADD     index.html /var/www/html/
#
# Install
RUN     yum update -y && yum clean all
RUN     yum -y install epel-release
RUN     yum update -y && yum clean all
RUN     yum install -y \
  httpd \
  python-pip \
  openssh \
  openssh-server \
  openssh-clients \
  java-1.8.0-openjdk \
  java-1.8.0-openjdk-accessibility \
  java-1.8.0-openjdk-debug \
  java-1.8.0-openjdk-accessibility-debug \
  java-1.8.0-openjdk-devel \
  java-1.8.0-openjdk-devel-debug \
  && yum clean all
RUN     ssh-keygen -t rsa -N "" -f /etc/ssh/ssh_host_rsa_key
RUN     ssh-keygen -t dsa -N "" -f /etc/ssh/ssh_host_dsa_key
RUN     ssh-keygen -t ecdsa -N "" -f /etc/ssh/ssh_host_ecdsa_key
RUN     ssh-keygen -t ed25519 -N "" -f /etc/ssh/ssh_host_ed25519_key
RUN     mkdir /var/run/sshd
RUN     pip install supervisor

# Setup sshd
#ADD     id_rsa.pub /root/.ssh/authorized_keys
RUN     sed -ri 's/^#PermitRootLogin yes/PermitRootLogin yes/' /etc/ssh/sshd_config
RUN     sed -ri 's/^#RSAAuthentication yes/RSAAuthentication yes/' /etc/ssh/sshd_config
RUN     sed -ri 's/^#PasswordAuthentication yes/PasswordAuthentication yes/' /etc/ssh/sshd_config
RUN     echo "root:root" | chpasswd
CMD     ["/usr/sbin/sshd", "-D"]


ENV ADMIN_USER admin
ENV PAYARA_PATH /opt/payara41

RUN \ 
 mkdir -p ${PAYARA_PATH}/deployments && \
 useradd -b /opt -m -s /bin/bash -d ${PAYARA_PATH} payara && echo payara:payara | chpasswd && \
 chown -R payara:payara ${PAYARA_PATH}

EXPOSE 22 4848 8009 8080 8181

CMD ["/usr/bin/supervisord"]
