package Biblio.src;

/**
 *
 * @author loant
 */
public class EltMM {
    private String titre;
    private int duree;
    private boolean presentEnRayon;
    private String commentaires;

    public EltMM(String titre, int duree) {
        this.titre = titre;
        this.duree = duree;
        this.presentEnRayon = true;
        this.commentaires = "<pas de commentaires>";
    }
    
    public String donneTitre(){
        return this.titre;
    }
    
    public int donneDuree(){
        return this.duree;
    }
    
    public void ajouteCommentaires(String commentaires){
        this.commentaires = commentaires;            
    }
    
    public String donneCommentaires(){
        return this.commentaires;
    }
    
    public void changeEtatEmprunt(boolean etat){
        this.presentEnRayon = etat;
    }
    
    public boolean donneEtatEmprunt(){
        return this.presentEnRayon;
    }
    
    public boolean emprunter(){
        if (this.presentEnRayon = false){
            return false;
        }
        this.presentEnRayon = false;
        return true;
    }
    
    public boolean restituer(){
        if (this.presentEnRayon = true){
            return false;
        }
        this.presentEnRayon = true;
        return true;
    }
    
    public String donneType(){
        return "";
    }
    
    /**
     * Renvoie une description textuelle de l'objet
     *
     * @return un chaine de caracteres decrivant l'objet
     */
    public String toString()
    {
        String s = "\nCD :\n";
        s += "Titre : " + this.titre + "\n";
        s += "Duree : " + this.duree + "\n";
        s += "Etat : ";
        if (this.presentEnRayon)
        {
            s += "disponible\n";
        }
        else
        {
            s += "emprunte\n";
        }
        s += "Commentaires : " + this.commentaires + "\n";
        return s;
    }
}
