# bookS
This is a project to manage books for users, this inital commit is a webservice implemented using SpringBoot to make a webservice in Kotlin.  

# Getting Started
To run this project download IntelliJ IDEA (non free version), Apache Tomcat 8.5, and MySql.  

Tomcat Installation:
Extract the tomcat files to your desired location

IntelliJ Project Setup:
You will need to setup IntelliJ to interface with Tomcat using the "Edit Configurations" popup located in the upper right corner next to the Run icon. Click the "+" icon in the upper left corner then select "Tomcat Server"

MySql Setup:

Setup MySql normally then create a database titled 'booksDb' and a table 'book_shelf' with an Id column and serial sequence and an owner varchar(100)

Click Run!  

Get/Post

POST:
curl -H "Content-Type: application/text" -d "Test Bookshelf" http://localhost:8080/bookshelf/

GET: 
curl http://localhost:8080/bookshelf/a

or 

curl http://localhost:8080/bookshelf/1
