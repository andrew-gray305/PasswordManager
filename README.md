Andrew's Password Manager

A secure, desktop-based password manager built in Java, with a graphical interface, and a SQlite database.
This application allows users to generate strong passwords, check the strength of their current passwords, and securely store all their passwords and access them when needed. 

Objective

I took on this project in a software development class, with a goal of applying a security concept into an application. 

Features

Password Generator 
- Slider to set password size, 8-40 charecters
- Creates complex random passwords, with special characters, numbers, and symbols
- Able to customize length to meet password requirements, and adhere to security standards


Password Strength Checker
- Evaluates password strength
- provides a score, and gives recommendations to user

Secure Password Storage 
- Store account credentials in a local database
- Encrypt stored passwords using AES-GCM encryption
- Protect access to stored information with a master password
- decrypt stored passwords when authorized

Security Implementation

The focus of this project was to create secure storage for credentials, that decrypts when you enter in your master password. I got inspiration for my project from commercial password managers such as Bitwarden. 

Password Based Key Derivation
- Uses PBKDF2-HMAC-SHA256 to derive encryption keys based on the provided master password
- Uses 600,000 iterations to adhere to the OWASP recommendations for SHA-256 and make computation more expensice
- generates 16-byte salt

AES-GCM Encryption
- Passwords encrypted using AES-GCMG with the key derived from the master password
- Generates unique 12-byte initilation vector
- uses a 128-bit authentication tag to detect unauthorized modifications to data

SQlite Database
Encripted credentials, along with data needed for decryption is stored in the database
Its contents include:
- Service name
- Username
- Salt
- Iteration Count
- IV
- Ciphertext
- Creation date

Installing Application

Prerequisites

- Java Development Kit (JDK)
- SQlite JDBC driver
- Java IDE or command line development environment

Installation
1. Clone the repository:
    git clone https://github.com/andrew-gray305/PasswordManager.git
2. Open the project in IntelliJ IDEA or another Java IDE
3. Configure the SQLite JDBC driver as a project dependency
4. Run src/Main.java to launch the application

The application connects to a local SQLite database named passwords.db


Usage

Password Generator
- Use the slider to select password length
- press set length button -> unlocks generate pass button
- press generate pass button -> generates strong password

Password Strength Checker
- Input your password into the text box
- press check password
- system will generate a password rating and recommendations to make password stronger
   
Secure Password Storage

Store Passwords
- Enter service name, username, plaintext password, master password
- press store password -> password encrypted using master password and stored in database

Get Passwords
- Enter Master password
- press get password -> passwords decrypted and displayed
- search bar
- sort by service name or username

Security Disclaimer

This project is intended for educational and portfolio purposes. Although it implements established cryptographic algorithms, the overall application has not undergone a security audit and should not be relied upon for storing sensitive real-world credentials.

Author - Andrew Gray

Contact:
https://www.linkedin.com/in/andrew-t-gray/
drew@gray2002.com




