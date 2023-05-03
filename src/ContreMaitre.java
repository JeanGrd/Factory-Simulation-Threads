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
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("ContreMaitre a été interrompu");
                break;
            }

            for (Thread thread : threads) {
                thread.interrupt();
            }
        }

        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}
