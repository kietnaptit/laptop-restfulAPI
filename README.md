# laptop-restfulAPI

Step 1: Import this project into Eclipse using File -> Open Project from file system
<br>
Step 2: Create Database using this command
<br>
```
CREATE TABLE laptop(
	id int PRIMARY KEY auto_increment,
    name varchar(255),
    manudate date,
    brand varchar(255),
    sold int
);
```
<br>

Step 3: You might import sample datasheet using file Table Import Data Wizard and file /sql/laptop_datasheet.json
<br>
Step 4: Update SQL credentials in file LaptopDAO
<br>
Step 5: Start the SpringBoot Server at localhost:8080
<br>
Check my laptop-reactjs if you need front-end