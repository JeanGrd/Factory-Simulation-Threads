public class Ouvrier extends Thread {
    private Usine usine;
    private int[] composantsNecessaires;
    private Palette paletteEnCours;

    public Ouvrier(Usine usine, int[] composantsNecessaires) {
        this.usine = usine;
        this.composantsNecessaires = composantsNecessaires;
        this.paletteEnCours = new Palette(10);
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            for (int i = 0; i < composantsNecessaires.length; i++) {
                usine.getBac(i).retirer(composantsNecessaires[i]);
            }
            System.out.println("Ouvrier a construit un produit");

            paletteEnCours.deposerProduit(1);
            if (paletteEnCours.estPleine()) {
                usine.deposerPalette(paletteEnCours);
                System.out.println("Ouvrier a déposé une palette pleine");
                paletteEnCours = new Palette(10);
            }
        }
    }
}
