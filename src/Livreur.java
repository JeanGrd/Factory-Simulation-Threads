public class Livreur extends Thread {
    private Usine usine;
    private int typeComposant;
    private int chargement;

    public Livreur(Usine usine, int typeComposant, int chargement) {
        this.usine = usine;
        this.typeComposant = typeComposant;
        this.chargement = chargement;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            usine.getBac(typeComposant).deposer(chargement);
            System.out.println("Livreur de composant " + typeComposant + " a livré " + chargement);

            Palette palette = usine.recupererPalette();
            if (palette != null) {
                System.out.println("Livreur de composant " + typeComposant + " a pris une palette pleine");
            }
        }
    }
}
