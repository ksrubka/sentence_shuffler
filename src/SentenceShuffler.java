import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Beata Iłowiecka on 14.04.16.
 */
public class SentenceShuffler {

    String sentence;
    String shuffledSentence;

    public SentenceShuffler(String sentence) {
        this.sentence = sentence;
        this.shuffledSentence = shuffle();
    }

    public void testStringTokenizer(){
        StringTokenizer pieces = cutIntoPieces();

        while (pieces.hasMoreElements()){
            String word = (String) pieces.nextElement();
            System.out.println(word + "\n");
        }
    }

    public String shuffle(){
        StringBuilder newSentence = new StringBuilder();
        StringTokenizer pieces = cutIntoPieces();

        while (pieces.hasMoreElements()){
            String word = pieces.nextToken();

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
        return new StringTokenizer(sentence, " ,./?;:\"\'()\\!");
    }

    private String shuffleOneWord(String word) {
        StringBuilder shuffledWord = new StringBuilder();

        char[] wordCut = word.toCharArray();
        List<Character> chars = new ArrayList<>();

        for (char character : wordCut) {
            chars.add(character);
        }
        List<Integer> randomIndexes = generateRandomIndexes(chars);
        char[] shuffled = new char[chars.size()];


        shuffled[0] = chars.get(0);

        for (int index = 1; index < chars.size() -1; index++) {
            int randomIndex = randomIndexes.get(index-1);
            shuffled[randomIndex] = chars.get(index);
        }
        shuffled[chars.size()-1] = chars.get(chars.size()-1);

        for (char character : shuffled){
            if (!(character == '\u0000')){
                shuffledWord.append(character);
            }
        }
        return shuffledWord.toString();
    }

    public static List<Integer> generateRandomIndexes(List<Character> chars) {
        List<Integer> randomIndexes = new ArrayList<>();
        while (randomIndexes.size() != chars.size() - 2){
            for (int index = 1; index < chars.size() - 1; index++){
                int randomIndex = (int) Math.round(Math.random() * (chars.size() - 2));
                if (!randomIndexes.contains(randomIndex) && randomIndex != 0 && randomIndex != chars.size() - 1 ){
                    randomIndexes.add(randomIndex);
                }
            }
        }
        return randomIndexes;
    }

    public String getShuffledSentence() {
        return shuffledSentence;
    }
}
