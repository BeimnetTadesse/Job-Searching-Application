# 💼 Job Searching Application

A Java Swing desktop application that connects job seekers with employers. Users can register, post jobs, apply for jobs, and manage profiles. The app uses SQLite as the local database and follows a clean MVC structure.

## 📁 Project Structure

```

AP/
├── .vscode/                 # Editor config
├── bin/                     # Compiled class files
├── lib/                     # External libraries (e.g., sqlite-jdbc)
├── src/                     # Source code
│   ├── app/                 # Main application entry point (App.java)
│   ├── controller/          # Controllers handling business logic
│   ├── database/            # Data access objects (DAOs)
│   ├── model/               # Java model classes (e.g., User, Job)
│   └── view/                # Java Swing GUI views
├── JobSearch.db             # SQLite database file
└── README.md                # This file

````

## 🚀 Features

### 👨‍💻 For Job Seekers
- Register and log in
- Browse available jobs
- Apply to jobs (only once per job)
- View your profile

### 🏢 For Employers
- Register and log in
- Post new jobs
- View applicants for your postings

### ⚙️ Core Functionality
- Swing-based GUI (JFrame, JPanel, JButton, etc.)
- SQLite for local data storage
- Clean MVC (Model-View-Controller) architecture

## 🛠️ Technologies Used

- Java (JDK 8+)
- **Java Swing** for GUI
- **SQLite** with `sqlite-jdbc`
- MVC pattern

## ▶️ How to Run

### 1. Clone the Repository
```bash
git clone https://github.com/BeimnetTadesse/Job-Searching-Application.git
cd Job-Searching-Application
````

### 2. Compile the Code

```bash
javac -cp ".:lib/sqlite-jdbc-3.49.1.0.jar" -d bin src/**/*.java
```

### 3. Run the App

```bash
java -cp ".:lib/sqlite-jdbc-3.49.1.0.jar:bin" app.App
```

> 🪟 **Note for Windows users**: Use `;` instead of `:` in the classpath.

## 📋 Database

* The database file `JobSearch.db` stores:

  * Users (Job Seekers & Employers)
  * Jobs
  * Applications
* You can inspect or modify it using [DB Browser for SQLite](https://sqlitebrowser.org/).

## ✅ Status

* Final version submitted
* No real-time socket connection required
* Tested and working locally

---

📍 **Author**: Beimnet Tadesse
🏫 **University**: Addis Ababa Science and Technology University
📅 **Submission**: 2025

---

Feel free to fork or explore the project for educational purposes.

