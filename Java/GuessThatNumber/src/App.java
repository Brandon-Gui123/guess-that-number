import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        final int LOWER_LIMIT = 1;
        final int UPPER_LIMIT = 100;

        // UPPER_LIMIT + 1 because it is exclusive
        int numberToGuess = (int)(LOWER_LIMIT + Math.random() * (UPPER_LIMIT + 1));
        int numGuesses = 0;

        printlnFormatted("A random number from %s to %s has been generated!", LOWER_LIMIT, UPPER_LIMIT);

        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            printFormatted("Guess the number [%s, %s]: ", LOWER_LIMIT, UPPER_LIMIT);
            String userInput = scanner.nextLine();

            int userGuess;
            try {
                userGuess = Integer.parseInt(userInput);
            } catch (NumberFormatException ex) {
                System.out.println("That's not a valid input! Please enter an integer.");
                continue;
            }

            numGuesses++;

            if (userGuess > numberToGuess) {
                System.out.println("Go lower!");
            } else if (userGuess < numberToGuess) {
                System.out.println("Go higher!");
            } else {
                printlnFormatted("Correct! It took you %s guesses.", numGuesses);
                break;
            }
        }
        
        scanner.close();
    }

    // To make it terse
    private static void printlnFormatted(String str, Object... args)
    {
        System.out.println(String.format(str, args));
    }

    private static void printFormatted(String str, Object... args)
    {
        System.out.print(String.format(str, args));
    }
}
