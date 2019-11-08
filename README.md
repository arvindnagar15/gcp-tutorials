# Integrate Spring boot with swagger.

#Common Commands:
##To read deployment logs - 

	gcloud app logs read tail
	
	To deploy using mvn command - mvn appengine:deploy
	
	To deploy without maven plugin: 
	
	gcloud app deploy src/main/appengine/app.yaml
	


#Steps : deploy to GCP
```
1. Create a directory appengine under src/main
2. Create an app.yaml file
3. Add below dependenv into pom.xml file
	<plugin>
				 <groupId>com.google.cloud.tools</groupId>
				 <artifactId>appengine-maven-plugin</artifactId>
				 <version>1.3.2</version>
				 <configuration>
				 	<project>{GCP_Project_Id}</project>
				 </configuration>
			</plugin>
4. Create a GCP project on Google Cloud
5. Create an app engine on Google Cloud
6. Add below entries into app.yaml file
	runtime: java
	env: flex
7. mvn appengine:deploy

```
**************************************************************
##Common Errors:
# 1. Application is deployed successfully, but getting Nginx: 502 bad gateway error while accessing it.
	Add below manualy scaling:
	manual_scaling:
		instances: 2

