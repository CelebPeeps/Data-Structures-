/**
 * This interface represents the methods that must be implimented
 * by WordCountList objects
 */
public interface WordCountListInterface
{
    // return the logical size of the list
    public int size();	

    // if the word is new to the list, add a new WordCount
    // object to the list, otherwise increment the counter
    // in the existing WordCount object.
    public void add(String word);
    
    // return the WordCount object located at index
    public WordCount get(int index);
    
    // sort the list in order of most frequent words first}
    public void rank();
}
