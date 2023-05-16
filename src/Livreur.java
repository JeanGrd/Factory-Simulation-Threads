public class Livreur extends Thread {
    private Usine usine;
    private int typeComposant;
    private int chargement;
    private String etat;
    private boolean finDeJournee = false;

    public Livreur(Usine usine, int typeComposant, int chargement) {
        this.usine = usine;
        this.typeComposant = typeComposant;
        this.chargement = chargement;
        this.etat = "N'a pas commencé à travailler";
    }

    public void setFinDeJournee(boolean valeur) {
        this.finDeJournee = valeur;
    }

    public boolean isFinDeJournee() {
        return this.finDeJournee;
    }

    @Override
    public void run() {
        while (!finDeJournee) {
            this.etat = "Livreur " + this.getId() + " de composant " + typeComposant + " tente de livrer le chargement de " + chargement + " quantité";
            usine.getBac(typeComposant).deposer(chargement);

            Palette palette = usine.recupererPalette();

            if (palette != null) {
                this.etat = "Livreur " + this.getId() + " de composant " + typeComposant + " a pris une palette pleine";
            }
        }
        System.out.println("Bonne soirée !");
    }

    public String getEtat() {
        return this.etat;
    }
}
