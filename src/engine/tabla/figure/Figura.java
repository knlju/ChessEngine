package engine.tabla.figure;

import engine.tabla.Tabla;
import engine.tabla.potez.Potez;

import java.util.Collection;

public abstract class Figura {

    protected int koordinata;
    protected Boja boja;
    protected TipFigure tip;

    public int getKoordinata() {
        return koordinata;
    }

    public Boja getBoja() {
        return boja;
    }

    public TipFigure getTip() {
        return tip;
    }

    public Figura(int koordinata, Boja boja) {
        this.koordinata = koordinata;
        this.boja = boja;
    }

    public abstract Collection<Potez> izracunajLegalnePoteze(Tabla tabla);

    public abstract Figura napraviFiguru(Potez potez);

    public int getVrednost() {
        return getTip().getVrednost();
    }
}
