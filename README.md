# Integrate Spring boot with swagger.
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
