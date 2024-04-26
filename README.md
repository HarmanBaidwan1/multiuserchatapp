# Chatting App - Java-Based Secure Multi-User Chat Application

## Project Overview
"Chit Chat" is an advanced, Java-based multi-user chat application designed to deliver a secure and efficient online communication experience. Built using a client-server architecture, the application combines Java Swing for its graphical user interface, JDBC for robust database interactions, and socket programming for real-time communication. This project emphasizes security, performance, and user experience, making it ideal for educational purposes and small to medium-sized enterprises looking for reliable communication tools.

## Features
- **Real-Time Communication:** Multi-threaded server that handles multiple users simultaneously for dynamic and instantaneous messaging.
- **Security:** Implements MD5 hashing for password encryption to secure user data.
- **Database Efficiency:** Utilizes JDBC with a CommonDAO interface for optimized database interactions and reduced memory usage.
- **SQL Injection Prevention:** Employs PreparedStatement in the UserDAO class to enhance security.
- **User-Friendly GUI:** Developed with Java Swing, providing an interactive and intuitive interface.
- **Design Patterns:** Uses Singleton for effective configuration management and scalability.
- **Robust Logging:** Detailed logging mechanisms to help track activities and debug issues.
- **Dynamic Configuration:** Supports external configuration files for easy adaptability to different environments without recompilation.


Sure, here's a revised section of the README for your GitHub repository, specifically tailored to the actual folder name and your GitHub username for installation instructions:

---

## Getting Started

### Prerequisites
- Java JDK 8 or above
- MySQL
- JDBC driver

### Installation
1. **Clone the repository:**
   ```bash
   git clone https://github.com/HarmanBaidwan1/multiuserchatapp.git
   cd multiuserchatapp
   ```

2. **Set up the database:**
  

3. **Configure the application:**
   - Open the `config.properties` file located in the `resources` directory.
   - Adjust the database connection settings, server port, and other necessary configurations according to your setup.

### Running the Application
1. **Start the Server:**
   ```bash
   java -jar out/artifacts/server_jar/Server.jar
   ```

2. **Launch Client(s):**
   ```bash
   java -jar out/artifacts/client_jar/Client.jar
   ```

## Usage
After launching the server and clients:
- Clients can connect to the server using the GUI by entering the server's IP address and port.
- Users can register and log in using their credentials.
- Once logged in, users can start sending messages to other connected users in real-time.

