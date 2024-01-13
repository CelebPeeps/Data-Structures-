/**
 * This class represents a game of Evil Secret Word,
 * where the computer keeps changing the word 
 * depending on what letters you have guessed
 * 
 * @author (your name) 
 * @version (the date)
 */

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class EvilSecretWord
{
    private boolean debug;
    private Scanner scanner;
    private List<String> words;
    private int wordLength;
    private int remainingGuesses;
    private String solution;
    private String guessedLetters;

    /**
     * Construct an EvilSecretWord object and initiailize all instance variables.
     * @param fineName the name of the file that contains the word list.
     * @param debug indicates if the size of the remaining word list
     *        should be included in the toString result.
     * @throws FileNotFoundException when the fileName file does not exist.
     */
    public EvilSecretWord(String fileName, boolean debug)
        throws FileNotFoundException
    {
        this.debug = debug;
        scanner = new Scanner(System.in);
        inputWords(fileName);
        System.out.print("Number of guesses? ");
        remainingGuesses = scanner.nextInt();
        solution = "";
        for (int i = 0; i < wordLength; i++)
            solution += "-";
        guessedLetters = "";
    }

    /**
     * Plays one the game.  The user guesses letters until either
     * they guess the word, or they run out of guesses.
     * Game status is printed each turn and winning / losing
     * information is printed at the conclusion of the game.
     */
    public void playGame()
    {
        // insert while loop here
        while (solution.contains("-") && remainingGuesses > 0) {
            System.out.println(this);
            var letter = inputLetter();
            var patterns = getPatterns(letter);
            var partitions = getPartitions(patterns, letter);
            words = getLargestRemaining(partitions);
            var temp = solution;
            substitute(words.get(0), letter);
            if (temp.equals(solution)) {
                remainingGuesses--;
            }
        }
        
        if(remainingGuesses > 0)
            System.out.println("You win, congratulations!");
        else
            System.out.println("You lose, sorry!");
            
        int index = 0;  // create a random index here   
        System.out.println("The word was \"" + words.get(index) + "\"");
    }

    /**
     * Creates and returns a status string that indicates the
     * state of the game.
     * @return the game status string.
     */
    public String toString()
    {
        String result = "\n";
        result += "Remaining guesses: " + remainingGuesses + "\n";
        result += "Guessed letters: " + guessedLetters + "\n";
        result += "Solution: " + solution + "\n";
        if (debug)
            result += "Remaining words: " + words.size() + "\n";
        return result;
    }


    ////////// PRIVATE HELPER METHODS //////////

    /**
     * Helper method for the constructor:
     * Inputs the word length from the user, reads in the words from
     * the fileName file, and initializes the words instance variable
     * with the words of the correct length.  This method loops until
     * a valid word length is entered.
     * @param fineName the name of the file that contains the word list.
     * @throws FileNotFoundException when the fileName file does not exist.
     */
    private void inputWords(String fileName) throws FileNotFoundException
    {
        words = new ArrayList<String>();

        while (words.size() == 0)
        {
            System.out.print("Word length? ");
            wordLength = scanner.nextInt();

            Scanner file = new Scanner(new File(fileName));
            while (file.hasNext())
            {
                String word = file.next();
                if (word.length() == wordLength)
                    words.add(word);
            }

            if (words.size() == 0)
                System.out.println("There are no words with " +
                    wordLength + " letters.");
        }
    }

    /**
     * Helper method for playGame:
     * Inputs a one-letter string from the user.
     * Loops until the string is a one-character character in the range
     * a-z or A-Z.
     * @return the single-letter string converted to upper-case.
     */
    private String inputLetter()
    {
        String letter = null;
        while (letter == null)
        {
            System.out.print("Next letter? ");
            letter = scanner.next().toUpperCase();

            if (letter.length() != 1 ||
            "A".compareTo(letter) > 0 ||
            "Z".compareTo(letter) < 0)
            {
                letter = null;
                System.out.println("Invalid input!");
            }
            else if (guessedLetters.contains(letter))
            {
                letter = null;
                System.out.println("You have already guessed that letter!");
            }
        }
        char[] charArray = (guessedLetters += letter).toCharArray();
        Arrays.sort(charArray);
        guessedLetters = new String(charArray);
        return letter;
    }

    /**
     * Helper method for getPatterns:
     * Uses word and letter to create a pattern.  The pattern string
     * has the same number of letters as word.  If a character in
     * word is the same as letter, the pattern is letter; Otherwise
     * it's "-".
     * @param word the word used to create the pattern
     * @param letter the letter used to create the pattern
     * @return the pattern
     */
    private String getPattern(String word, String letter)
    {
        String pattern = "";
        ArrayList<String> random = new ArrayList<String>();
        for (int q = 0; q < word.length(); q++) {
            random.add(word.substring(q, q + 1));
        }
        for (int s = 0; s < word.length(); s++) {
            if(letter.equals(random.get(s))) {
                pattern += letter;
            }
            else {
                pattern += "-";
            }
        }
        return pattern;
    }

    /**
     * Helper method for playGame:
     * Gets the patterns for all words in words using letter.
     * @param letter the letter used to find the patterns.
     * @return the list of patterns.
     */
    private List<String> getPatterns(String letter)
    {
        ArrayList<String> random = new ArrayList<String>();
        for (String word : words) {
            if (!random.contains(getPattern(word, letter))) {
                random.add(getPattern(word, letter));
            }
        }
        return random;    // REPLACE
    }

    /**
     * Helper method for playGame:
     * Partitions each list in words based on the list of patterns
     * and letter.
     * @param patterns the list of patterns
     * @param letter the letter used to find the pattern for
     *        each word in words.
     * @return the list of partitions.  The ith partition corresponds
     *         to the ith pattern.
     */
    private List<List<String>> getPartitions(List<String> patterns, String letter)
    {
        ArrayList<List<String>> Partitions = new ArrayList<List<String>>();
        for (String pattern : patterns) {
            Partitions.add(new ArrayList<String>());
        }
        for (String word : words) {
            String pattern = getPattern(word, letter);
            int index = patterns.indexOf(pattern);
            var list = Partitions.get(index);
            list.add(word);
        }
        return Partitions;    // REPLACE
    }

    /**
     * Helper method for playGame:
     * Determines the largest of the list of partitions.
     * @param partitions the list of partitions.
     * @return the largest partition.
     */
    private List<String> getLargestRemaining(List<List<String>> partitions)
    {
        int largest = 0;
        for (int i = 0; i < partitions.size(); i++) {
            if(partitions.get(i).size() > partitions.get(largest).size()) {
                largest = i;
            }
        }
        return partitions.get(largest);    // REPLACE
    }

    /**
     * Helper method for playGame:
     * Creates a new string for solution.  If the ith letter of
     * found equals letter, then the ith letter of solution is
     * changed to letter; Otherwise it is unchanged.
     * @param found the string to check for occurances of letter.
     * @param letter the letter to check for in found.
     */
    private void substitute(String found, String letter)
    {
        for( int i = 0; i < found.length(); i++) {
            if(found.substring(i, i+1).equals(letter)) {
                solution = solution.substring(0, i) + letter + solution.substring(i+1);
            }
        }
    }
}
