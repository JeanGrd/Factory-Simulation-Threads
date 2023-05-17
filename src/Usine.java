import java.util.LinkedList;
import java.util.Queue;

public class Usine {
    private Bac[] bacs;
    private Queue<Palette> palettes;

    public Usine(int[] capacitesBacs) {
        bacs = new Bac[capacitesBacs.length];
        for (int i = 0; i < capacitesBacs.length; i++) {
            bacs[i] = new Bac(capacitesBacs[i]);
        }
        palettes = new LinkedList<>();
    }

    public Bac getBac(int index) {
        return bacs[index];
    }

    public synchronized void deposerPalette(Palette palette) {
        palettes.add(palette);
        notifyAll();
    }

    public synchronized Palette recupererPalette() {
        if (palettes.isEmpty()) {
            return null;
        }
        return palettes.poll();
    }
}