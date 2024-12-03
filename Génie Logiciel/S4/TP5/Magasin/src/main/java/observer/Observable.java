package observer;

/**
 *
 * @author loant
 */
public abstract class Observable {
    
     protected void setChange(){
         
     }
     
     protected void notifyObservers(Object arg){
         
     }
     
     public void addObserver(Observer o){
         System.out.println("ajout d'un observeur");
     }
}
