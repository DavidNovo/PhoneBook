# PhoneBook

## Creating a local repo first then pushing up to remote repo.
When creating a local repo first, a link needs to be established between the local repo and the remote repo.  Cloning from the remote repo creates this link. 

When starting from the local side first, this link does not exist, do it needs to be created.
Run this command in the root of the project after it has been initialized:

First create a remote repo.

Second establish the link between the local and remote repo:
 
    git remote add origin https://github.com/<username>/<reponame>.git

Make the first commit, then 

    git push origin master
    
After that just doing

    git push
    
Will be fine

## Creating the structure of the project.
Pretty simple, use this Maven command:

    $ mvn archetype:generate -DgroupId=com.dwbook.phonebook -DartifactId=dwbook-phonebook -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
   
Where:
  - groupID:      the package structure of the project
  - artifactId:   the name of the application and the name of the directory

Remember, the artifactId is also the name of the project's directory. With GitHub, the 
name of the repo is also the name of the project's directory. ( So, the artifactId
must match the name of the remote repo. -- not sure about this )

## Running the application
    $ java -jar target/dwbook-phonebook-1.0-SNAPSHOT.jar server
the server argument to the command. 

In public static void main, we called the public void run method, 
passing command-line arguments to it. Dropwizard has only one command 
prefigured (although we're able to configure additional commands), 
the server command, which starts the embedded HTTP Server (Jetty) 
to run our service. 

## Running the app with a config file
Here is the command to run the app with a config file.  Execute command in the root of the project:

    java -jar target/dwbook-phonebook-1.0-SNAPSHOT.jar server config.yaml

When a configuration file is passed as a command line argument, Dropwizard parses it and creates an instance of the configuration class.


## Database
~ docker run --name some-mysql --net=host -e MYSQL_ROOT_PASSWORD=password -d davidnovo/mysql:version2

## Integration Testing with CURL
### CRUD operations
Sample use of curl command:

    ➜  ~ curl --verbose --header "Content-Type: application/json" -X POST -d '{"firstName": "FOO", "lastName":"BAR", "phone":"987654321"}' http://localhost:8080/contact
    *   Trying ::1...
    * Connected to localhost (::1) port 8080 (#0)
    > POST /contact HTTP/1.1
    > Host: localhost:8080
    > User-Agent: curl/7.43.0
    > Accept: */*
    > Content-Type: application/json
    > Content-Length: 59
    >
    * upload completely sent off: 59 out of 59 bytes
    < HTTP/1.1 201 Created
    < Date: Fri, 09 Dec 2016 05:18:37 GMT
    < Location: http://localhost:8080/3
    < Content-Length: 0
    <