package engine.tabla.potez;

import engine.tabla.Tabla;
import engine.tabla.TablaBuilder;
import engine.tabla.figure.Figura;
import engine.tabla.figure.Kralj;
import engine.tabla.figure.Top;

public class VelikaRokada extends Rokada {
    public VelikaRokada(Tabla pozicija, Figura pomerenaFigura, int koordinataDestinacije, Top top, int topPocetnaKoordinata, int topZavrsnaKoordinata) {
        super(pozicija, pomerenaFigura, koordinataDestinacije, top, topPocetnaKoordinata, topZavrsnaKoordinata);
    }

    @Override
    public boolean isNapadackiPotez() {
        return false;
    }

    @Override
    public String toString() {
        return "O-O-O";
    }
    @Override
    public Tabla izvrsi(){
        TablaBuilder tb = new TablaBuilder();
        tb.setBrojPoteza(pozicija.getBrojPoteza()+1);
        for (Figura figura :
                pozicija.getTrenutniIgrac().getFigure()) {
            if (!figura.equals(pomerenaFigura) && !figura.equals(top)){
                tb.setFiguru(figura);
            }
        }
        for (Figura figura :
                pozicija.getTrenutniIgrac().getProtivnik().getFigure()) {
            tb.setFiguru(figura);
        }
        Top pomerenTop = top.napraviFiguru(this);
        pomerenTop.setPrviPotez(false);
        Kralj pomerenKralj = ((Kralj) this.pomerenaFigura).napraviFiguru(this);
        pomerenKralj.setPrviPotez(false);
        tb.setFiguru(pomerenTop);
        tb.setFiguru(pomerenKralj);
        tb.setPrelazniPotez(this);
        tb.setNaPotezuJe(pozicija.getTrenutniIgrac().getProtivnik().getBoja());

        tb.setIzvrsioRokadu(pozicija.getTrenutniIgrac().getBoja());
        if (pozicija.getTrenutniIgrac().getProtivnik().isIzvrsioRokadu()) tb.setIzvrsioRokadu(pozicija.getTrenutniIgrac().getProtivnik().getBoja());

        return tb.napravi();
    }

    @Override
    public boolean isRokada() {
        return true;
    }
}
