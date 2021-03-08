package engine.tabla.polje;

import engine.tabla.figure.Figura;

public class ZauzetoPolje extends ValidnoPolje {

    private Figura figura;

    public ZauzetoPolje(int koordinata,Figura figura) {
        super(koordinata);
        this.figura = figura;
    }

    @Override
    public Figura getFigura() {
        return this.figura;
    }

    @Override
    public boolean isZauzeto() {
        return true;
    }

    @Override
    public String toString() {
        return " "+figura.toString()+" ";
    }
}
