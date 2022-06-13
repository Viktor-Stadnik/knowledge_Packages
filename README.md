# Knowledge_Packages

### How to run this application:
1. Install MySQL
2. Install [Tomcat 9.0.58 version](https://tomcat.apache.org/download-90.cgi)
3. Fork this project
4. Create the required tables for database using `resources/resources/init_db.sql` file
5. Add some data to DB
6. Add url to DB: _login, password and JDBC driver_ in the `resources`.
7. Configure Tomcat.(Application context needs to be as "/")
8. Run this project using Tomcat's local server
