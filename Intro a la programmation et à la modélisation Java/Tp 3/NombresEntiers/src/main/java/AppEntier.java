public class AppEntier {

    public static void main(String[] args) {
        System.out.println(listeDiviseur(12));
        System.out.println(nbDiviseurs(3876590));
        System.out.println(estPremier(29));
        System.out.println(decompositionFacteursPremiers(14703));
        System.out.println(nbDiviseursV2(3876590));
    }
    
    public static void afficheurDiviseur(int n){
        for (int i = 1; i<=n ;i++){
            if (n%i == 0){
                System.out.println(i);
            }
        }
    }
    public static String listeDiviseur(int n){
        String k = "";
        for (int i = 1; i<=n ; i++){
            if (n%i == 0){
                k+=i+" "; 
            }
        }return k;
    }
    
    public static int nbDiviseurs(int n){
        int k=0;
        for (int i = 1; i<=n; i++){
            if (n%i == 0){
                k+=1;
            }
        }
        return k;
    }
    
    public static boolean estPremier(int n){
        if (nbDiviseurs(n)==2){
            return true;
        }else{
            return false;
        }
    }

    public static String decompositionFacteursPremiers(int n){
        String res = "";
        for (int i=2;i<Math.sqrt(n);i++){
            if (estPremier(i)){
                int exp = 0;
                while (n%i==0){
                    n = n/i;
                    exp +=1;
                }
                if (exp!=0){
                    res+=i+"^"+exp+"x";
                }
            }
        }
        res+=n+"^"+1;
        return res;
    }

    public static int nbDiviseursV2(int n){
        int res = 1;
        for (int i=2;i<Math.sqrt(n);i++){
            if (estPremier(i)) {
                int exp = 0;
                while (n % i == 0) {
                    n = n / i;
                    exp += 1;
                }
                if (exp != 0) {
                    res *= exp + 1;
                }
            }
        }
        res*=2;
        return res;
    }
}
