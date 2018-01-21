package nyc.c4q.ramonaharrison.buggyapp;

/**
 * A class that analyzes words.
 */
public class WordAnalyzer {
    /**
     * Constructs an analyzer.
     */
    public WordAnalyzer() {

    }

    /**
     * Gets the first repeated character. A character is <i>repeated</i>
     * if it occurs at least twice in adjacent positions. For example,
     * 'l' is repeated in "hollow", but 'o' is not.
     *
     * @return the first repeated character, or 0 if none found
     */
    public char firstRepeatedCharacter(String word) {
        //The bug is when the loop get to the end and the if statement check the char after the end of the word.
        for (int i = 1; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == word.charAt(i - 1))
                return ch;
        }
        return 0;
    }

    /**
     * Gets the first multiply occuring character. A character is <i>multiple</i>
     * if it occurs at least twice in the word, not necessarily in adjacent positions.
     * For example, both 'o' and 'l' are multiple in "hollow", but 'h' is not.
     *
     * @return the first repeated character, or 0 if none found
     */
    public char firstMultipleCharacter(String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (find(word, ch, i) >= 0)
                return ch;
        }
        return 0;
    }

    private int find(String word, char c, int pos) {
        //I change the if statement so that the loops skips the position of the char that is submitted.
        for (int i = pos; i < word.length(); i++) {
            if (word.charAt(i) == c && i != pos) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Counts the groups of repeated characters. For example, "mississippi!!!" has
     * four such groups: ss, ss, pp and !!!.
     *
     * @return the number of repeated character groups
     */
    public int countRepeatedCharacters(String word) {
        int c = 0;
        for (int i = 1; i < word.length() - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                if (word.charAt(i - 1) != word.charAt(i)) {
                    c++;
                }
                //I added an else if to check if the first letter
                //is a repeated character because the stuff before it skips the first letter.
            } else if (word.charAt(i) == word.charAt(i - 1) && i == 1){
                c++;
            }
        }
        return c;
    }
}