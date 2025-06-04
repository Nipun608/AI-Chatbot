<h1 align="center">🧠 ChatbotAI</h1>
<p align="center"><b>A Java-Based Rule-Based Chatbot using Stanford CoreNLP</b></p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white"/>
  <img src="https://img.shields.io/badge/NLP-Stanford%20CoreNLP-red?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/TTS-FreeTTS-blue?style=for-the-badge"/>
</p>

---

ChatbotAI is a lightweight, rule-based chatbot developed in Java and powered by **Stanford CoreNLP** for basic natural language processing. It now includes **text-to-speech (TTS)** capabilities using **FreeTTS**, basic arithmetic processing, and real-time system time retrieval.

---

### 🔧 Technologies Used

| Tool | Description |
|------|-------------|
| 💻 **Java** | Core programming language |
| 🧠 **Stanford CoreNLP (v4.5.1)** | Tokenization & sentence splitting |
| 📦 **Maven** | Project build and dependency management |
| 🗣️ **FreeTTS** | Text-to-Speech synthesis |
| 🪵 **SLF4J (Simple Logging Facade for Java)** | Logging (`slf4j-simple`) |

---

### 💡 Features

- 🧠 **Basic NLP** using CoreNLP annotators: `tokenize`, `ssplit`
- 💬 **Interactive console-based chatbot** with keyword matching
- 🧾 **Rule-based responses** for greetings, weather, and identity
- ➕ **Basic arithmetic handling** (e.g., `What is 5 + 3?`)
- 🕒 **Real-time system time** response (e.g., `What is the time?`)
- 🔊 **Voice output using FreeTTS** – chatbot speaks its responses!
- 🧱 Modular, readable structure ideal for learning or extending

---

### 📦 How It Works

```text
1. User inputs a message via the console.
2. Stanford CoreNLP processes the text using annotators.
3. The chatbot detects patterns or keywords in the input.
4. A predefined response is generated and spoken aloud via FreeTTS.
