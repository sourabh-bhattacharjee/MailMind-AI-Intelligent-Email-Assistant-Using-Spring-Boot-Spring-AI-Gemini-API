# MailMind-AI-Intelligent-Email-Assistant-Using-Spring-Boot-Spring-AI-Gemini-API
An AI-powered email assistant built using Spring Boot, Spring AI, and Google Gemini API, integrated with a Chrome Extension for Gmail to help users generate smart email replies, summaries, and professional responses in real time.

Features

* ✨ AI-generated email replies
* 📧 Gmail integration using Chrome Extension
* 🤖 Google Gemini API integration
* ⚡ Spring AI for AI service orchestration
* 🧠 Context-aware response generation
* 📝 Email summarization
* 🎯 Professional tone suggestions
* 🔒 Secure backend API architecture
* ☁️ Deployment-ready application

🛠️ Tech Stack

Backend

* Spring Boot
* Spring AI
* Java 25
* Maven
* REST APIs

AI Integration

* Google Gemini API
* Prompt Engineering

Frontend / Extension

* Google Chrome Extension
* HTML
* CSS
* JavaScript

⚙️ How It Works

1. User opens Gmail
2. Chrome extension injects AI assistant UI
3. User clicks “Generate Reply”
4. Email content is sent to Spring Boot backend
5. Backend processes prompts using Spring AI
6. Gemini API generates intelligent response
7. AI-generated reply appears instantly in Gmail

📡 API Endpoints

Generate AI Reply

Request Body 

    {
        "emailContent": "Can we schedule a meeting tomorrow?",
        "tone": "professional"
    }

Response

    {
        "reply": "Certainly! I am available tomorrow for a meeting..."
    }


👨‍💻 Author

Sourabh Bhattacharjee

Full Stack Java Developer | Spring Boot | AI Integration