package engine.tabla.potez;

import engine.tabla.Tabla;
import engine.tabla.TablaBuilder;
import engine.tabla.TablaUtils;
import engine.tabla.figure.Figura;
import engine.tabla.figure.Pion;

public class SkokPiona extends TihiPotez {
    public SkokPiona(Tabla pozicija, Figura pomerenaFigura, int koordinataDestinacije) {
        super(pozicija, pomerenaFigura, koordinataDestinacije);
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
            tb.setFiguru(figura);
        }
        Pion pomerenPion = (Pion) this.pomerenaFigura.napraviFiguru(this);
        pomerenPion.setPrviPotez(false);
        tb.setPrelazniPotez(this);
        tb.setFiguru(pomerenPion);
        tb.setEnPassant(pomerenPion);
        tb.setNaPotezuJe(pozicija.getTrenutniIgrac().getProtivnik().getBoja());
        if (pozicija.getTrenutniIgrac().isIzvrsioRokadu()) tb.setIzvrsioRokadu(pozicija.getTrenutniIgrac().getBoja());
        if (pozicija.getTrenutniIgrac().getProtivnik().isIzvrsioRokadu()) tb.setIzvrsioRokadu(pozicija.getTrenutniIgrac().getProtivnik().getBoja());

        return tb.napravi();
    }

    @Override
    public String toString() {
        return TablaUtils.kodiranaPolja[koordinataDestinacije];
    }
}
