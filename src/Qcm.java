import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Qcm {
    private List<Question> lesQuestions;

    public Qcm(){this.lesQuestions = new ArrayList<>();}

    public void ajouterQuestion(Question question){
        lesQuestions.add(question);
    }
    public int executeQcm(){
        Scanner sc= new Scanner(System.in);
        int score = 0;
        for(Question question: lesQuestions){
            question.poseUneQuestion(sc);
            if(question.estCorrect()){
                score++;
            }
        }
        System.out.println("Vous avez : " + score + " sur "+lesQuestions.size());
        return score;
    }

    @Override
    public String toString() {
        String res = "";
        for(Question question : lesQuestions){
            res += question.toString();
        }
        return res;
    }

    public static void main(String[] args){
        Qcm leQCM = new Qcm();

        Question q1 = new Question("A propos des nombres premiers");

        Reponse nb0 = new Reponse("Le nombre 1 est premier", false);
        q1.ajouterReponse(nb0);
        Reponse nb1 = new Reponse("Il en existe une infinité", true);
        q1.ajouterReponse(nb1);
        Reponse nb2 = new Reponse("Un nombre pair peut être premier", true);
        q1.ajouterReponse(nb2);
        Reponse nb3 = new Reponse("Le produit de deux nombres premier peut être premier", false);
        q1.ajouterReponse(nb3);

        Question q2 = new Question("Quel temps fait-il aujourd’hui ?");

        Reponse t0 = new Reponse("Nuageux", true);
        q2.ajouterReponse(t0);
        Reponse t1 = new Reponse("Pluvieux", false);
        q2.ajouterReponse(t1);
        Reponse t2 = new Reponse("Orageux", false);
        q2.ajouterReponse(t2);


        leQCM.ajouterQuestion(q1);
        leQCM.ajouterQuestion(q2);


        leQCM.executeQcm();
    }
}