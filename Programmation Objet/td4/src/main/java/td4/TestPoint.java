package td4;

import java.util.Arrays;
import td4.Point;

public class TestPoint {
    public static void main(String[] args) {
        // Créer un tableau de 100 points avec des coordonnées aléatoires
        Point[] points = new Point[100];
        for (int i = 0; i < points.length; i++) {
            int x = (int) (Math.random() * 100);
            int y = (int) (Math.random() * 100);
            points[i] = new Point(x, y);
        }

        // Trier le tableau
        Arrays.sort(points);

        // Afficher le tableau après le tri
        System.out.println("Tableau après le tri :");
        for (Point p : points) {
            System.out.println(p);
        }
    }
}
