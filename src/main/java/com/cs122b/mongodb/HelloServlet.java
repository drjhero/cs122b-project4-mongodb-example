package com.cs122b.mongodb;

import java.io.*;

import com.mongodb.client.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.bson.Document;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String uri = "mongodb://testuser:MyPassword6@localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(uri)) {

            // Use the myNewDB database
            MongoDatabase myNewDB = mongoClient.getDatabase("myNewDB");

            // Get the postsCollection collection
            MongoCollection<Document> postsCollection = myNewDB.getCollection("postsCollection");

            // Get any document in the collection
            Document first = postsCollection.find().first();

            // Retrieve the title and body signals from the document
            String title = (String) first.get("title");
            String body = (String) first.get("body");

            // Show the signals in some HTML
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + title + "</h1><br>");
            out.println(body);
            out.println("</body></html>");
        }
    }
}