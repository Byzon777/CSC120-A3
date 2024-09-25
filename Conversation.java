import java.util.Random;
import java.util.Scanner;

/**
 * The Conversation class creates a simple chatbot that engages in a conversation
 * with the user by responding to their inputs. The chatbot attempts to mirror the user's
 * statements and generate random responses if personal pronouns are not detected.
 */
class Conversation {

    /**
     * The main method is the entry point of the program. It handles the conversation 
     * by reading user inputs, generating responses, and printing a transcript of the conversation.
     */
    public static void main(String[] arguments) {
        //scan user response 
        Scanner scanner = new Scanner(System.in);  
        StringBuilder transcript = new StringBuilder(); // stringbuilder object to create the transcrip of the conversation 
        Random random = new Random(); 

        System.out.println("How many rounds?"); 
        int linesnum = scanner.nextInt(); // read from the console 
        scanner.nextLine();

        System.out.println("Hi there! What's on your mind?"); 
        
        // reitirate the action to make a conversation 
        for (int i = 0; i < linesnum; i++) {
            String userInput = scanner.nextLine();
            transcript.append(userInput).append("\n");
            
            StringBuilder autoResponder = new StringBuilder();
            String reponse = " ";

            // array of user entered text to manipulate with words
            String[] words = userInput.split(" ");
            // arry of pronouns that need to be mirrored
            String[] pronouns = {"I", "me", "am", "you", "my", "your"};
            
            
            boolean hasPronoun = false;
            boolean ismirrored = false;

            // Check if the user's input contains any pronouns.
            for (String word : words) {
                for (String pronoun : pronouns) {
                    if (word.equalsIgnoreCase(pronoun)) {
                        hasPronoun = true;
                        break;
                    }
                }
                if (hasPronoun) break;
            }

            // Mirror the pronouns in the user's input if found.
            if (hasPronoun) {
                for (String word : words) {
                    switch (word.toLowerCase()) {
                        case "i":
                            autoResponder.append("you").append(" ");
                            ismirrored = true;
                            break;
                        case "me":
                            autoResponder.append("you").append(" ");
                            ismirrored = true;
                            break;
                        case "am":
                            autoResponder.append("are").append(" ");
                            ismirrored = true;
                            break;
                        case "you":
                            autoResponder.append("I").append(" ");
                            ismirrored = true;
                            break;
                        case "my":
                            autoResponder.append("your").append(" ");
                            ismirrored = true;
                            break;
                        case "your":
                            autoResponder.append("my").append(" ");
                            ismirrored = true;
                            break;
                        default:
                            autoResponder.append(word).append(" ");
                            break;
                    }
                }
                reponse = autoResponder.toString().trim() +'?';
            } else {
                // Generate a random response if the input does not contain pronouns.
                String[] randomResponses = {"Neat!", "Interesting.", "I want to know more about it!", "I see.", "That's great!", "Hope you have a great day!"};
                reponse = randomResponses[random.nextInt(randomResponses.length)];
            }

            transcript.append(reponse).append("\n"); // fill the transcript message with all sentences of conversation
            System.out.println(reponse.toString().trim());
        }

        System.out.println("See ya!\n");
        System.out.println("TRANSCRIPT:\n" + transcript.append("See ya!").toString());

        scanner.close();
    }
}
