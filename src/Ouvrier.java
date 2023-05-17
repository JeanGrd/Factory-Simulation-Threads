public class Ouvrier extends Thread {
    private Usine usine;
    private int[] composantsNecessaires;
    private Palette paletteEnCours;
    private String etat;
    private boolean finDeJournee;

    public Ouvrier(Usine usine, int[] composantsNecessaires) {
        this.usine = usine;
        this.composantsNecessaires = composantsNecessaires;
        this.paletteEnCours = new Palette(10);
        this.etat = "";
    }

    @Override
    public void run() {
        while (!finDeJournee) {
            for (int i = 0; i < composantsNecessaires.length; i++) {
                this.etat = "Ouvrier " + this.getId() + " tente de retirer un composant";
                usine.getBac(i).retirer(composantsNecessaires[i]);
            }
            this.etat = "Ouvrier " + this.getId() + " a construit un produit";

            paletteEnCours.deposerProduit(1);
            if (paletteEnCours.estPleine()) {
                usine.deposerPalette(paletteEnCours);
                this.etat = "Ouvrier " + this.getId() + " a déposé une palette pleine";
                paletteEnCours = new Palette(10);
            }
        }
        System.out.println("Bonne soirée !");
    }

    public void setFinDeJournee(boolean valeur) {
        this.finDeJournee = valeur;
    }

    public String getEtat() {
        return this.etat;
    }

    public boolean isFinDeJournee() {
        return this.finDeJournee;
    }
}