public class Palette {
    private int capacite;
    private int contenu;

    public Palette(int capacite) {
        this.capacite = capacite;
        this.contenu = 0;
    }

    public synchronized void deposerProduit(int quantite) {
        while (contenu + quantite > capacite) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread interrompu");
            }
        }
        contenu += quantite;
        notifyAll();
    }

    public boolean estPleine() {
        return contenu == capacite;
    }
}
