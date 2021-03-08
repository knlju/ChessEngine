package engine.tabla;

import engine.tabla.figure.*;
import engine.tabla.polje.NevalidnoPolje;
import engine.tabla.polje.Polje;
import engine.tabla.polje.ValidnoPolje;
import engine.tabla.potez.Potez;

import java.util.*;

import static engine.tabla.TablaUtils.brojPoljaNaTabli;
import static engine.tabla.TablaUtils.validnostPolja;

/*
 * prvo set figure
 * onda init polja na tabli
 * */


public class TablaBuilder {

    public Map<Integer, Figura> mapaFigura;
    public Collection<Figura> beleFigure;
    public Collection<Figura> crneFigure;
    public Boja naPotezuJe;
    public Pion enPassantPion;
    public List<Polje> polja;
    public Potez prelazniPotez;
    public int brojPoteza;
    private boolean beliIzvrsioRokadu;
    private boolean crniIzvrsioRokadu;

    public TablaBuilder() {
        this.mapaFigura = new HashMap<>();
        this.beleFigure = new ArrayList<>();
        this.crneFigure = new ArrayList<>();
        this.polja = new ArrayList<>();
        this.enPassantPion = null;
    }

    public Tabla napraviTestPoziciju1(){
        Pion bp = new Pion(82,Boja.BELA);
        Pion cp = new Pion(63,Boja.CRNA);
        Kralj ck = new Kralj(28, Boja.CRNA);
        Kralj bk = new Kralj(98, Boja.BELA);

        this.setFiguru(bp);
        this.setFiguru(cp);
        this.setFiguru(bk);
        this.setFiguru(ck);

        setNaPotezuJe(Boja.BELA);
        setBrojPoteza(0);

        return napravi();
    }

    public Tabla napraviStandardnuPocetnuPoziciju() {
        Top bqr = new Top(91, Boja.BELA);
        Top bkr = new Top(98, Boja.BELA);
        Konj bqn = new Konj(92, Boja.BELA);
        Konj bkn = new Konj(97, Boja.BELA);
        Lovac bkl = new Lovac(96, Boja.BELA);
        Lovac bql = new Lovac(93, Boja.BELA);
        Kraljica bq = new Kraljica(94, Boja.BELA);
        Kralj bk = new Kralj(95, Boja.BELA);
        Collection<Figura> beliPioni = new ArrayList<>();
        for (int i = 81; i < 89; i++) {
            beliPioni.add(new Pion(i, Boja.BELA));
        }
        Top cqr = new Top(21, Boja.CRNA);
        Top ckr = new Top(28, Boja.CRNA);
        Konj cqn = new Konj(22, Boja.CRNA);
        Konj ckn = new Konj(27, Boja.CRNA);
        Lovac ckl = new Lovac(26, Boja.CRNA);
        Lovac cql = new Lovac(23, Boja.CRNA);
        Kraljica cq = new Kraljica(24, Boja.CRNA);
        Kralj ck = new Kralj(25, Boja.CRNA);
        Collection<Figura> crniPioni = new ArrayList<>();
        for (int i = 31; i < 39; i++) {
            crniPioni.add(new Pion(i, Boja.CRNA));
        }

        this.setFiguru(bqr);
        this.setFiguru(bkr);
        this.setFiguru(bqn);
        this.setFiguru(bkn);
        this.setFiguru(bkl);
        this.setFiguru(bql);
        this.setFiguru(bq);
        this.setFiguru(bk);
        for (Figura pion :
                beliPioni) {
            this.setFiguru(pion);
        }

        this.setFiguru(cqr);
        this.setFiguru(ckr);
        this.setFiguru(cqn);
        this.setFiguru(ckn);
        this.setFiguru(ckl);
        this.setFiguru(cql);
        this.setFiguru(cq);
        this.setFiguru(ck);

        setNaPotezuJe(Boja.BELA);
        setBrojPoteza(0);

        for (Figura pion :
                crniPioni) {
            this.setFiguru(pion);
        }
        return napravi();
    }

    public TablaBuilder setEnPassant(Pion enPassant) {
        this.enPassantPion = enPassant;
        return this;
    }

    public TablaBuilder setFiguru(Figura figura) {
        this.mapaFigura.put(figura.getKoordinata(), figura);
        if (figura.getBoja().equals(Boja.BELA)) {
            beleFigure.add(figura);
        } else {
            crneFigure.add(figura);
        }
        return this;
    }

    public TablaBuilder setNaPotezuJe(Boja sledeciNaPotezu) {
        this.naPotezuJe = sledeciNaPotezu;
        return this;
    }

    public List<Polje> initPoljaNaTabli() {
        List<Polje> polja = new ArrayList<>();

        for (int i = 0; i < brojPoljaNaTabli; i++) {
            if (validnostPolja[i]) {
                polja.add(ValidnoPolje.napraviPolje(i, this.mapaFigura.get(i)));
            } else {
                polja.add(new NevalidnoPolje(i));
            }
        }

        return Collections.unmodifiableList(polja);
    }

    public void setPrelazniPotez(Potez prelazniPotez) {
        this.prelazniPotez = prelazniPotez;
    }

    public Potez getPrelazniPotez() {
        return prelazniPotez;
    }

    public Tabla napravi() {
        return new Tabla(this);
    }

    public boolean isBeliIzvrsioRokadu() {
        return beliIzvrsioRokadu;
    }

    public boolean isCrniIzvrsioRokadu() {
        return crniIzvrsioRokadu;
    }

    public void setBrojPoteza(int brojPoteza) {
        this.brojPoteza = brojPoteza;
    }

    public int getBrojPoteza() {
        return brojPoteza;
    }

    public void setIzvrsioRokadu(Boja boja) {
        if (boja.isBeli()) this.beliIzvrsioRokadu = true;
        else this.crniIzvrsioRokadu = true;
    }
}
