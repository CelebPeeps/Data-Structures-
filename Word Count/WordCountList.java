
/**
 * This WordCountList class represents . . .
 *
 * @author  (your name)
 * @version (todays date)
 */
public class WordCountList implements WordCountListInterface
{
    private int size = 0;
    private WordCount [] words;
    private int defCap = 100;
    public WordCountList () {
        words = new WordCount [defCap];
    }
    // return the logical size of the list
    public int size() {
        return size;
    }

    public void enlarge() {
        WordCount [] largerWords = new WordCount [words.length + defCap];
        for (int i = 0; i < words.length; i++) {
            largerWords[i] = words[i];
        }
        words = largerWords;
    }
    
    // if the word is new to the list, add a new WordCount
    // object to the list, otherwise increment the counter
    // in the existing WordCount object.
    public void add(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i] != null && words[i].getWord().equals(word)) {
                words[i].increment();
                return;
            }
        }
        if (size == words.length) {
            enlarge();
        }
        words[size] = new WordCount(word);
        size++;
    }
    
    // return the WordCount object located at index
    public WordCount get(int index) {
        return words[index];
    }
    
    // sort the list in order of most frequent words first}
    public void rank() {
        WordCount temp = null;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if(words[i] != null && words[j] != null) {
                    if(words[j].getCount() > words[i].getCount()) {
                        temp = words[i];
                        words[i] = words[j];
                        words[j] = temp;
                    }
                }
            }
        }
    }
}
