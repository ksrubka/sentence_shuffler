/**
 * Created by Beata Iłowiecka on 14.04.16.
 */
public class SentenceShufflerTestApp {

    public static void main(String[] args) {
        SentenceShuffler zdanie1 = new SentenceShuffler("Oczywiście, że uwielbiam programować, bo niby po co ja sobie tutaj żyły wypruwam, bo lubię?!");

        System.out.println(zdanie1.getShuffledSentence());
    }
}
