import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Beata Iłowiecka on 14.04.16.
 */
public class SentenceShuffler {

    String sentence;

    public String getShuffledSentence() {
        return shuffledSentence;
    }

    String shuffledSentence;

    public SentenceShuffler(String sentence) {
        this.sentence = sentence;
        this.shuffledSentence = shuffle();
    }

    public String shuffle(){
        StringBuilder newSentence = new StringBuilder();
        StringTokenizer pieces = cutIntoPieces();

        while (pieces.hasMoreElements()){
            String word = (String) pieces.nextElement();
            if (word.length() > 4){
                newSentence.append(shuffleOneWord(word));
            }
            else {
                newSentence.append(word);
            }
            newSentence.append(" ");
        }
        return newSentence.toString();
    }

    private StringTokenizer cutIntoPieces(){
        return new StringTokenizer(sentence, ",./?;:\"\'()\\!");
    }

    private String shuffleOneWord(String word) {
        StringBuilder shuffledWord = new StringBuilder();
        List<Character> shuffled = new ArrayList<>();

        char[] wordCut = word.toCharArray();
        List<Character> chars = new ArrayList<>();

        for (char character : wordCut) {
            chars.add(character);
        }
        List<Integer> randomIndexes = generateRandomIndexes(chars);

        int start = 0;
        for (char character : chars) {
            if (chars.indexOf(character) > 0 || chars.indexOf(character) < (chars.size() - 1)) {
                shuffled.add(randomIndexes.get(start), character);
                start++;
            } else {
                shuffled.add(character);
                start++;
            }
        }

        for (char character : shuffled){
            shuffledWord.append(character);
        }
        return shuffledWord.toString();
    }

    private List<Integer> generateRandomIndexes(List<Character> chars) {
        List<Integer> randomIndexes = new ArrayList<>();
        while (randomIndexes.size() != chars.size() - 2){
            for (int index = 1; index < chars.size() - 1; index++){
                int randomIndex = (int) Math.round(Math.random() * (chars.size() - 2));
                if (!randomIndexes.contains(randomIndex)){
                    randomIndexes.add(randomIndex);
                }
                else {
                    continue;
                }
            }
        }
        return randomIndexes;
    }
}
