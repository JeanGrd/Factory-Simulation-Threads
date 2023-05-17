import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Usine usine = new Usine(new int[]{20, 20, 20});

        Livreur livreur1 = new Livreur(usine, 0, 5);
        Livreur livreur2 = new Livreur(usine, 1, 5);
        Livreur livreur3 = new Livreur(usine, 2, 5);

        Ouvrier ouvrier1 = new Ouvrier(usine, new int[]{2, 1, 1});
        Ouvrier ouvrier2 = new Ouvrier(usine, new int[]{1, 2, 1});

        List<Thread> threads = new ArrayList<>();
        threads.add(livreur1);
        threads.add(livreur2);
        threads.add(livreur3);
        threads.add(ouvrier1);
        threads.add(ouvrier2);

        ContreMaitre contreMaitre = new ContreMaitre(threads);

        for (Thread thread : threads) {
            thread.start();
        }
        contreMaitre.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        contreMaitre.interrupt();

        try {
            contreMaitre.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}