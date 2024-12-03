public class TestTaille {
    public static void main(String[] args) {
        // Utilisation volontaire du type Noeud...
        Noeud fic1 = new Fichier("fic1",100);

        // test de la taille d'un fichier
        if (fic1.donneTaille() != 100) {
            throw new Error("Probleme avec TestTaille : taille incorrecte pour le fichier fic1");
        }

        // test de la taille d'un repertoire
        Noeud fic2 = new Fichier("fic2",200);
        Noeud fic3 = new Fichier("fic3",50);
        Noeud rep3 = new Repertoire("rep3");
        Noeud rep2 = new Repertoire("rep2");
        rep2.ajouteElt(fic2);
        rep2.ajouteElt(fic3);
        rep2.ajouteElt(rep3);
        Noeud rep1 = new Repertoire("rep1");
        rep1.ajouteElt(fic1);
        rep1.ajouteElt(rep2);
        if (rep1.donneTaille() != 350) {
            throw new Error("Probleme avec TestTaille : taille incorrecte pour le repertoire rep1");
        }

        System.out.println("TestTaille OK...");
    }
}
