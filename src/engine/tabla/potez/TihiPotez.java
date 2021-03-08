package engine.tabla.potez;

import engine.tabla.Tabla;
import engine.tabla.TablaBuilder;
import engine.tabla.TablaUtils;
import engine.tabla.figure.Figura;

public class TihiPotez extends Potez {
    public TihiPotez(Tabla pozicija, Figura pomerenaFigura, int koordinataDestinacije) {
        super(pozicija, pomerenaFigura, koordinataDestinacije);
    }

    @Override
    public boolean isNapadackiPotez() {
        return false;
    }

    @Override
    public String toString() {
        return pomerenaFigura.toString() + TablaUtils.kodiranaPolja[koordinataDestinacije];
    }
}
