import java.util.ArrayList;

public class Qcm {
    private ArrayList<Question> lesQuestions;

    public Qcm(){
        this.lesQuestions = new ArrayList<>();
    }
    public void ajouterQuestion(Question question){
        lesQuestions.add(question);
    }
    public static void main(String[] args){
        Question nbPremiers = new Question("A propos des nombres premiers");

        Reponse nb1 = new Reponse("Le nombre 1 est premier", false);
        nbPremiers.ajouterReponse(nb1);
        Reponse nb2 = new Reponse("Il en existe une infinité", true);
        nbPremiers.ajouterReponse(nb2);
        Reponse nb3 = new Reponse("Un nombre pair peut être premier", true);
        nbPremiers.ajouterReponse(nb3);
        Reponse nb4 = new Reponse("Le produit de deux nombres premier peut être premier", false);
        nbPremiers.ajouterReponse(nb4);

        Question temps = new Question("Quel temps fait-il aujourd’hui ?");

        Reponse t1 = new Reponse("Nuageux", true);
        temps.ajouterReponse(t1);
        Reponse t2 = new Reponse("Pluvieux", false);
        temps.ajouterReponse(t2);
        Reponse t3 = new Reponse("Orageux", false);
        temps.ajouterReponse(t3);

        Qcm leQCM = new Qcm();
        leQCM.ajouterQuestion(nbPremiers);
        leQCM.ajouterQuestion(temps);
    }
}