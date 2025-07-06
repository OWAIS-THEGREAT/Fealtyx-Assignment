# 🧠 FealtyX - Student Summary API (Spring Boot + Docker + Ollama)

A simple REST API that manages student records and generates AI-powered summaries using [Ollama](https://ollama.com) (local LLM server).  
Built with **Java 21**, **Spring Boot**, and **Docker**.

---

## 🚀 Features

- ✅ CRUD operations on student records
- ✅ AI summary generation using Ollama (TinyLlama)
- ✅ RESTful JSON API
- ✅ Dockerized for easy deployment
- ✅ Deployed live on [Render](https://render.com)

---

## 🌍 Live Demo

🔗 **[https://fealtyx-assignment-5ecs.onrender.com](https://fealtyx-assignment-5ecs.onrender.com)**

> Note: The `/summary` endpoint is disabled or mocked on cloud since Ollama requires local installation.

---

## 📽️ Demo Video

📺 [Click to watch demo video](https://drive.google.com/file/d/1qsEN8Fa2tpBDcdWTvnzvjMNhhCWsiDrD/view?usp=drive_link)

---

## 📦 Tech Stack

- Java 21
- Spring Boot
- Gradle
- Docker
- Ollama (LLM engine)
- Render (for deployment)

---

## 🧪 API Endpoints

| Method | Endpoint               | Description                         |
|--------|------------------------|-------------------------------------|
| POST   | `/students`            | Create a new student                |
| GET    | `/students`            | Retrieve all students               |
| GET    | `/students/{id}`       | Retrieve a student by ID            |
| PUT    | `/students/{id}`       | Update student by ID                |
| DELETE | `/students/{id}`       | Delete student by ID                |
| GET    | `/students/{id}/summary` | Generate AI summary (requires Ollama locally) |

---

## 🧠 Summary Generation Note

The `/students/{id}/summary` endpoint uses a local LLM model (TinyLlama via [Ollama](https://ollama.com)).  
This **does not work on cloud deployment** (e.g., Render) since Ollama must run locally.

### 🛠 To test locally:
1. [Install Ollama](https://ollama.com/download)
2. Run:
   ```bash
   ollama run tinyllama
