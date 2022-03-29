import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Frédéric Bertrand
 */
public class Cuisine {
    public static void main(String[] args) {

        // -------------------------------------------------------------------
        // Classe Ingredient
        // -------------------------------------------------------------------

        // Test-Usage du constructeur d'Ingredient
        Ingredient carotte = new Ingredient("CAROTTE", 4.8, 0.98, 0.20, 26);

        // Test-Usage des getters d'Ingredient
        if (!carotte.getNom().equals("CAROTTE")) {
            throw new Error("Pb avec carotte.getNom()");
        }
        if (carotte.getGlucide() != 4.8) {
            throw new Error("Pb avec carotte.getGlucide()");
        }
        if (carotte.getProteine() != .98) {
            throw new Error("Pb avec carotte.getProteine()");
        }
        if (carotte.getLipide() != .2) {
            throw new Error("Pb avec carotte.getLipide()");
        }
        if (carotte.getCalories() != 26) {
            throw new Error("Pb avec carotte.getCalories()");
        }

        // Test-Usage du toString
        if (!carotte.toString().equals("Ingredient{nom=CAROTTE, glucide=4.8, proteine=0.98, lipide=0.2, calories=26}")) {
            throw new Error("Pb avec toString");
        }

        // Test-Usage de equals
        Ingredient inconnu = carotte;
        String autre = "CAROTTE";
        Ingredient patate = new Ingredient("POMMEDETERRE", 18.0, 1.5, 0.1, 85);
        Ingredient oui = new Ingredient("CAROTTE",1, 2, 3, 4);
        if (!carotte.equals(inconnu)) {
            throw new Error("Pb avec carotte.equals(inconnu)");
        }
        if (carotte.equals(autre)) {
            throw new Error("Pb avec carotte.equals(autre)");
        }
        if (carotte.equals(patate)) {
            throw new Error("Pb avec carotte.equals(patate)");
        }
        if (!carotte.equals(oui)) {
            throw new Error("Pb avec carotte.equals(oui)");
        }
        if (carotte == oui) {
            throw new Error("Pb avec carotte == oui");
        }
        if (carotte != inconnu) {
            throw new Error("Pb avec carotte != inconnu");
        }

        // -------------------------------------------------------------------
        // Classe Plat
        // -------------------------------------------------------------------

        // Test-Usage du constructeur vide, de getNom et du toString

        Plat p = new Plat("PUREE");
        System.out.println(p.toString());
        if (! p.getNom().equals("PUREE")) {
            throw new Error("Pb avec p.getNom(\"PUREE\")");
        }

        if (! p.toString().equals("Plat{nom=PUREE, glucide=0.0, proteine=0.0, lipide=0.0, calories=0}\n")) {
            throw new Error("Pb avec p.toString()");
        }

        // Test-Usage de ajoute et du toString
        p.ajoute(carotte, 500);
        p.ajoute(patate, 500);
        if (p.getIngredients().get(carotte) != 500) {
            throw new Error("Pb avec p.ajoute(carotte, 500)");
        }
        if (p.getIngredients().get(patate) != 500) {
            throw new Error("Pb avec p.ajoute(patate, 500)");
        }

        // Test-Usage de getteurs
        if (p.getGlucide() != 114.) {
            throw new Error("Pb avec p.getGlucide()");
        }
        if (p.getLipide() != 1.5) {
            throw new Error("Pb avec p.getLipide()");
        }
        if (p.getProteine() != 12.4) {
            throw new Error("Pb avec p.getProteine()");
        }
        if (p.getCalories() != 555) {
            throw new Error("Pb avec p.getCalories()");
        }

        // Test-Usage du constructeur avec ingrédients
        Plat pe = new Plat("PUREEPICEE",p.getIngredients());
        Ingredient piment = new Ingredient("POIVRON", 4.6, 0.9 , 0.2, 20);
        pe.ajoute(piment, 20);
        if (pe.getIngredients().get(piment) != 20) {
            throw new Error("Pb avec pe.ajoute(piment, 20)");
        }

        // Test-Usage de maxCalories
        Ingredient pommeDeTerre = p.maxCalories();
        if (! pommeDeTerre.getNom().equals("POMMEDETERRE")) {
            throw new Error("Pb avec p.maxCalories()");
        }
        pommeDeTerre = pe.maxCalories();
        if (! pommeDeTerre.getNom().equals("POMMEDETERRE")) {
            throw new Error("Pb avec pe.maxCalories()");
        }

        Plat vide = new Plat("VIDE");
        if (vide.maxCalories() != null) {
            throw new Error("Pb avec vide.maxCalories()");
        }

        // ATTENTION DEUX MAX ! ET L'ENONCE NE PRECISE PAS LEQUEL PRENDRE !
        Plat bis = new Plat("BIS",pe.getIngredients());
        bis.ajoute(new Ingredient("BIS", 1, 2, 3, 85), 50);
        if (! bis.maxCalories().getNom().equals("BIS")) {
            throw new Error("Pb avec bis.maxCalories()");
        }
        // Test-Usage de richeProteine
        if (! pe.richeProteine(6.).isEmpty()) {
            throw new Error("Pb avec pe.richeProteine(6.)");
        }
        if (pe.richeProteine(0.).size() != 3) {
            throw new Error("Pb avec pe.richeProteine(0.)");
        }
        if (pe.richeProteine(1.).size() != 1) {
            throw new Error("Pb avec pe.richeProteine(1.)");
        }

        // -------------------------------------------------------------------
        // Classe Panier
        // -------------------------------------------------------------------
        Panier paniervide = new Panier();
        if (! paniervide.getContenu().isEmpty() || paniervide.getPoids() != 0.) {
            throw new Error("Pb avec paniervide");
        }

        Panier petitpanier = new Panier(p.getIngredients());
        if (petitpanier.getContenu().size() != 2 || petitpanier.getPoids() != 1000.) {
            throw new Error("Pb avec paniervide");
        }

        Panier grospanier = new Panier(petitpanier.getContenu());
        if (grospanier.getContenu().size() != 2 || grospanier.getPoids() != 1000.) {
            throw new Error("Pb avec paniervide");
        }

        // INCITER LES ETUDIANTS A REFLECHIR SUR LES 4 TESTS CI-DESSOUS
        if (! grospanier.estPresent(carotte)) {
            throw new Error("Pb avec grospanier.estPresent(carotte)");
        }
        if (grospanier.estPresent(oui)) {
            throw new Error("Pb avec grospanier.estPresent(oui)");
        }
        if (! grospanier.estPresentBis(carotte)) {
            throw new Error("Pb avec grospanier.estPresentBis(carotte)");
        }
        if (grospanier.estPresentBis(oui)) {
            throw new Error("Pb avec grospanier.estPresentBis(oui)");
        }

        grospanier.ajoute(carotte, 100);
        if (grospanier.getContenu().get(carotte) != 600) {
            throw new Error("Pb avec ajoute carotte dans grospanier");
        }
        petitpanier.retire(carotte, 100);
        if (petitpanier.getContenu().get(carotte) != 400) {
            throw new Error("Pb avec retire carotte dans petitpanier");
        }

        grospanier.ajoute(piment, 1000);
        if (grospanier.getContenu().get(piment) != 1000) {
            throw new Error("Pb avec ajoute piment dans grospanier");
        }
        petitpanier.retire(carotte, 1000);
        if (petitpanier.getContenu().get(carotte) != null) {
            throw new Error("Pb avec retire carotte dans petitpanier");
        }

        petitpanier.retire(carotte, 1000);
        if (petitpanier.getContenu().get(carotte) != null) {
            throw new Error("Pb avec retire carotte dans petitpanier");
        }

        Panier grandsac = petitpanier.fusionne(grospanier);
        if (grandsac.getContenu().size() != 3 || grandsac.getPoids() != 2600.) {
            throw new Error("Pb avec grandsac");
        }

        if (petitpanier.estCuisinable(p)) {
            throw new Error("Pb avec petitpanier.estCuisinable(p)");
        }
        if (! grandsac.estCuisinable(p)) {
            throw new Error("Pb avec grandsac.estCuisinable(p)");
        }
        if (paniervide.estCuisinable(p)) {
            throw new Error("Pb avec paniervide.estCuisinable(p)");
        }
        if (! petitpanier.estCuisinable(vide)) {
            throw new Error("Pb avec petitpanier.estCuisinable(vide)");
        }
        if (! paniervide.estCuisinable(vide)) {
            throw new Error("Pb avec paniervide.estCuisinable(vide)");
        }


        if (! petitpanier.cuisine(p).getContenu().isEmpty()) {
            throw new Error("Pb avec petitpanier.cuisine(p)");
        }
        if (grandsac.cuisine(p).getContenu().size() != 3 || grandsac.cuisine(p).getPoids() != 1600.) {
            throw new Error("Pb avec grandsac.cuisine(p)");
        }
        if (! paniervide.cuisine(p).getContenu().isEmpty()) {
            throw new Error("Pb avec paniervide.cuisine(p)");
        }
        if (petitpanier.cuisine(vide).getContenu().size() != 1 || petitpanier.cuisine(vide).getPoids() != 500.) {
            throw new Error("Pb avec petitpanier.cuisine(vide)");
        }
        if (! paniervide.cuisine(vide).getContenu().isEmpty()) {
            throw new Error("Pb avec paniervide.cuisine(vide)");
        }


        if (petitpanier.achete(pe).getContenu().size() != 2 || petitpanier.achete(pe).getPoids() != 520.) {
            throw new Error("Pb avec petitpanier.achete(pe)");
        }
        if (! grospanier.achete(p).getContenu().isEmpty()) {
            throw new Error("Pb avec grospanier.achete(p)");
        }
        if (paniervide.achete(p).getContenu().size() != 2 || paniervide.achete(p).getPoids() != 1000.) {
            throw new Error("Pb avec paniervide.achete(p)");
        }
        if (! grospanier.achete(vide).getContenu().isEmpty()) {
            throw new Error("Pb avec grospanier.achete(vide)");
        }

        System.out.println("Tests OK...");
    }
}
