package engine.tabla.polje;

public abstract class Polje {
    private int koordinata;

    public Polje(int koordinata) {
        this.koordinata = koordinata;
    }

    public int getKoordinata() {
        return koordinata;
    }

    public abstract boolean isValidnoPolje();
}
