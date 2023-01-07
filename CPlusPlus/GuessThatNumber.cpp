#include <random>       // for random number generation
#include <ctime>        // for obtaining the current time
#include <cstdio>       // C-style IO
#include <string>       // for reading stdin and converting strings
#include <iostream>     // for getting cin and cout

int main()
{
    constexpr int lowerLimit{0};
    constexpr int upperLimit{100};

    std::mt19937 mt{std::time(nullptr)};
    std::uniform_int_distribution oneToHundred{lowerLimit, upperLimit};

    int numberToGuess{oneToHundred(mt)};
    int numGuesses{0};
    int userGuess{};

    std::printf("A random number from %i to %i has been generated!\n", lowerLimit, upperLimit);

    while (true)
    {
        std::printf("Guess the number [%i, %i]: ", lowerLimit, upperLimit);
        std::string userInput{};
        std::getline(std::cin, userInput);

        try
        {
            userGuess = std::stoi(userInput);
        }
        catch (...)
        {
            std::cout << "That's not a valid input! Please enter an integer.\n";
            continue;
        }

        ++numGuesses;

        if (userGuess > numberToGuess)
        {
            std::cout << "Go lower!\n";
        }
        else if (userGuess < numberToGuess)
        {
            std::cout << "Go higher!\n";
        }
        else
        {
            std::printf("Correct! It took you %i guesses.\n", numGuesses);
            break;
        }
    }

    return EXIT_SUCCESS;
}
