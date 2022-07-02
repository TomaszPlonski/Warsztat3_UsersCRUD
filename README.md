# UsersCRUD 
This is my first web app. App is based on MVC. I used: Java, MySQL and JSP(build on SB ADMIN PRO).

# What is my purpose?
This simple admin interface enabling:
- seeing the list of all users (from database),
- showing details of individual users, 
- removing users from database,
- adding users to database,
- updating user data.

# How to run it?
First you need some Container for app -> I use Tomcat.

Next you need database with users table. Here is quick dump for this table:

```sql
CREATE TABLE users (
    id INT(11) AUTO_INCREMENT,
    email VARCHAR(255) UNIQUE,
    username VARCHAR(255),
    password VARCHAR(60),
    PRIMARY KEY(id)
);
```

If you have problems connecting to the database, you may need to modify the DBUtil.java file.

For me main page is:
```
http://localhost:8080/list
```
On this page you will see list of all users. To add, show details, remove or update user just click on corresponding button.

# Why this simple?
For now, the functionality and my skills are limited. 
<b>Therefore any comments and advice will be appreciated</b>

