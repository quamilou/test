public class Reponse {
    //att
    private String enonceReponse;
    private boolean rep;
    //con
    public Reponse(String enonceReponse,boolean b){
        this.enonceReponse = enonceReponse;
        this.rep = b;

    }
    //met
    public boolean estCorrect(){
        return rep;
    }
    @Override
    public String toString() {
        return enonceReponse;
    }
}
