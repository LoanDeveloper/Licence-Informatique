import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmondo01
 */
public class main {
    // Logger
    private static Logger LOGGER;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s %n");
        LOGGER = Logger.getLogger(Main.class.getName());
    }

    public static void main(String[] args) {
        // Creation des documents
        Livre ecoleSorcier = new Livre("Salle A", "Harry Potter a l'ecole des sorciers", "Rowling", 1997, true,
                genreLivres.AUTRE);
        Livre meurtreRoger = new Livre("Salle A", "Le Meurtre de Roger Ackroyd", "Christie", 1926, true,
                genreLivres.POLICIER);
        CD thriller = new CD("Salle C", "Thriller", "Jackson", 1982, true, TypeCD.AUTRE);
        CD eux = new CD("Salle C", "D'eux", "Dion", 1995, true, TypeCD.VARIETESFR);
        BluRay piegeCristal = new BluRay("Salle B", "Piege de cristal", "McTiernan", 2007, true, TypeBluRay.AUTRE, 126);

        CritereEmprunt critereAbonne = new CritereEmprunt(TypeTarif.ABONNE, 30, 5, 15);
        CritereEmprunt critereNormal = new CritereEmprunt(TypeTarif.TARIF_NORMAL, 1, 3, 7);
        CritereEmprunt critereReduit = new CritereEmprunt(TypeTarif.TARIF_REDUIT, 0.5, 3, 7);

        Client jean = new Client("Vier", "Jean", "15 rue Florac 17000 La Rochelle", critereAbonne);
        Client denis = new Client("LaMalice", "Denis", "54 avenue De Gaule 17000 La Rochelle", critereNormal);
        Client arnold = new Client("Hey", "Arnold", "5 rue rose 17000 La Rochelle", critereReduit);

        LOGGER.log(Level.INFO, "Nombre d''emprunt de CD : {0}", CD.getNbEmpruntCDTotal());
        LOGGER.log(Level.INFO, "Nombre d''emprunt de BluRay : {0}", BluRay.getNbEmpruntBlurayTotal());
        LOGGER.log(Level.INFO, "Nombre d''emprunt de Livre : {0}\n", Livre.getNbEmpruntLivreTotal());

        LOGGER.log(Level.INFO, "Nombre d''emprunt du livre Harry Potter : {0}", ecoleSorcier.getNbEmprunt());
        LOGGER.log(Level.INFO, "Nombre d''emprunt du livre Le Meurtre de Roger Ackroyd : {0}",
                meurtreRoger.getNbEmprunt());
        LOGGER.log(Level.INFO, "Nombre d''emprunt du CD Thrillerr : {0}", thriller.getNbEmprunt());
        LOGGER.log(Level.INFO, "Nombre d''emprunt du CD D''eux : {0}", eux.getNbEmprunt());
        LOGGER.log(Level.INFO, "Nombre d''emprunt du Bluray Piege de cristal : {0}\n", piegeCristal.getNbEmprunt());

        ecoleSorcier.emprunter(denis, "21/09/2021", "28/09/2021");
        ecoleSorcier.emprunter(jean, "29/09/2021", "13/10/2021");
        meurtreRoger.emprunter(arnold, "23/09/2021", "30/09/2021");

        LOGGER.log(Level.INFO, "Nombre d''emprunt de Livre : {0}", Livre.getNbEmpruntLivreTotal());

        LOGGER.log(Level.INFO, "Nombre d''emprunt du livre Harry Potter : {0}", ecoleSorcier.getNbEmprunt());
        LOGGER.log(Level.INFO, "Nombre d''emprunt du livre Le Meurtre de Roger Ackroyd : {0}",
                meurtreRoger.getNbEmprunt());
    }
}

