[blue]
%{ for ip in blue ~}
${ip}
%{ endfor ~}

[green]
%{ for ip in green ~}
${ip}
%{ endfor ~}

[blue:vars]
ansible_ssh_user=ubuntu
ansible_ssh_private_key_file=~/.ssh/responser.pem
domain=responser.space

[green:vars]
ansible_ssh_user=ubuntu
ansible_ssh_private_key_file=~/.ssh/responser.pem
domain=responser.space