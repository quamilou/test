import java.util.ArrayList;

public class Question {
    private String enoncer;
    private ArrayList<Reponse> reponses;

    public Question(String enonce){

        this.enoncer=enonce;
        this.reponses = new ArrayList<>();
    }
}
