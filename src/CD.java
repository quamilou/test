import javax.print.attribute.standard.Media;

public class CD extends Media {
    private String format;
    public CD (String auteur, String titre, String format){
        super(auteur, titre);
        this.format = format;
    }
    public String toString(){
        String res = super.toString();
        res += "["+this.format+"]";
        return res;
    }
    public void vote (int note){
        if(note<0 || note>5){
            System.out.println("La note entre 0 et 5 ");
            return;
            throw new RuntimeException("La note entrer n'est pas entre 0 et 5");
        }
        notes.add(note);
    }
    public int moyenneNotes(){
        if(notes.size()==0){
            return 0;
        }
        int res=0;
        for(int note : notes){
            res+=note;
        }
        return res/notes.size();
    }
}
