
/**
 * This WordCount class represents . . .
 *
 * @author  (your name)
 * @version (todays date)
 */
public class WordCount implements WordCountInterface
{
    // return the word itself
    private String word; 
    private int count;
    
    public WordCount(String word) {
        this.word = word;
        count = 1;
    }
    public String getWord() {
        return word;
    }

    // return the word count value
    public int getCount() {
        return count;
    }

    // increment the word counter for this object
    public void increment() {
        count++;
    }

    // returns a String in the form of "word count"
    public String toString() {
        return word + " " + count;
    }

    // returns true if both words are identical
    public boolean equals(WordCount other) {
        if (other.getWord().equals(word)) {
            return true;
        }
        return false;
    }
    
    // returns other.count minus this.count
    @Override // (this overrides the method in the Comparable interface)
    public int compareTo(WordCount other) {
        return (other.count - this.count);
    }
}
