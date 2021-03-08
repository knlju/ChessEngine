package engine.tabla.polje;

public class NevalidnoPolje extends Polje {

    public NevalidnoPolje(int koordinata) {
        super(koordinata);
    }

    @Override
    public boolean isValidnoPolje() {
        return false;
    }
}
