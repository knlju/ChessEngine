package engine.tabla;

import engine.tabla.figure.Boja;
import engine.tabla.figure.Figura;
import engine.tabla.figure.Kralj;
import engine.tabla.potez.Potez;
import engine.tabla.potez.PrelazPoteza;
import engine.tabla.potez.StatusPoteza;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Igrac {

    protected Tabla trenutnaPozicija;
    protected Collection<Potez> legalniPotezi;
    protected Kralj kralj;
    protected boolean isUSahu;
    private boolean izvrsioRokadu;

    public Igrac(Tabla trenutnaPozicija, Collection<Potez> legalniPoteziIgraca, Collection<Potez> legalniPoteziProtivnika, boolean izvrsioRokadu) {
        this.trenutnaPozicija = trenutnaPozicija;
        this.kralj = izracunajKralja();
        this.isUSahu = !Igrac.izracunajNapadeNaPolje(this.kralj.getKoordinata(), legalniPoteziProtivnika).isEmpty();
        this.izvrsioRokadu = izvrsioRokadu;
        ArrayList <Potez> sviLegalniPoteziIgraca = new ArrayList<>(izracunajRokade(legalniPoteziProtivnika));
        sviLegalniPoteziIgraca.addAll(legalniPoteziIgraca);
        this.legalniPotezi = sviLegalniPoteziIgraca;
    }

    public static Collection<Potez> izracunajNapadeNaPolje(int koordinata, Collection<Potez> legalniPoteziProtivnika) {
        List<Potez> napadi = new ArrayList<>();

        for (Potez kandidatPotez :
                legalniPoteziProtivnika) {
            if (kandidatPotez.getDestinaciju() == koordinata) napadi.add(kandidatPotez);
        }

        return napadi;
    }


    public Kralj izracunajKralja() {

        for (Figura kandidat :
                getFigure()) {
            if (kandidat.getTip().isKralj()) return (Kralj) kandidat;
        }
        // ne bi trebalo da se stigne do ovde nikad
        return null;
    }

    public boolean isLegalanPotez(Potez kandidatPotez) {
        return this.legalniPotezi.contains(kandidatPotez);
    }

    public boolean isUSahu() {
        return this.isUSahu;
    }

    public boolean isUPatu() {
        return !this.isUSahu && !mozeIzbeciSah();
    }

    public boolean isUMatu() {
        return this.isUSahu && !mozeIzbeciSah();
    }

    public Kralj getKralj() {
        return kralj;
    }

    public Collection<Potez> getLegalniPotezi() {
        return legalniPotezi;
    }

    private boolean mozeIzbeciSah() {

        for (Potez kandidatPotez :
                legalniPotezi) {
            PrelazPoteza prelaz = napraviPotez(kandidatPotez);
            if (prelaz.getStatusPoteza().isLegalan()) {
                return true;
            }
        }

        return false;
    }

    public PrelazPoteza napraviPotez(Potez potez) {

        if (!isLegalanPotez(potez)) {
            return new PrelazPoteza(this.trenutnaPozicija, potez, StatusPoteza.NELEGALAN);
        }

        Tabla prelaznaTabla = potez.izvrsi();
        Igrac trenutniIgrac = prelaznaTabla.getTrenutniIgrac();

        Collection<Potez> napadiNaKralja = Igrac.izracunajNapadeNaPolje(trenutniIgrac.getProtivnik().getKralj().getKoordinata(),
                trenutniIgrac.getLegalniPotezi());

        if (!napadiNaKralja.isEmpty()) {
            return new PrelazPoteza(this.trenutnaPozicija, potez, StatusPoteza.NELEGALAN);
        }

        return new PrelazPoteza(prelaznaTabla, potez);
    }

    public boolean izvrsioRokadu() {
        return false;
    }

    public abstract Boja getBoja();

    public abstract Igrac getProtivnik();

    public abstract Collection<Figura> getFigure();

    protected abstract Collection<Potez> izracunajRokade(Collection<Potez> protivnikoviLegalniPotezi);

    public boolean isIzvrsioRokadu() {
        return izvrsioRokadu;
    }
}
