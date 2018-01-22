# bookS
This is a project to manage books for users, this inital commit is a webservice implemented using SpringBoot to make a webservice in Kotlin.  

How to Check out:
1. Download GitHub Desktop
2. Click on "Clone or Download"
3. Select open in Desktop
4. Select defaults

# Getting Started
To run this project download IntelliJ IDEA (non free version), Apache Tomcat 8.5, and MySql.  

Tomcat Installation:
Extract the tomcat files to your desired location

IntelliJ Project Setup:
I had to get a free trial of IntelliJ IDEA Ultimate since the community edition does not support Java EE

You will need to setup IntelliJ to interface with Tomcat using the "Edit Configurations" popup located in the upper right corner next to the Run icon. Click the "+" icon in the upper left corner then select "Tomcat Server"

H2 Setup:
On Mac install H2 using "brew install h2" then run project
Other OS's you will need to download H2 from http://www.h2database.com/html/main.html

MySql Setup:

Setup MySql normally then create a database titled 'booksDb' and a table 'book_shelf' with an Id column and serial sequence and an owner varchar(100)

Run these:

1. create database booksDb;
2. use booksDb;
3. create table book_shelf(id serial not null primary key, owner varchar(100));
4. create table book(id serial not null primary key, title varchar(500));

Note: SpringBoot connects to MySql using root since my users file is corrupted somehow...should fix this in the future.

Click Run!  

Get/Post

POST:
curl -H "Content-Type: application/text" -d "Test Bookshelf" http://localhost:8080/bookshelf/

GET: 
curl http://localhost:8080/bookshelf/a

or 

curl http://localhost:8080/bookshelf/1


curl -X PUT -H "Accept: application/json" -H "Content-Type: application/json" -d '{"id": 1, "owner": "test_again", "books":[{"id":1 , "title":"Test Book", "bookshelf_id":1 }]}' http://localhost:8080/bookshelf/1
