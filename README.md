
# **Event Management Application**

A comprehensive event management web application that simplifies planning, organizing, and managing events. Built using **Spring Boot** for the backend, **MySQL** as the database, and traditional **HTML, CSS, Bootstrap**, and **JavaScript** for the frontend. 

This project is designed to manage events effectively, providing features like user registration, event creation, and feedback collection, along with secure email notifications.

---

## **Features**
- User authentication and session management.
- Event creation, registration, and listing.
- Automated email notifications for event updates.
- Feedback collection and analytics.
- Role-based access for administrators and users.

---

## **Technologies Used**
- **Backend**: Spring Boot
- **Frontend**: HTML, CSS, Bootstrap, JavaScript
- **Database**: MySQL
- **Email Service**: SMTP (via Gmail)
- **Template Engine**: Thymeleaf

---

## **Installation and Setup**

Follow these steps to set up the project on your local machine:

### **1. Prerequisites**
- Java 17 or later
- MySQL Server
- Maven
- Git

### **2. Clone the Repository**
```bash
git clone https://github.com/TharunYetti/event-management.git
cd event-management
```

### **3. Configure the Environment Variables**
Create an `.env` file in the root directory and add the following variables:
```env
PORT=8080
DB_HOST=localhost
DB_USERNAME=root
DB_PASSWORD=yourpassword
MAIL_USERNAME=your-email@gmail.com
MAIL_PASSWORD=your-email-password
CHATBASE_API_KEY=your-chatbase-api-key
```

### **4. Set Up the Database**
- Create a database named `eventdb` in MySQL:
  ```sql
  CREATE DATABASE eventdb;
  ```
- The application will automatically create the necessary tables upon startup.

### **5. Build and Run the Application**
```bash
mvn clean install
mvn spring-boot:run
```

The application will start on [http://localhost:${PORT}](http://localhost:8080).

---

## **Usage**

### **Accessing the Application**
1. Open your browser and go to [http://localhost:${PORT}](http://localhost:8080).
2. Register as a user or log in with your credentials.
3. Explore features like:
   - Registering for events.
   - Creating new events (if you have admin access).
   - Submitting feedback.

---

## **Contributing**

We welcome contributions to make this project even better! Here's how you can help:

### **1. Fork the Repository**
Click the "Fork" button at the top-right corner of this repository.

### **2. Clone Your Fork**
```bash
git clone https://github.com/your-username/event-management.git
```

### **3. Create a Branch**
```bash
git checkout -b feature/your-feature-name
```

### **4. Make Your Changes**
Write clean and well-documented code.

### **5. Commit Your Changes**
```bash
git add .
git commit -m "Add a meaningful commit message"
```

### **6. Push Your Changes**
```bash
git push origin feature/your-feature-name
```

### **7. Submit a Pull Request**
Go to the original repository on GitHub and click **Pull Request**.

---

## **License**
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## **Contact**
For any questions, suggestions, or issues, feel free to contact:
- **Name**: Tharun Yetti
- **Email**: tharunyetti24@gmail.com
- **GitHub**: [TharunYetti](https://github.com/TharunYetti)
