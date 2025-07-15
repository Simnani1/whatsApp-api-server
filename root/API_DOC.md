 User (My Profile)

### 🔹 Create User
POST /api/users

**Request Body:**
```json
{
  "name": "John",
  "phone": "9999999999",
  "profilePictureUrl": "/profile/john.jpg",
  "status": "Available"
}



Get User Profile
GET /api/users/{id}

 Update Profile
PUT /api/users/{id}


Chatroom
🔹 Create Chatroom
POST /api/chatrooms

Request Body:
{
  "name": "Dev Group",
  "isGroup": true,
  "createdBy": 1,
  "memberIds": [1, 2, 3]
}


List User’s Chatrooms (Paginated)
GET /api/chatrooms?userId=1&page=0&size=10

 Get Chatroom by ID
GET /api/chatrooms/{id}



##Messages
🔹 Send Message (Text or Attachment)
POST /api/chatrooms/{chatroomId}/messages

Form-Data Params:

senderId: Long

text: (optional)

attachment: (optional, file ≤ 10MB)

Get Messages in Chatroom (Paginated)
GET /api/chatrooms/{chatroomId}/messages?page=0&size=10


##Emoji Reactions
🔹 Add Emoji Reaction
POST /api/messages/{messageId}/reactions?userId=2&emoji=thumbup

Allowed emojis:

thumbup

love

crying

surprised


List Reactions for a Message
GET /api/messages/{messageId}/reactions


##File Upload & Storage
Uploads accepted:

Images: jpg, png, gif

Videos: mp4, avi, mov, mkv

Max upload size: 10MB

Stored in server directory:

Images → root/picture/

Videos → root/video/


##Pagination Support
All list APIs support pagination using query parameters:

page (default: 0)

size (default: 10)