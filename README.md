# Wemanity
In order to use this repository first you need to clone :
https://github.com/sahilvig/Wemanity.git

please make sure you have maven installed. Before you start importing the project in Eclipse/IntelliJ.

To make build of project :

mvn clean install 

When you build with Maven, the goal is to create some artifact(s) for deployment, this can be a jar for a library, a war for a web application or something else altogether. When you do a Mvn install, it will roughly:

Generate whatever it needs,
Compile the sources,
Copy other resources,
Create the artifact for your project,
Run unit tests,
Copy the artifact to the local Mvn repository (this is usually $HOME/.m2/repository).
So a Mvn clean install will first clean the target and then run the steps above.

Also all the Unit tests will run automatically with the above command.
