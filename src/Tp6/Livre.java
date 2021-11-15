package Tp6;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;

public class Livre extends Media {
    private String auteur;
    private String titre;
    private List<Integer> notes;

    public Livre (String auteur, String titre){
        this.auteur = auteur;
        this.titre = titre;
        this.notes = new ArrayList<>();
    }
    public String toString(){
        return "["+this.titre+"."+this.auteur"]";
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

