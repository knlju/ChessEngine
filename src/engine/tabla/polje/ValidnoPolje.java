package engine.tabla.polje;

import engine.tabla.figure.Figura;

public abstract class ValidnoPolje extends Polje {

    public abstract Figura getFigura();
    public abstract boolean isZauzeto();

    public ValidnoPolje(int koordinata) {
        super(koordinata);
    }

    public static Polje napraviPolje(int i, Figura figura) {
        return figura == null ? new PraznoPolje(i) : new ZauzetoPolje(i,figura);
    }

    @Override
    public boolean isValidnoPolje() {
        return true;
    }
}
