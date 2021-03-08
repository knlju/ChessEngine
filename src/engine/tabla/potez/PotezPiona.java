package engine.tabla.potez;

import engine.tabla.Tabla;
import engine.tabla.TablaBuilder;
import engine.tabla.TablaUtils;
import engine.tabla.figure.Figura;
import engine.tabla.figure.Kraljica;
import engine.tabla.figure.Pion;

public class PotezPiona extends Potez {
    public PotezPiona(Tabla pozicija, Figura pomerenaFigura, int koordinataDestinacije) {
        super(pozicija, pomerenaFigura, koordinataDestinacije);
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
        Pion pomerenPion = (Pion) this.pomerenaFigura.napraviFiguru(this);
        pomerenPion.setPrviPotez(false);
        tb.setPrelazniPotez(this);
        tb.setFiguru(pomerenPion);
        tb.setNaPotezuJe(pozicija.getTrenutniIgrac().getProtivnik().getBoja());

        return tb.napravi();
    }
}
