package engine.tabla.potez;

import engine.tabla.Tabla;
import engine.tabla.TablaBuilder;
import engine.tabla.TablaUtils;
import engine.tabla.figure.Figura;

public class NapadackiPotez extends Potez {

    protected Figura napadnutaFigura;

    public NapadackiPotez(Tabla pozicija,
                          Figura pomerenaFigura,
                          int koordinataDestinacije,
                          Figura napadnutaFigura) {
        super(pozicija, pomerenaFigura, koordinataDestinacije);
        this.napadnutaFigura = napadnutaFigura;
    }

    @Override
    public boolean isNapadackiPotez() {
        return true;
    }

    @Override
    public engine.tabla.figure.Figura getNapadnutuFiguru() {
        return super.getNapadnutuFiguru();
    }

    public Tabla izvrsi(){
        TablaBuilder tb = new TablaBuilder();
        tb.setBrojPoteza(pozicija.getBrojPoteza()+1);

        for (Figura figura :
                pozicija.getTrenutniIgrac().getFigure()) {
            if (!figura.equals(pomerenaFigura)){
                tb.setFiguru(figura);
            }
        }
        for (Figura figura :
                pozicija.getTrenutniIgrac().getProtivnik().getFigure()) {
            if (!figura.equals(napadnutaFigura)){
                tb.setFiguru(figura);
            }
        }
        tb.setPrelazniPotez(this);
        tb.setFiguru(this.pomerenaFigura.napraviFiguru(this));
        tb.setNaPotezuJe(pozicija.getTrenutniIgrac().getProtivnik().getBoja());
        if (pozicija.getTrenutniIgrac().isIzvrsioRokadu()) tb.setIzvrsioRokadu(pozicija.getTrenutniIgrac().getBoja());
        if (pozicija.getTrenutniIgrac().getProtivnik().isIzvrsioRokadu()) tb.setIzvrsioRokadu(pozicija.getTrenutniIgrac().getProtivnik().getBoja());

        return tb.napravi();
    }

    @Override
    public String toString() {
        return pomerenaFigura.toString() + "x" + TablaUtils.kodiranaPolja[koordinataDestinacije];
    }
}
