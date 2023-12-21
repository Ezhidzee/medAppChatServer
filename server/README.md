#medApp server

### **http://ezhidze.su:8080**

## Http requests:

### Doctor controller - http://ezhidze.su:8080/medApp/doctors

* #### http://ezhidze.su:8080/medApp/doctors/registration

  PostMapping, register a new doctor

  The Json request body must contain the following fields:
  * String firstName
  * String lastName
  * String email
  * String password
  * String specialization
  * String contactNumber
  * String clinicAddress
  * String otherRelevantInfo

  Example:
  `{
  "firstName": "Artyom",
  "lastName": "Tsatinyan",
  "email": "doctor1@gmail.com",
  "password": "NYVzp#n9Z727",
  "specialization": "paramedic",
  "contactNumber": "6545648974",
  "clinicAddress": "goihdgopre",
  "otherRelevantInfo": "osafjgjsr"
  }`

* #### http://ezhidze.su:8080/medApp/doctors/authentication

  PostMapping, user authentication

  The Json request body must contain the following fields:
  * String email
  * String password

  Example:
  `{
  "email": "doctor1@gmail.com",
  "password": "NYVzp#n9Z727"
  }`

  Returns the entity body and jwt token

* #### http://ezhidze.su:8080/medApp/doctors

  GetMapping, will return a list of all doctors

* #### http://ezhidze.su:8080/medApp/doctors

  GetMapping, get doctor by id

  Parameters: **Integer id**

  Example: http://ezhidze.su:8080/medApp/doctors?id=752

* #### http://ezhidze.su:8080/medApp/doctors/delete

  DeleteMapping, delete doctor by id

  Parameters: **Integer id**

  Example: http://ezhidze.su:8080/medApp/doctors/delete?id=652

* #### http://ezhidze.su:8080/medApp/doctors/patch

  PatchMapping, change entity body

  Parameters: **Integer id**

  The Json body of the request must contain the fields you want to change

  Example: http://ezhidze.su:8080/medApp/doctors/patch?id=752

  `{
  "firstName": "Saul",
  "lastName": "Goodman"
  }`

  Returns the modified body of the entity

### Patient controller - http://ezhidze.su:8080/medApp/patients

* #### http://ezhidze.su:8080/medApp/patients/registration

  PostMapping, register a new patient

  The Json request body must contain the following fields:
  * String firstName
  * String lastName
  * String email
  * String password
  * String dateOfBirth
  * String gender
  * String contactNumber
  * String address
  * String otherRelevantInfo

  Example:
  `{
  "firstName": "Artyom",
  "lastName": "Tsatinyan",
  "email": "patinent2@gmail.com",
  "password": "NYVzp#n9Z727",
  "dateOfBirth": "11/19/2023",
  "gender": "male",
  "contactNumber": "91321321311",
  "address": "dsdsdasd",
  "otherRelevantInfo": "dsdadsjfwefj"
  }`

* #### http://ezhidze.su:8080/medApp/patients/authentication

  PostMapping, user authentication

  The Json request body must contain the following fields:
  * String email
  * String password

  Example:
  `{
  "email": "patinent2@gmail.com",
  "password": "NYVzp#n9Z727"
  }`

  Returns the entity body and jwt token

* #### http://ezhidze.su:8080/medApp/patients

  GetMapping, will return a list of all patients

* #### http://ezhidze.su:8080/medApp/patients

  GetMapping, get patient by id

  Parameters: **Integer id**

  Example: http://ezhidze.su:8080/medApp/patients?id=802

* #### http://ezhidze.su:8080/medApp/patients/delete

  DeleteMapping, delete patient by id

  Parameters: **Integer id**

  Example: http://ezhidze.su:8080/medApp/patients/delete?id=652

* #### http://ezhidze.su:8080/medApp/patients/patch

  PatchMapping, change entity body

  Parameters: **Integer id**

  The Json body of the request must contain the fields you want to change

  Example: http://ezhidze.su:8080/medApp/patients/patch?id=752

  `{
  "firstName": "Saul",
  "lastName": "Goodman"
  }`

  Returns the modified body of the entity

### Chat controller - http://ezhidze.su:8080/

* #### http://ezhidze.su:8080/chats

  GetMapping, get a list of all chats

* #### http://ezhidze.su:8080/chats

  GetMapping, get chat by id

  Parameters: **Integer id**

  Example: http://ezhidze.su:8080/chats?id=0

* #### http://ezhidze.su:8080/addChat

  PostMapping, add chat, called without parameters, in response the server will simply return an empty chat body with its id

* #### http://ezhidze.su:8080/joinUser

  PutMapping, add user to chat

  Parameters: **Integer chatId, Integer userId, String role**

  role: **PATIENT, DOCTOR**

  Example: http://ezhidze.su:8080/joinUser?chatId=1&userId=1&role=PATIENT

* #### http://ezhidze.su:8080/deleteUser

  PutMapping, remove user from chat

  Parameters: **Integer chatId, Integer userId, String role**

  role: **PATIENT, DOCTOR**

  Example: http://ezhidze.su:8080/deleteUser?chatId=2&userId=802&role=PATIENT

* #### http://ezhidze.su:8080/deleteMessage

  PutMapping, delete a message from a chat

  Parameters: **Integer chatId, Integer messageId**

  Example: http://ezhidze.su:8080/deleteMessage?chatId=1&messageId=152

### Medical records controller - http://ezhidze.su:8080/medApp/medicalRecords

* #### http://ezhidze.su:8080/medApp/medicalRecords

  GetMapping will return a list of all records

* #### http://ezhidze.