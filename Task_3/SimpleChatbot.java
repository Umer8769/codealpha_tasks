package  Task_3;

import java.util.Scanner;

public class SimpleChatbot {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("Chatbot: Hello! Ask me something.");

        while (true) {
            System.out.print("You: ");
            input = sc.nextLine().toLowerCase();

            if (input.contains("hello")) {
                System.out.println("Chatbot: Hi there!");
            } 
            else if (input.contains("how are you")) {
                System.out.println("Chatbot: I'm just code, but I'm functioning perfectly!");
            } 
            else if (input.contains("bye")) {
                System.out.println("Chatbot: Goodbye!");
                break;
            } 
            else {
                System.out.println("Chatbot: Sorry, I don't understand that.");
            }
        }

        sc.close();
    }
}
