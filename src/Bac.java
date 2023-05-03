public class Bac {
    private int capacite;
    private int contenu;

    public Bac(int capacite) {
        this.capacite = capacite;
        this.contenu = 0;
    }

    public synchronized void deposer(int quantite) {
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

    public synchronized int retirer(int quantite) {
        while (contenu < quantite) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread interrompu");
            }
        }
        contenu -= quantite;
        notifyAll();
        return quantite;
    }
}
