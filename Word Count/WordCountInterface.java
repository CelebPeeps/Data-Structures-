
/**
 * This interface represents the methods that must be implimented
 * by WordCount objects
 */
public interface WordCountInterface extends Comparable<WordCount>
{
    // return the word itself
    public String getWord();

    // return the word count value
    public int getCount();   

    // increment the word counter for this object
    public void increment();

    // returns a String in the form of "word count"
    public String toString();    

    // returns true if both words are identical
    public boolean equals(WordCount other);
    
    // returns other.count minus this.count
    @Override // (this overrides the method in the Comparable interface)
    public int compareTo(WordCount other);
}
