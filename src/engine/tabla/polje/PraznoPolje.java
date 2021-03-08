package engine.tabla.polje;

import engine.tabla.figure.Figura;

public class PraznoPolje extends ValidnoPolje {

    public PraznoPolje(int koordinata) {
        super(koordinata);
    }

    @Override
    public Figura getFigura() {
        return null;
    }

    @Override
    public boolean isZauzeto() {
        return false;
    }

    @Override
    public String toString() {
        return " - ";
    }
}
