
# 📊 Attendance Tracking System (Java)

A simple **Java console-based Attendance Tracker** that allows students to calculate their **current attendance percentage** or check the **maximum number of hours they can take leave** based on their college's minimum attendance requirements.  

The program also supports **saving attendance details into a text file** with timestamps for record keeping.

---

## 🚀 Features
- ✅ Calculate **current attendance percentage** per subject  
- ✅ Calculate **maximum hours allowed to take leave** while maintaining minimum attendance  
- ✅ Input validation for wrong data entries (handles invalid integers and register numbers)  
- ✅ Option to **swap hours if absent hours > total hours entered**  
- ✅ Save details into a text file (`attendancetrackingsystem.txt`) with date and time  
- ✅ Console-based user-friendly menu system  

---

## 📂 File Structure
```

├── attendancetracker.java   # Main program source code
├── attendancetrackingsystem.txt  # Output file (generated after saving results)
└── README.md   # Project documentation

```

---

## 🛠️ Technologies Used
- **Java** (Core Java, File Handling, Exception Handling, OOP)
- **Java I/O (FileWriter)**
- **LocalDateTime** for date & time formatting

---

## 📖 How It Works
1. User enters the **minimum required attendance percentage** of their college.  
2. User chooses between:
   - `c` → Calculate **current attendance percentage**  
   - `d` → Calculate **maximum hours to take leave**  
   - Other key → Exit the program  
3. For each subject, the user enters details like:
   - Subject name  
   - Hours taken / Total hours  
   - Hours absent  
4. Program displays results on the console or saves them to a file.  

---

## 💻 Sample Run

### **Case 1: Current Attendance Percentage (`c`)**
```

Enter the minimum attendance percentage of your college:
75
Enter if you want to find the current attendance percentage(c)\The number of max hours to take leave(d)\Exit(other than c,d)
c
Enter your name:
Raman
Enter your register number:
12345
Enter the number of subjects:
2
Subject:1
Name:
Maths
Enter the number of hours you have taken leave
10
Enter the number of hours the subject has been taken
40
Subject:2
Name:
Physics
Enter the number of hours you have taken leave
8
Enter the number of hours the subject has been taken
30
Enter p to display the details\v to save the file\l to exit
p
Name: Raman
Register no: 12345
Subject: Maths, Attendance: 75.00%
Subject: Physics, Attendance: 73.33%

```

---

### **Case 2: Maximum Hours to Take Leave (`d`)**
```

Enter the minimum attendance percentage of your college:
75
Enter if you want to find the current attendance percentage(c)\The number of max hours to take leave(d)\Exit(other than c,d)
d
Enter your name:
Raman
Enter your register number:
12345
Enter the number of subjects:
1
Subject:1
Name:
Chemistry
Totalhours:
60
Enter p to display the details\v to save the file
p
Name: Raman,
Registerno:12345
Subject: Chemistry, Max hours to take leave: 15

```

---

## 📝 Output File Example (`attendancetrackingsystem.txt`)
```

Last checked on: 23-08-2025 09:45 PM
Name\:Raman,Registernumber:12345
Subject: Maths,Attendance: 75.00
Subject: Physics,Attendance: 73.33

````

---

## ⚡ How to Run
1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/attendance-tracker-java.git
````

2. Navigate to the project folder:

   ```bash
   cd attendance-tracker-java
   ```
3. Compile the program:

   ```bash
   javac attendancetracker.java
   ```
4. Run the program:

   ```bash
   java attendancetracker
   ```

---

## 📌 Future Improvements

* Add GUI using JavaFX/Swing
* Store attendance records in a database (MySQL/SQLite) instead of a text file
* Add subject-wise graphs for attendance visualization

---

## 👨‍💻 Author

* Developed by **Raman Siva**
* First-year **CSE Student, MIT, Anna University**
* Languages used: **Java, Python, C**

````

---

## **DESCRIPTION.md**

```markdown
# 📊 Attendance Tracking System (Java)

This is a **Java console-based Attendance Tracker** that helps students:  
- ✅ Calculate their **current attendance percentage** per subject  
- ✅ Check the **maximum number of hours they can take leave** while maintaining minimum attendance  
- ✅ Save attendance details into a text file (`attendancetrackingsystem.txt`) with timestamps  

It uses **Object-Oriented Programming (OOP), Exception Handling, and File Handling** concepts in Java.  
Perfect for beginners learning **Java I/O and OOP**.
````

---

## Suggested **GitHub repo short description**

```
📊 Java Attendance Tracker – Calculate attendance %, max leave hours, and save reports with timestamps
```

---

