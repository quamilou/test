import java.util.ArrayList;

public class Question {
    private String enoncer;
    private ArrayList<Reponse> reponses;

    public Question(String enonce){

        this.enoncer=enonce;
        this.reponses = new ArrayList<>();
    }
    public void ajouterReponse(Reponse rep){
        reponses.add(rep);
    }

    @Override
    public String toString() {
        String res = "";
        res+= enoncer + " : \n";
        //on boucle pour avoir chaque Question un numero puis son texte
        for (int i=0; i<reponses.size(); i++){
            res+= Integer.toString(i+1);  //le Interger.toString n'est pas obligatoire
            res+= " "+ reponses.get(i).toString();// pareil pour le .toString il n'est pas obligatoire
            res+= "\n";
        }
        return res;
    }
}
