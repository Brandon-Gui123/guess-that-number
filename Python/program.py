# 1. Generate number
# 2. Ask user to guess
# 3. Check guess
# 4. Guess higher? Lower? Or is on the dot?

import random

LOWER_LIMIT = 1
UPPER_LIMIT = 100

NUMBER_TO_GUESS = random.randint(LOWER_LIMIT, UPPER_LIMIT)
num_guesses = 0

# both lower and upper limits are inclusive, so no need to subtract or add
print(f"A random number from {LOWER_LIMIT} to {UPPER_LIMIT} has been generated!")

while True:
    try:
        userGuess = int(input(f"Guess the number [{LOWER_LIMIT}, {UPPER_LIMIT}]: "))
    except ValueError:
        print("That's not a valid input! Please enter an integer.")
        continue

    num_guesses += 1

    if userGuess > NUMBER_TO_GUESS:
        print("Go lower!")
    elif userGuess < NUMBER_TO_GUESS:
        print("Go higher!")
    else:
        print(f"Correct! It took you {num_guesses} guesses.")
        break
