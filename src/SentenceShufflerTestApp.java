import java.util.ArrayList;
import java.util.List;

/**
 * Created by Beata Iłowiecka on 14.04.16.
 */
public class SentenceShufflerTestApp {

    public static void main(String[] args) {

        SentenceShuffler zdanie1 = new SentenceShuffler("When You feel the need to write a comment, " +
                "first try to refactor the code so that any comment becomes superfluous");

        SentenceShuffler zdanie2 = new SentenceShuffler("There is no reasonable excuse " +
                "for doing anything less than Your best");

        SentenceShuffler zdanie3 = new SentenceShuffler("Tworzenie struktury kodu pod kątem łatwości " +
                "testowania prowadzi do otrzymania lepszego projektu kodu");

        SentenceShuffler zdanie4 = new SentenceShuffler("Nie zmuszajcie mnie więcej do pracy nad tym " +
                "kodem\n Został napisany przez socjopatę idiotę lub geniusza zła.\n Mogłem to byc ja");

        System.out.println(zdanie1.getShuffledSentence()+ "\n");
        System.out.println(zdanie2.getShuffledSentence() + "\n");
        System.out.println(zdanie3.getShuffledSentence() + "\n");
        System.out.println(zdanie4.getShuffledSentence());
    }
}
