package Tp5;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question {
    private List<Reponse> reponses;
    private Integer selectReponse;
    private String enoncer;

    public Question(String enoncer){
        this.enoncer=enoncer;
        this.reponses = new ArrayList<>();
    }
    public Question(String enoncer, List<Reponse> questions){
        this.enoncer = enoncer;
        this.reponses = questions;
    }
    public void ajouterReponse(Reponse a){ reponses.add(a);}
    public void selectReponse(int i){
        selectReponse = i;
        System.out.println("your select is : "+ i);
    }

    public boolean estCorrect(){
        if(selectReponse==null){
            return false;
        }
        Reponse laReponse = reponses.get(selectReponse);//get error ?
        return laReponse.estCorrect();
    }

    public int nbBonneReponse(){
        int nb = 0;
        for(Reponse a: reponses){
            if (a.estCorrect()){
                nb++;
            }
        }
        return nb;
    }
    public void poseUneQuestion(Scanner sc){
        System.out.println(this);
        selectReponse(Utils.enterPositiveInt(reponses.size()));
    }

    @Override
    public String toString() {
        String res = "";
        res+= enoncer + " : \n";
        //on boucle pour avoir chaque Question un numero puis son texte
        for (int i=0; i<reponses.size(); i++){
            res+= Integer.toString(i);  //le Interger.toString n'est pas obligatoire
            res+= "- "+ reponses.get(i).toString();// pareil pour le .toString il n'est pas obligatoire
            res+= "\n";
        }
        return res;
    }
}
