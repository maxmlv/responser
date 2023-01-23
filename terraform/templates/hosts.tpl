[webservers]
%{ for ip in webservers ~}
${ip}
%{ endfor ~}

[webservers:vars]
ansible_ssh_user=ubuntu
ansible_ssh_private_key_file=~/.ssh/responser.pem
domain=responser.space