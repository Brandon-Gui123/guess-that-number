// 1. Generate number
// 2. Ask user to guess
// 3. Check guess
// 4. Guess higher? Lower? Or is on the dot?

const int lowerLimit = 1;
const int upperLimit = 101;

var rng = new Random();
int numberToGuess = rng.Next(lowerLimit, upperLimit);

int numGuesses = 0;

// the upperLimit is exclusive, so we have to go one lower to become inclusive
Console.WriteLine($"A random number from {lowerLimit} to {upperLimit - 1} has been generated!");

while (true)
{
    Console.Write($"Guess the number [{lowerLimit}, {upperLimit - 1}]: ");
    string? userInput = Console.ReadLine();

    if (!int.TryParse(userInput, out int userGuess))
    {
        Console.WriteLine("That's not a valid input! Please enter an integer.");
        continue;
    }

    numGuesses++;

    if (userGuess > numberToGuess)
    {
        Console.WriteLine("Go lower!");
    }
    else if (userGuess < numberToGuess)
    {
        Console.WriteLine("Go higher!");
    }
    else
    {
        Console.WriteLine($"Correct! It took you {numGuesses} guesses.");
        break;
    }
}
