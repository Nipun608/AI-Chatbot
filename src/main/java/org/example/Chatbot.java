package org.example;

import edu.stanford.nlp.pipeline.*;

import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;




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
            } else if (lower.contains("your features") || lower.contains("what can you do")) {
                return "I can help you with various tasks, such as answering questions, providing information, and performing calculations. How can I assist you today?";
            } else if (lower.contains("weather")) {
                return "I'm not sure about the weather, but it's always sunny in code!";
            } else if (lower.contains("bye")) {
                return "Goodbye! Have a great day!";
            } else if (input.matches(".*\\d+\\s*\\+\\s*\\d+.*")) {
                Pattern pattern = Pattern.compile(".*?(\\d+)\\s*\\+\\s*(\\d+).*");
                Matcher matcher = pattern.matcher(input);
                if (matcher.find()) {
                    int num1 = Integer.parseInt(matcher.group(1));
                    int num2 = Integer.parseInt(matcher.group(2));
                    int result = num1 + num2;
                    return "The answer is: " + result;
                }
                return "I couldn't process that calculation.";
            } else if (lower.contains("what is the time")) {
                return "The time is: " + java.time.LocalTime.now().withNano(0);
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
                bot.speak(response);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public void speak(String text) {
        System.out.println("Speaking: " + text);

        System.setProperty("freetts.voices",
                "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

        try {
            VoiceManager voiceManager = VoiceManager.getInstance();
//            System.out.println("Available voices: " + Arrays.toString(voiceManager.getVoices()));

            Voice voice = voiceManager.getVoice("kevin");
            if (voice == null) {
                voice = voiceManager.getVoices()[0];
            }

            if (voice != null) {
                voice.allocate();
                voice.speak(text);
                voice.deallocate();
                System.out.println("Speech done.");
            } else {
                System.out.println("No voices available.");
            }
        } catch (Exception e) {
            System.err.println("Error during speech: " + e.getMessage());
        }
    }


}