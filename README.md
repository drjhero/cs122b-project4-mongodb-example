# CS 122B MongoDB Example
This example shows you how to connect to and use MongoDB from within your Tomcat Servlets.

Before running this example, follow the instructions from Project 4 to install and run MongoDB.

## Mongo setup
This section creates some requisite entities in MongoDB before you can run this project.
  * Start the Mongo command line shell:
    * `mongosh`
  * Create a new database for testing
    * `use myNewDB`
  * Create a new user for testing
    * `db.createUser({ user:"testuser", pwd:"MyPassword6", roles:["readWrite", "dbAdmin"]})`
  * Insert a new Collection called 'postsCollection' and insert a new document with a couple fields
    *  `db.postsCollection.insertOne({title:"Post Title 1", body:"Body of post.", category: "News", likes: 1, tags:["news", "events"], date: Date()})`

## Run the project
Run the project via Tomcat. It should display a Hello World landing page. Clicking
on the link of that landing page will call main.java.com.cs122b.mongodb.HelloServlet.
This class makes a connection to MongoDB using the credentials of the test user you
created above. It then uses the myNewDB database and retrieves the new Document you created
above and shows the title and body fields of that Document.

Note that we also followed [the instructions from Baeldung](https://www.baeldung.com/java-mongodb)
to setup the necessary Mongo Java Driver. This means we added the dependency below to
our pom.xml file.

```
<dependency>
  <groupId>org.mongodb</groupId>
  <artifactId>mongodb-driver-sync</artifactId>
  <version>5.0.1</version>
</dependency>
```