package org.example;

import edu.stanford.nlp.pipeline.*;
import java.util.Properties;
import java.util.Scanner;

public class Chatbot {
    private final StanfordCoreNLP pipeline;

    public Chatbot() {
        try {
            Properties props = new Properties();
            // Use just tokenize and ssplit for now since you're not using POS/NER
            props.setProperty("annotators", "tokenize,ssplit");
            props.setProperty("tokenize.options", "untokenizable=noneDelete");
            pipeline = new StanfordCoreNLP(props);
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize NLP pipeline", e);
        }
    }

    public String getResponse(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Please say something!";
        }

        try {
            // Simple NLP processing
            CoreDocument doc = new CoreDocument(input);
            pipeline.annotate(doc);

            String lower = input.toLowerCase();

            if (lower.contains("hello") || lower.contains("hi")) {
                return "Hi there! How can I help you today?";
            } else if (lower.contains("your name")) {
                return "I'm ChatBot, your virtual assistant!";
            } else if (lower.contains("weather")) {
                return "I'm not sure about the weather, but it's always sunny in code!";
            } else if (lower.contains("bye")) {
                return "Goodbye! Have a great day!";
            } else {
                return "Hmm... I'm still learning. Can you ask something else?";
            }
        } catch (Exception e) {
            return "I encountered an error processing your request. Please try again.";
        }
    }

    public static void main(String[] args) {
        Chatbot bot = new Chatbot();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("ChatBot: Hello! Type 'bye' to exit.");

            while (true) {
                System.out.print("You: ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("bye")) {
                    System.out.println("ChatBot: Goodbye!");
                    break;
                }

                String response = bot.getResponse(input);
                System.out.println("ChatBot: " + response);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}