package engine.tabla.potez;

import engine.tabla.Tabla;
import engine.tabla.TablaBuilder;
import engine.tabla.TablaUtils;
import engine.tabla.figure.Figura;
import engine.tabla.figure.Kraljica;
import engine.tabla.figure.Pion;

public class NapadackiPotezPiona extends NapadackiPotez {
    public NapadackiPotezPiona(Tabla pozicija, Figura pomerenaFigura, int koordinataDestinacije, Figura napadnutaFigura) {
        super(pozicija, pomerenaFigura, koordinataDestinacije, napadnutaFigura);
    }

    public Tabla izvrsi(){
        TablaBuilder tb = new TablaBuilder();
        tb.setBrojPoteza(pozicija.getBrojPoteza() + 1);

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

        if (pozicija.getTrenutniIgrac().isIzvrsioRokadu()) tb.setIzvrsioRokadu(pozicija.getTrenutniIgrac().getBoja());
        if (pozicija.getTrenutniIgrac().getProtivnik().isIzvrsioRokadu()) tb.setIzvrsioRokadu(pozicija.getTrenutniIgrac().getProtivnik().getBoja());

        if (pozicija.getTrenutniIgrac().getBoja().isBeli()){
            if (TablaUtils.promocijaBelog[koordinataDestinacije]){
                Kraljica figura = new Kraljica(koordinataDestinacije,pomerenaFigura.getBoja());
                tb.setPrelazniPotez(this);
                tb.setFiguru(figura);
                tb.setNaPotezuJe(pozicija.getTrenutniIgrac().getProtivnik().getBoja());

                return tb.napravi();
            }
        }
        else{
            if (TablaUtils.promocijaCrnog[koordinataDestinacije]){
                Kraljica figura = new Kraljica(koordinataDestinacije,pomerenaFigura.getBoja());
                tb.setPrelazniPotez(this);
                tb.setFiguru(figura);
                tb.setNaPotezuJe(pozicija.getTrenutniIgrac().getProtivnik().getBoja());

                return tb.napravi();
            }
        }
        Pion pomeren = (Pion) this.pomerenaFigura.napraviFiguru(this);
        tb.setPrelazniPotez(this);
        pomeren.setPrviPotez(false);
        tb.setFiguru(pomeren);
        tb.setNaPotezuJe(pozicija.getTrenutniIgrac().getProtivnik().getBoja());

        return tb.napravi();
    }
}
