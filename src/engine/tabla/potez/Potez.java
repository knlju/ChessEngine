package engine.tabla.potez;

// polu potez tj. ply

import engine.tabla.Tabla;
import engine.tabla.TablaBuilder;
import engine.tabla.figure.*;

import java.util.Objects;

import static engine.tabla.TablaUtils.kodiranaPolja;

public abstract class Potez {

    protected Tabla pozicija;
    protected Figura pomerenaFigura;
    protected int koordinataDestinacije;

    public Potez(Tabla pozicija, Figura pomerenaFigura, int koordinataDestinacije) {
        this.pozicija = pozicija;
        this.pomerenaFigura = pomerenaFigura;
        this.koordinataDestinacije = koordinataDestinacije;
    }

    @Override
    public String toString() {
        String outputFigure = pomerenaFigura.getTip().isPion() ? "" : pomerenaFigura.toString();
        return outputFigure + kodiranaPolja[koordinataDestinacije];
    }

    public Tabla getPozicija() {
        return pozicija;
    }

    public boolean isNapadackiPotez() {
        return false;
    }

    public boolean isRokada() {
        return false;
    }

    public Figura getNapadnutuFiguru() {
        return null;
    }

    public int getDestinaciju() {
        return koordinataDestinacije;
    }

    public Figura getPomerenuFiguru() {
        return pomerenaFigura;
    }

    public Tabla izvrsi() {
        TablaBuilder tb = new TablaBuilder();
        tb.setBrojPoteza(pozicija.getBrojPoteza()+1);

        for (Figura figura :
                pozicija.getTrenutniIgrac().getFigure()) {
            if (!figura.equals(pomerenaFigura)) {
                tb.setFiguru(figura);
            }
        }
        for (Figura figura :
                pozicija.getTrenutniIgrac().getProtivnik().getFigure()) {
            tb.setFiguru(figura);
        }
        if (pozicija.getTrenutniIgrac().isIzvrsioRokadu()) tb.setIzvrsioRokadu(pozicija.getTrenutniIgrac().getBoja());
        if (pozicija.getTrenutniIgrac().getProtivnik().isIzvrsioRokadu())
            tb.setIzvrsioRokadu(pozicija.getTrenutniIgrac().getProtivnik().getBoja());
        if (pomerenaFigura.getTip().isPion()) {
            Pion pomerenPion = (Pion) this.pomerenaFigura.napraviFiguru(this);
            pomerenPion.setPrviPotez(false);
            tb.setPrelazniPotez(this);
            tb.setFiguru(pomerenPion);
        }
        else if (pomerenaFigura.getTip().isKralj()) {
            Kralj pomerenKralj = (Kralj) this.pomerenaFigura.napraviFiguru(this);
            pomerenKralj.setPrviPotez(false);
            tb.setPrelazniPotez(this);
            tb.setFiguru(pomerenKralj);
        }
        else if (pomerenaFigura.getTip().isTop()) {
            Top pomerenTop = (Top) this.pomerenaFigura.napraviFiguru(this);
            pomerenTop.setPrviPotez(false);
            tb.setPrelazniPotez(this);
            tb.setFiguru(pomerenTop);
        } else {
            tb.setPrelazniPotez(this);
            tb.setFiguru(this.pomerenaFigura.napraviFiguru(this));
        }
        tb.setNaPotezuJe(pozicija.getTrenutniIgrac().getProtivnik().getBoja());

        return tb.napravi();
    }

    public static Potez izgradiPotez(Tabla tabla,
                                     int trenutnaKoordinata,
                                     int koordinataDestinacije) {
        for (Potez potez :
                tabla.getTrenutniIgrac().getLegalniPotezi()) {
            if (potez.getTrenutnuKoordinatu() == trenutnaKoordinata &&
                    potez.getDestinaciju() == koordinataDestinacije) {
                return potez;
            }
        }
        return NullPotez.getInstance();
    }

    private int getTrenutnuKoordinatu() {
        return this.pomerenaFigura.getKoordinata();
    }

    public boolean isNullPotez() {
        return false;
    }
}
