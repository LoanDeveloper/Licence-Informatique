package td4;

/**
 *
 * @author loant
 */
public class Point implements Comparable<Point>{
    private int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public double distanceOrigine(){
        return Math.sqrt(this.x * this.x + this.y * y);
    }
    
    @Override
    public int compareTo(Point o) {
        double distanceThis = this.distanceOrigine();
        double distanceO = o.distanceOrigine();
        if (distanceO > distanceThis){
            return -1;
        }else if(distanceO == distanceThis){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
}
