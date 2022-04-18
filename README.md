# cicd-service

Issue & fixes:
------------
If after creating elastic bean stalk & creating the aws code pipeline with successfull deployment server is throwing 502 error it means we need to configure the 
SERVER_PORT inside **Configuration**(https://ap-south-1.console.aws.amazon.com/elasticbeanstalk/home?region=ap-south-1#/environment/configuration?applicationName=cicd-service-v5&environmentId=e-vrxfur2afj) section in side navigation to 5000
so the key will be **SERVER_PORT** & value will be **5000**

as by default the port number taken by elastic bean stalk is 5000
