# Spring Boot File Upload API (Single & Multiple Uploads – Database Storage)

This is practice project where i developed REST APIs to upload **single** and **multiple** files and store them inside a database.  
Project uses a simple architecture:

- Controller  
- Entity
- Service (`FilesService`, `FilesServiceImpl`)
- Repository  
- Utility classes (`Constants`, `ResponseMessageDto`)

---

## Features

- Upload **single** file to database  
- Upload **multiple** files to database  
- Return structured JSON response using **ResponseMessageDto**  
- Stores file metadata: name, type, created & updated timestamps  
- Clean, simple architecture

---

## Tech Stack

- Java 21
- Spring Boot 3.5.7
- Spring Web
- Spring Data JPA
- Hibernate
- Lombok
- MySQL 
- Maven

---

## Project Structure

```
com.som
│
├── controller
│     └── FilesController.java
│
├── entity
│     └── FilesEntity.java
│
├── repository
│     └── FilesRepository.java
│
├── service
│     ├── FilesService.java
│     └── impl
│           └── FilesServiceImpl.java
│
└── utility
      ├── Constants.java
      └── ResponseMessageDto.java

```

---

# API Endpoints

---

## **Upload Single File**

### **POST** `/uploadfile`

### Request (multipart/form-data)
```
file: <SomResume>
```

### Example Response
```json
{
  "statuscode": 201,
  "status": "success",
  "message": "File Inserted Successfully",
  "data": "SomResume.pdf"
}
```

---

## **Upload Multiple Files**

### **POST** `/uploadmultifile`

### Request (multipart/form-data)
```
files: <SomResume>
files: <charminar>
files: <java>
```

### Example Response
```json
{
  "statuscode": 201,
  "message": "Files Inserted Successfully",
  "list": [
    "SomResume.pdf",
    "charminar.jpg",
    "java.png"
  ]
}
```

---

# Database Table Structure

### **FilesEntity**

| Field       | Type        | Description              |
|-------------|-------------|--------------------------|
| id          | BIGINT PK   | Auto generated           |
| fileName    | VARCHAR     | Original filename        |
| fileType    | VARCHAR     | File type                |
| data        | LONGBLOB    | File bytes               |
| createdDate | DATETIME    | Auto timestamp           |
| updatedDate | DATETIME    | Auto timestamp           |

---

# Future Enhancements

- File size validation  
- Allowed file types validation  
- File download API  
- Serve image/file preview   
- Add Swagger documentation  
 
