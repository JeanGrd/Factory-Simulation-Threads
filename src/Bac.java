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
                Thread currentThread = Thread.currentThread();
                if(currentThread instanceof Livreur){
                    if(((Livreur)currentThread).isFinDeJournee()) {
                        return;
                    } else {
                        System.out.println(((Livreur)currentThread).getEtat());
                    }
                } else if(currentThread instanceof Ouvrier){
                    if(((Ouvrier)currentThread).isFinDeJournee()) {
                        return;
                    } else {
                        System.out.println(((Ouvrier)currentThread).getEtat());
                    }
                }
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
                Thread currentThread = Thread.currentThread();
                if(currentThread instanceof Livreur){
                    if(((Livreur)currentThread).isFinDeJournee()) {
                        return 0;
                    } else {
                        System.out.println(((Livreur)currentThread).getEtat());
                    }
                } else if(currentThread instanceof Ouvrier){
                    if(((Ouvrier)currentThread).isFinDeJournee()) {
                        return 0;
                    } else {
                        System.out.println(((Ouvrier)currentThread).getEtat());
                    }
                }
            }
        }
        contenu -= quantite;
        notifyAll();
        return quantite;
    }
}
