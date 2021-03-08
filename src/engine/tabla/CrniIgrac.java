package engine.tabla;

import engine.tabla.figure.Boja;
import engine.tabla.figure.Figura;
import engine.tabla.figure.TipFigure;
import engine.tabla.figure.Top;
import engine.tabla.polje.ValidnoPolje;
import engine.tabla.potez.MalaRokada;
import engine.tabla.potez.Potez;
import engine.tabla.potez.VelikaRokada;

import java.util.ArrayList;
import java.util.Collection;

public class CrniIgrac extends Igrac {
    public CrniIgrac(Tabla trenutnaPozicija, Collection<Potez> legalniPoteziCrnog, Collection<Potez> legalniPoteziBelog,boolean izvrsioRokadu) {
        super(trenutnaPozicija, legalniPoteziCrnog, legalniPoteziBelog, izvrsioRokadu);
    }

    @Override
    public Boja getBoja() {
        return Boja.CRNA;
    }

    @Override
    public Igrac getProtivnik() {
        return this.trenutnaPozicija.getBeliIgrac();
    }

    @Override
    public Collection<Figura> getFigure() {
        return this.trenutnaPozicija.getCrneFigure();
    }

    @Override
    protected Collection<Potez> izracunajRokade(Collection<Potez> protivnikoviLegalniPotezi) {
        ArrayList<Potez> rokade = new ArrayList<>();
        if (this.kralj.isPrviPotez() && !this.isUSahu()) {
            if (!this.trenutnaPozicija.getPolje(26).isZauzeto() && !this.trenutnaPozicija.getPolje(27).isZauzeto()) {
                ValidnoPolje topovoPolje = trenutnaPozicija.getPolje(28);
                if (topovoPolje.isZauzeto()) {
                    if (topovoPolje.getFigura().getTip().isTop()) {
                        if (((Top) topovoPolje.getFigura()).isPrviPotez())
                            if (izracunajNapadeNaPolje(26, protivnikoviLegalniPotezi).isEmpty()
                                    && izracunajNapadeNaPolje(27, protivnikoviLegalniPotezi).isEmpty()) {
                                rokade.add(new MalaRokada(trenutnaPozicija,kralj,27,(Top) topovoPolje.getFigura(),28,26));
                            }
                    }
                }
            }
        }
        if (this.kralj.isPrviPotez() && !this.isUSahu()) {
            if (!this.trenutnaPozicija.getPolje(22).isZauzeto()
                    && !this.trenutnaPozicija.getPolje(23).isZauzeto()
                    && !this.trenutnaPozicija.getPolje(24).isZauzeto()) {
                ValidnoPolje topovoPolje = trenutnaPozicija.getPolje(21);
                if (topovoPolje.isZauzeto()) {
                    if (topovoPolje.getFigura().getTip().isTop()) {
                        if (((Top) topovoPolje.getFigura()).isPrviPotez())
                            if (izracunajNapadeNaPolje(22, protivnikoviLegalniPotezi).isEmpty()
                                    && izracunajNapadeNaPolje(23, protivnikoviLegalniPotezi).isEmpty()) {
                                rokade.add(new VelikaRokada(trenutnaPozicija,kralj,23,(Top) topovoPolje.getFigura(),21,24));
                            }
                    }
                }
            }
        }
        return rokade;
    }
}
