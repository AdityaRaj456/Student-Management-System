#  Student Management System (Advance Java Project)

##  Project Overview
The **Student Management System** is a desktop-based application developed using **Advanced Java concepts**. It allows users to manage student records efficiently through a modern graphical user interface.

This project demonstrates real-world implementation of:
- Java GUI (Swing)
- JDBC (Database Connectivity)
- MySQL Integration
- Object-Oriented Programming


##  Features
- Add new student records  
- View students in table format  
- Update existing student details  
- Delete student records  
- Auto-refresh table after operations  
- Modern and user-friendly GUI  
- **Automatic database & table creation (No manual setup required)**  


##  Technologies Used
- Java (JDK 8+)
- Swing (GUI)
- JDBC API
- MySQL Database
- MySQL Connector (JAR)


## 📂 Project Structure
```
StudentManagementSystem/
│
├── lib/
│ └── mysql-connector-j-9.6.0.jar
│
├── src/
│ ├── Main.java
│ ├── GUI.java
│ ├── Student.java
│ ├── StudentDAO.java
│ └── DBConnection.java
│
├── .gitignore
└── README.md
```


##  Setup Instructions

###  Install Required Software
- Install Java JDK  
- Install MySQL Server  


###  Run the Project (No Database Setup Needed )

 No need to manually create database or table  

The application will automatically:
- Create database `studentdb`
- Create table `students`


### Compile the Project

```bash
javac -cp ".;lib/mysql-connector-j-9.6.0.jar" src/*.java
```

### Run the Project

```bash
java -cp ".;lib/mysql-connector-j-9.6.0.jar;src" Main
```


## Application Interface

### The application includes:
### Input Fields
- Name
- Course
- Registration Number
- Email
### Functional Buttons
- Add
- Update
- Delete
### Table View
- Displays all student records dynamically

## Future Enhancements
- Search functionality
- Login authentication system
- Export data to file
- UI upgrade using JavaFX

## Author 
 - Aditya Raj Tiwari
 - 24BCE10218

## Conclusion

This project demonstrates how Advanced Java concepts can be used to build a complete database-driven desktop application. It integrates GUI, backend logic, and database operations effectively.
