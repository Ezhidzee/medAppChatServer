# medApp server

#### [English](#english-documentation)

#### [Russian](#russian-documentation)

### English documentation:

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
  "dateOfBirth": "19.11.2023",
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

  GetMapping, will return a list of all records

* #### http://ezhidze.su:8080/medApp/medicalRecords

  GetMapping, will return a list of all records

  Parameters: **Integer id**

* #### http://ezhidze.su:8080/medApp/medicalRecords/add

  PostMapping, add new entry

  The Json request body must contain the following fields:
  * Integer patientId
  * Integer doctorId
  * String recordType
  * String messageContent

  Example:
  `{
  "patientId": 103,
  "doctorId": 102,
  "recordType": "Lab Results",
  "messageContent": "Negotive"
  }`

* #### http://ezhidze.su:8080/medApp/medicalRecords/patch

  PatchMapping, patch entry

  Parameters: **Integer id**

  The Json body of the request must contain the fields you want to patch

* #### http://ezhidze.su:8080/medApp/medicalRecords/delete

  DeleteMapping, delete entry

  Parameters: **Integer id**

# WebSockets

### ws://ezhidze.su:8080/chat

The operating logic is as follows: the client part sends a message to a specific chat (the chat id is sent along with the message object).
Next, the server sends this message to all chat participants who are currently online. Next, the server saves the message in the chat so that clients who go offline can request new messages.
Accordingly, if you need to send a message from one user to another, then you create a new chat (if there is no longer a chat for these users), add users there and send your message to this chat,
Then the server itself will send the message to online users and save it for those who are offline for the next moment.

To join you need to use sockJs

Messages are sent to the path `"/app/private-chat"`

The request headers must contain an `Authorization` header with a value like `Bearer ...` where instead of `...` there must be a client's jwt token

As a message, the server expects to receive a class object with the following fields:

`String senderSubject; Integer chatId; String messageText`

To receive messages you need to subscribe the client to `"/user/topic/private-messages"`

Example of a message class and client part in Java

```java
public class InputMessageModel {

    private String senderSubject;

    private Integer chatId;

    private String messageText;

    public InputMessageModel(String senderSubject, Integer chatId, String messageText) {
        this.senderSubject = senderSubject;
        this.chatId = chatId;
        this.messageText = messageText;
    }

    public InputMessageModel() {
    }

    public String getSenderSubject() {
        return senderSubject;
    }

    public void setSenderSubject(String senderSubject) {
        this.senderSubject = senderSubject;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
```

```java
public class ChatClient {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String url = "ws://ezhidze.su:8080/chat";
        WebSocketClient client = new StandardWebSocketClient();
        List<Transport> transports = new ArrayList<>(1);
        transports.add(new WebSocketTransport(client));
        SockJsClient sockJsClient = new SockJsClient(transports);

        WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        StompSessionHandler sessionHandler = new MyStompSessionHandler();
        WebSocketHttpHeaders webSocketHttpHeaders = new WebSocketHttpHeaders();
        System.out.println("jwt token:");
        webSocketHttpHeaders.add("Authorization", "Bearer " + in.readLine());
        StompSession session = stompClient.connect(url, webSocketHttpHeaders, sessionHandler).get();

        System.out.println("Our email: ");
        String email = in.readLine();
        System.out.println("Chat id: ");
        Integer chatID = Integer.valueOf(in.readLine());
        for (; ; ) {
            String line = in.readLine();
            if (line == null) break;
            if (line.isEmpty()) continue;
            InputMessageModel msg = new InputMessageModel();
            msg.setChatId(chatID);
            msg.setSenderSubject(email);
            msg.setMessageText(line);
            session.send("/app/private-chat", msg);
        }
    }

    static public class MyStompSessionHandler extends StompSessionHandlerAdapter {

        @Override
        public Type getPayloadType(StompHeaders headers) {
            return InputMessageModel.class;
        }

        @Override
        public void handleFrame(StompHeaders headers, Object payload) {
            InputMessageModel msg = (InputMessageModel) payload;
            System.out.println("Received : " + msg.getMessageText() + " from : " + msg.getSenderSubject());
        }

        @Override
        public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
            session.subscribe("/topic/messages", this);
            session.subscribe("/user/topic/private-messages", this);
        }
    }
}
```

### Russian documentation:

# medApp server

### **http://ezhidze.su:8080**

## Http запросы:

### Doctor controller - http://ezhidze.su:8080/medApp/doctors

* #### http://ezhidze.su:8080/medApp/doctors/registration

  PostMapping, зарегистрировать нового доктора

  Json тело запроса должно содержать поля:
  * String firstName
  * String lastName
  * String email
  * String password
  * String specialization
  * String contactNumber
  * String clinicAddress
  * String otherRelevantInfo

  Пример:
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

  GetMapping, аутентификация пользователя

  Json тело запроса должно содержать поля:
  * String email
  * String password

  Пример:
  `{
  "email": "doctor1@gmail.com",
  "password": "NYVzp#n9Z727"
  }`

  Вернёт тело сущности и jwt token

* #### http://ezhidze.su:8080/medApp/doctors

  GetMapping, вернёт список всех докторов

* #### http://ezhidze.su:8080/medApp/doctors

  GetMapping, получить доктора по id

  Параметры: **Integer id**

  Пример: http://ezhidze.su:8080/medApp/doctors?id=752

* #### http://ezhidze.su:8080/medApp/doctors/delete

  DeleteMapping, удалить доктора по id

  Параметры: **Integer id**

  Пример: http://ezhidze.su:8080/medApp/doctors/delete?id=652

* #### http://ezhidze.su:8080/medApp/doctors/patch

  PatchMapping, изменить тело сущности

  Параметры: **Integer id**

  Json тело запроса должно содержать те поля, которые вы хотите изменить

  Пример: http://ezhidze.su:8080/medApp/doctors/patch?id=752

  `{
  "firstName": "Saul",
  "lastName": "Goodman"
  }`

  Вернёт изменённое тело сущности

### Patient controller - http://ezhidze.su:8080/medApp/patients

* #### http://ezhidze.su:8080/medApp/patients/registration

  PostMapping, зарегистрировать нового пациента

  Json тело запроса должно содержать поля:
  * String firstName
  * String lastName
  * String email
  * String password
  * String dateOfBirth
  * String gender
  * String contactNumber
  * String address
  * String otherRelevantInfo

  Пример:
  `{
  "firstName": "Artyom",
  "lastName": "Tsatinyan",
  "email": "patinent2@gmail.com",
  "password": "NYVzp#n9Z727",
  "dateOfBirth": "19.11.2023",
  "gender": "male",
  "contactNumber": "91321321311",
  "address": "dsdsdasd",
  "otherRelevantInfo": "dsdadsjfwefj"
  }`

* #### http://ezhidze.su:8080/medApp/patients/authentication

  GetMapping, аутентификация пользователя

  Json тело запроса должно содержать поля:
  * String email
  * String password

  Пример:
  `{
  "email": "patinent2@gmail.com",
  "password": "NYVzp#n9Z727"
  }`

  Вернёт тело сущности и jwt token

* #### http://ezhidze.su:8080/medApp/patients

  GetMapping, вернёт список всех пациентов

* #### http://ezhidze.su:8080/medApp/patients

  GetMapping, получить пациента по id

  Параметры: **Integer id**

  Пример: http://ezhidze.su:8080/medApp/patients?id=802

* #### http://ezhidze.su:8080/medApp/patients/delete

  DeleteMapping, удалить пациента по id

  Параметры: **Integer id**

  Пример: http://ezhidze.su:8080/medApp/patients/delete?id=652

* #### http://ezhidze.su:8080/medApp/patients/patch

  PatchMapping, изменить тело сущности

  Параметры: **Integer id**

  Json тело запроса должно содержать те поля, которые вы хотите изменить

  Пример: http://ezhidze.su:8080/medApp/patients/patch?id=752

  `{
  "firstName": "Saul",
  "lastName": "Goodman"
  }`

  Вернёт изменённое тело сущности

### Chat controller - http://ezhidze.su:8080/

* #### http://ezhidze.su:8080/chats
  GetMapping, получить список всех чатов
* #### http://ezhidze.su:8080/chats

  GetMapping, получить чат по id

  Параметры: **Integer id**

  Пример: http://ezhidze.su:8080/chats?id=0
* #### http://ezhidze.su:8080/addChat
  PostMapping, добавить чат, вызвывается без параметров, в ответ сервер просто вернёт пустое тело чата с его id
* #### http://ezhidze.su:8080/joinUser

  PutMapping, добавить пользователся в чат

  Параметры: **Integer chatId, Integer userId, String role**

  role: **PATIENT, DOCTOR**

  Пример: http://ezhidze.su:8080/joinUser?chatId=1&userId=1&role=PATIENT

* #### http://ezhidze.su:8080/deleteUser
  PutMapping, удалить пользователя из чата

  Параметры: **Integer chatId, Integer userId, String role**

  role: **PATIENT, DOCTOR**

  Пример: http://ezhidze.su:8080/deleteUser?chatId=2&userId=802&role=PATIENT
* #### http://ezhidze.su:8080/deleteMessage
  PutMapping, удалить сообщение из чата

  Параметры: **Integer chatId, Integer messageId**

  Пример: http://ezhidze.su:8080/deleteMessage?chatId=1&messageId=152

### Medical records controller - http://ezhidze.su:8080/medApp/medicalRecords

* #### http://ezhidze.su:8080/medApp/medicalRecords
  GetMapping, вернёт список всех записей

* #### http://ezhidze.su:8080/medApp/medicalRecords
  GetMapping, вернёт список всех записей

  Параметры: **Integer id**

* #### http://ezhidze.su:8080/medApp/medicalRecords/add
  PostMapping, добавить новую запись~~~~

  Json тело запроса должно содержать поля:
  * Integer patientId
  * Integer doctorId
  * String recordType
  * String messageContent

  Пример:
  `{
  "patientId": 103,
  "doctorId": 102,
  "recordType": "Lab Results",
  "messageContent": "Negotive"
  }`

* #### http://ezhidze.su:8080/medApp/medicalRecords/patch
  PatchMapping, изменить запись

  Параметры: **Integer id**

  Json тело запроса должно содержать те поля, которые вы хотите изменить

* #### http://ezhidze.su:8080/medApp/medicalRecords/delete
  DeleteMapping, удалить запись

  Параметры: **Integer id**

# WebSockets

### ws://ezhidze.su:8080/chat

Логика работы следующая: клиентская часть посылает сообщение в определённый чат(id чата отправляется вместе с объектом message).
Далее сервер рассылает это сообщение всем участникам чата, которые в данный момент онлайн. Далее сервер сохраняет сообщение в чате, для того чтобы клиенты, которые выйдут из состояния офлайн, смогли запросить новые сообщения.
Соответственно если нужно отправить сообщение от одного пользователя другому, то вы создаёте новый чат(если кончено уже не было чата для этих пользователей), добавляете туда пользователей и отправляете ваше сообщение в этот чат,
дальше сервер сам разошлёт сообщение онлайн пользователям и сохранит его для тех кто офлайн на жанный момент.

Для присоединения нужно использовать sockJs

Отправляются сообщения по пути `"/app/private-chat"`

В хедерах запроса должен быть хедер `Authorization` со значением вида `Bearer ...` где вместо `...` должен быть jwt токен клиента

Как сообщение сервер ожидает получить объект класса со следующими полями:

`String senderSubject; Integer chatId; String messageText`

Для получения сообщений нужно подписать клиента на `"/user/topic/private-messages"`

Пример класса сообщений и клиентской части на Java

```java
public class InputMessageModel {

    private String senderSubject;

    private Integer chatId;

    private String messageText;

    public InputMessageModel(String senderSubject, Integer chatId, String messageText) {
        this.senderSubject = senderSubject;
        this.chatId = chatId;
        this.messageText = messageText;
    }

    public InputMessageModel() {
    }

    public String getSenderSubject() {
        return senderSubject;
    }

    public void setSenderSubject(String senderSubject) {
        this.senderSubject = senderSubject;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
```

```java
public class ChatClient {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String url = "ws://ezhidze.su:8080/chat"; //Url для подключения к серверу
        WebSocketClient client = new StandardWebSocketClient();
        List<Transport> transports = new ArrayList<>(1);
        transports.add(new WebSocketTransport(client));
        SockJsClient sockJsClient = new SockJsClient(transports); //Создаём sockJs клиент

        WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        StompSessionHandler sessionHandler = new MyStompSessionHandler();
        WebSocketHttpHeaders webSocketHttpHeaders = new WebSocketHttpHeaders();
        System.out.println("jwt token:");
        webSocketHttpHeaders.add("Authorization", "Bearer " + in.readLine()); //Добавляем хедер с токеном
        StompSession session = stompClient.connect(url, webSocketHttpHeaders, sessionHandler).get(); //Присоединяемся к серверу

        System.out.println("Our email: ");
        String email = in.readLine();
        System.out.println("Chat id: ");
        Integer chatID = Integer.valueOf(in.readLine());
        for (; ; ) {
            String line = in.readLine();
            if (line == null) break;
            if (line.isEmpty()) continue;
            InputMessageModel msg = new InputMessageModel(); //Создаем объект класса сообщений и инициализируем его поля
            msg.setChatId(chatID);
            msg.setSenderSubject(email);
            msg.setMessageText(line);
            session.send("/app/private-chat", msg); //Отправляем сообщение на сервер в чат
        }
    }

    static public class MyStompSessionHandler extends StompSessionHandlerAdapter {

        @Override
        public Type getPayloadType(StompHeaders headers) {
            return InputMessageModel.class;
        }

        @Override
        public void handleFrame(StompHeaders headers, Object payload) {
            InputMessageModel msg = (InputMessageModel) payload;
            System.out.println("Received : " + msg.getMessageText() + " from : " + msg.getSenderSubject());
        }

        @Override
        public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
            session.subscribe("/topic/messages", this);
            session.subscribe("/user/topic/private-messages", this); //Подписываемся на получение сообщений
        }
    }
}
```