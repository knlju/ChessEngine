package engine.tabla;

import engine.tabla.figure.Boja;
import engine.tabla.figure.Figura;
import engine.tabla.figure.Top;
import engine.tabla.polje.ValidnoPolje;
import engine.tabla.potez.MalaRokada;
import engine.tabla.potez.Potez;
import engine.tabla.potez.VelikaRokada;

import java.util.ArrayList;
import java.util.Collection;

public class BeliIgrac extends Igrac {
    public BeliIgrac(Tabla trenutnaPozicija, Collection<Potez> legalniPoteziCrnog, Collection<Potez> legalniPoteziBelog, boolean izvrsioRokadu) {
        super(trenutnaPozicija, legalniPoteziCrnog, legalniPoteziBelog, izvrsioRokadu);
    }

    @Override
    public Boja getBoja() {
        return Boja.BELA;
    }

    @Override
    public Igrac getProtivnik() {
        return this.trenutnaPozicija.getCrniIgrac();
    }

    @Override
    public Collection<Figura> getFigure() {
        return this.trenutnaPozicija.getBeleFigure();
    }

    @Override
    protected Collection<Potez> izracunajRokade(Collection<Potez> protivnikoviLegalniPotezi) {
        ArrayList<Potez> rokade = new ArrayList<>();
        if (this.kralj.isPrviPotez()
                && !this.isUSahu()) {
            if (!this.trenutnaPozicija.getPolje(96).isZauzeto() && !this.trenutnaPozicija.getPolje(97).isZauzeto()) {
                ValidnoPolje topovoPolje = trenutnaPozicija.getPolje(98);
                if (topovoPolje.isZauzeto()) {
                    if (topovoPolje.getFigura().getTip().isTop()) {
                        if (((Top) topovoPolje.getFigura()).isPrviPotez()) {
                            if (izracunajNapadeNaPolje(96, protivnikoviLegalniPotezi).isEmpty()
                                    && izracunajNapadeNaPolje(97, protivnikoviLegalniPotezi).isEmpty()) {
                                rokade.add(new MalaRokada(trenutnaPozicija, kralj, 97, (Top) topovoPolje.getFigura(), 98, 96));
                            }
                        }
                    }
                }
            }
        }
        if (this.kralj.isPrviPotez() && !this.isUSahu()) {
            if (!this.trenutnaPozicija.getPolje(94).isZauzeto()
                    && !this.trenutnaPozicija.getPolje(93).isZauzeto()
                    && !this.trenutnaPozicija.getPolje(92).isZauzeto()) {
                ValidnoPolje topovoPolje = trenutnaPozicija.getPolje(91);
                if (topovoPolje.isZauzeto()) {
                    if (topovoPolje.getFigura().getTip().isTop()) {
                        if (((Top) topovoPolje.getFigura()).isPrviPotez()) {
                            if (izracunajNapadeNaPolje(94, protivnikoviLegalniPotezi).isEmpty()
                                    && izracunajNapadeNaPolje(93, protivnikoviLegalniPotezi).isEmpty()) {
                                rokade.add(new VelikaRokada(trenutnaPozicija, kralj, 93, (Top) topovoPolje.getFigura(), 91, 94));
                            }
                        }
                    }
                }
            }
        }
        return rokade;
    }
}
