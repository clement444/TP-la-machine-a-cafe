public class Stock {
 String name;
    int quantity;
    int Max;
    int Min;

    public void remplir() {
        quantity = Max;
    }

    public boolean estSuffisant(int besoin) {
        return quantity >= besoin;
    }

    public void consommer(int quantite) {
        quantity -= quantite;
    }

    public void afficher() {
        System.out.println(name + " : " + quantity + "/" + Max);
    }
}