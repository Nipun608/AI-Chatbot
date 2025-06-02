<h1 align="center">🧠 ChatbotAI</h1>
<p align="center"><b>A Java-Based Rule-Based Chatbot using Stanford CoreNLP</b></p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white"/>
  <img src="https://img.shields.io/badge/NLP-Stanford%20CoreNLP-red?style=for-the-badge"/>
</p>

---

ChatbotAI is a lightweight, rule-based chatbot developed in Java and powered by **Stanford CoreNLP** for simple natural language processing tasks such as **tokenization** and **sentence splitting**. It's a beginner-friendly project that demonstrates the fundamentals of building a console-based conversational assistant.

---

### 🔧 Technologies Used

| Tool | Description |
|------|-------------|
| 💻 **Java** | Core programming language |
| 🧠 **Stanford CoreNLP (v4.5.1)** | Tokenization & sentence splitting |
| 📦 **Maven** | Project build and dependency management |
| 🪵 **SLF4J (Simple Logging Facade for Java)** | Logging (`slf4j-simple`) |

---

### 💡 Features

- 🧠 Basic NLP with CoreNLP annotators: `tokenize`, `ssplit`
- 🧾 Rule-based keyword detection (e.g., `hello`, `bye`, `weather`)
- 💬 Interactive console-based chatbot using `Scanner`
- 🧱 Simple, modular structure ideal for learning or extension

---

### 📦 How It Works

```text
1. User inputs a message via the console.
2. Stanford CoreNLP processes the text using basic annotators.
3. The chatbot scans for known keywords (like "hello" or "weather").
4. A relevant hardcoded response is returned.
```

---

### ⚠️ Limitations

- ❌ No machine learning or AI-based intent detection  
- 🧠 Lacks memory or contextual conversation handling  
- ⛔ Only responds to static keyword-based inputs  

---

> 🎯 Ideal for students, beginners in NLP, or developers exploring chatbot development without deep AI.
