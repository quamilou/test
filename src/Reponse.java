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

    @Override
    public String toString() {
        return enonceReponse;
    }
}
