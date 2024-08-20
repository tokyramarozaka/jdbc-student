# DATABASE SCHEMA 

To make this app work, you'll need to create a database of your own, and specify your credentials as environment variables. 

Here is the database's only table : Student. 

```sql
CREATE TABLE student (
  id varchar(10) PRIMARY KEY,
  user_name varchar(100) NOT NULL,
  phone varchar(14),
  email varchar(75),
  address text,
  first_name varchar(100),
  last_name varchar(200) NOT NULL
);
``` 
