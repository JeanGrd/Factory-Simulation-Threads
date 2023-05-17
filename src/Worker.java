public class Worker implements Runnable {

    private String etat = "N'a pas commencé à travailler";
    private String name;

    private boolean finDeJournee = false;
    private final Thread thread;

    public Worker(String name) {
        this.name = name;
        this.thread = new Thread(this);
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getEtat() {
        return etat;
    }

    public void setFinDeJournee(boolean finDeJournee) {
        this.finDeJournee = finDeJournee;
    }

    public boolean isFinDeJournee() {
        return finDeJournee;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("Travaille...");
    }

    public void start() {
        thread.start();
    }

    public void interrupt(){
        System.out.println(this.getEtat());
    }

    public void finDeJournee() {
        thread.interrupt();
    }
}
