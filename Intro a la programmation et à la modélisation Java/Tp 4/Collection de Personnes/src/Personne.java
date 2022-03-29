public class Personne {

    // Définition des attributs d'une personne
    private int id;
    private String nom;
    private String prenom;
    private char genre;
    private int anneeNaiss;
    private String groupe;
    private int categorie;

    /**
     * Constructeur de personne.
     *
     * @param lid : identifiant de la personne
     * @param leNom : nom de famille
     * @param lePrenom : prénom
     * @param leGenre : 'h', 'f', ...
     * @param lAnnee : année de naissance
     * @param leGroupe : groupe "Bosseur", "Surfeur", ...
     * @param laCategorie : catégorie
     */
    Personne(int lid, String leNom, String lePrenom, char leGenre, int lAnnee, String leGroupe,  int laCategorie) {
        this.id = lid;
        this.nom = leNom;
        this.prenom = lePrenom;
        this.genre = leGenre;
        this.anneeNaiss = lAnnee;
        this.groupe = leGroupe;
        this.categorie = laCategorie;
    }

    /* Les getters */
    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public int getAnneeNaiss() {
        return this.anneeNaiss;
    }
    public String getGroupe() {
        return this.groupe;
    }
    public int getCategorie() {
        return this.categorie;
    }
    
    public boolean estHomme() {
        return (this.genre=='h');
    }

    public boolean estFemme() {
        return (this.genre=='f');
    }
    /* Les setters */
    public void setGroupe(String leGroupe) {
        this.groupe = leGroupe;
    }
    public void setCategorie(int laCategorie) {
        this.categorie = laCategorie;
    }
    
    /* Affichage */
    public void afficher() {
	System.out.println(this.prenom + " " + this.nom + ", né.e en "
                + this.anneeNaiss + ", " + this.groupe + " de catégorie "
                + this.categorie);
    }
    public String toString(){
        return (this.prenom + " " + this.nom + ", né.e en "
                + this.anneeNaiss + ", " + this.groupe + " de catégorie "
                + this.categorie);
    }
    
    /* Méthodes */
    public boolean equals(Object p){
        Personne tmp = (Personne)p;
        return (this.getClass() == p.getClass() && this.getId() == tmp.getId());
    }
    
    public int matchScore(Personne p){
        int s = 0;
        if (this.getGroupe()==p.getGroupe()){
            s +=3;
        }
        switch(Math.abs(this.getCategorie() - p.getCategorie())){
            case 0: 
                s+=4;
                break;
            case 1: 
                s+=2;
                break;
            default: break;
        }
        switch(Math.abs(this.getAnneeNaiss() - p.getAnneeNaiss())){
            case 0:
            case 1:
            case 2:
                s+=4;
                break;
            case 3:
            case 4:
            case 5:
                s+=3;
                break;
            case 6:
            case 7:
            case 8:
                s+=2;
                break;
            case 9:
            case 10:
            case 11:
                s+=1;
                break;
            default: break;
            }   
        return s;  
    }
}
