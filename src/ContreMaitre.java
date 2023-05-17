import java.util.List;

public class ContreMaitre extends Thread {
    private List<Thread> threads;

    public ContreMaitre(List<Thread> threads) {
        this.threads = threads;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                interrupt();
            }

            for (Thread thread : threads) {
                thread.interrupt();
            }
        }

        for (Thread thread : threads) {
            if(thread instanceof Livreur){
                ((Livreur) thread).setFinDeJournee(true);
            } else if (thread instanceof Ouvrier){
                ((Ouvrier) thread).setFinDeJournee(true);
            }
        }
        System.out.println("Fin de la journée, bonne soirée à tout le monde");
    }
}