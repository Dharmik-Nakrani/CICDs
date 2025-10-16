
#!/bin/bash  

if [ -d "/home/ubuntu/helm-eks" ]; then
cd /home/ubuntu/helm-eks
git pull
else
cd
git clone -b development https://git.sa-labs.info/taskopad-micro-services/terraform-taskopad/helm-eks.git
cd /home/ubuntu/helm-eks
fi

helm upgrade -i ms-auth ms-auth-service/ -n dev
helm upgrade -i ms-user ms-user-service/ -n dev
