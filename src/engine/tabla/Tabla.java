package engine.tabla;

import engine.tabla.figure.Boja;
import engine.tabla.figure.Figura;
import engine.tabla.figure.Pion;
import engine.tabla.polje.Polje;
import engine.tabla.polje.ValidnoPolje;
import engine.tabla.potez.NullPotez;
import engine.tabla.potez.Potez;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static engine.tabla.TablaUtils.validnostPolja;

public class Tabla {
    /*
     * 10x12 tabla
     * */
    private List<Polje> poljaNaTabli;
    private Collection<Figura> beleFigure;
    private Collection<Figura> crneFigure;

    private BeliIgrac beliIgrac;
    private CrniIgrac crniIgrac;
    private Igrac trenutniIgrac;

    private Pion enPassantpion;

    private Boja naPotezuJe;
    private int brojReversiblePoteza;
    private int brojPoteza;
    private final Potez prelazniPotez;


    protected Tabla(TablaBuilder tablaBuilder) {
        this.brojPoteza=tablaBuilder.brojPoteza+1;
        this.enPassantpion = tablaBuilder.enPassantPion;
        this.poljaNaTabli = tablaBuilder.initPoljaNaTabli();
        this.beleFigure = tablaBuilder.beleFigure;
        this.crneFigure = tablaBuilder.crneFigure;
        this.naPotezuJe = tablaBuilder.naPotezuJe;

        Collection<Potez> legalniPoteziBelog = izracunajLegalnePotezeBelog();
        Collection<Potez> legalniPoteziCrnog = izracunajLegalnePotezeCrnog();
        this.beliIgrac = new BeliIgrac(this, legalniPoteziBelog, legalniPoteziCrnog, tablaBuilder.isBeliIzvrsioRokadu());
        this.crniIgrac = new CrniIgrac(this, legalniPoteziCrnog, legalniPoteziBelog, tablaBuilder.isCrniIzvrsioRokadu());

        this.trenutniIgrac = izracunajTrenutnogIgraca();
        this.prelazniPotez = tablaBuilder.prelazniPotez != null ? tablaBuilder.prelazniPotez : NullPotez.getInstance();
    }

    public Potez getPrelazniPotez() {
        return prelazniPotez;
    }

    public Igrac izracunajTrenutnogIgraca() {
        return naPotezuJe.isBeli() ? beliIgrac : crniIgrac;
    }

    public Igrac izracunajKoIgraSledeciPotez() {
        return naPotezuJe.equals(Boja.BELA) ? crniIgrac : beliIgrac;
    }

    public int getBrojFigura(){
        return getBeleFigure().size() + getCrneFigure().size();
    }

    public Collection<Potez> izracunajLegalnePoteze(Collection<Figura> figure) {
        List<Potez> legalniPotezi = new ArrayList<>();
        for (Figura figura :
                figure) {
            legalniPotezi.addAll(figura.izracunajLegalnePoteze(this));
        }
        return Collections.unmodifiableList(legalniPotezi);
    }

    public Collection<Potez> izracunajLegalnePotezeBelog() {
        List<Potez> legalniPotezi = new ArrayList<>();
        for (Figura figura :
                this.beleFigure) {
            legalniPotezi.addAll(figura.izracunajLegalnePoteze(this));
        }
        return Collections.unmodifiableList(legalniPotezi);
    }

    public Collection<Potez> izracunajLegalnePotezeCrnog() {
        List<Potez> legalniPotezi = new ArrayList<>();
        for (Figura figura :
                this.crneFigure) {
            legalniPotezi.addAll(figura.izracunajLegalnePoteze(this));
        }
        return Collections.unmodifiableList(legalniPotezi);
    }

    public Collection<Figura> getBeleFigure() {
        return beleFigure;
    }

    public Collection<Figura> getCrneFigure() {
        return crneFigure;
    }

    public BeliIgrac getBeliIgrac() {
        return beliIgrac;
    }

    public CrniIgrac getCrniIgrac() {
        return crniIgrac;
    }

    public Collection<Potez> izracunajSveLegalnePoteze() {
        List<Potez> legalniPotezi = new ArrayList<>();
        List<Figura> sveFigure = new ArrayList<>();
        sveFigure.addAll(beleFigure);
        sveFigure.addAll(crneFigure);

        for (Figura figura :
                sveFigure) {
            legalniPotezi.addAll(figura.izracunajLegalnePoteze(this));
        }
        return Collections.unmodifiableList(legalniPotezi);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 120; i++) {
            if (validnostPolja[i]) {
                Polje polje = getPolje(i);
                sb.append(polje.toString());
                if ((polje.getKoordinata() + 1) % 10 == 9) {
                    sb.append(System.lineSeparator());
                }
            }
        }
        return sb.toString();
    }

    public ArrayList<Pion> getSvePione() {
        ArrayList<Pion> pioni = new ArrayList<>();

        for (Figura figura :
                getCrneFigure()) {

            if (figura.getTip().isPion()) {
                System.out.println(1);
                pioni.add((Pion) figura);
            }
        }
        for (Figura figura :
                getBeleFigure()) {
            if (figura.getTip().isPion()) {
                pioni.add((Pion) figura);
                System.out.println(2);
            }
        }
        return pioni;
    }

    public ValidnoPolje getPolje(int koordinata) {
        return (ValidnoPolje) poljaNaTabli.get(koordinata);
    }

    public Polje realGetPolje(int koordinata){
        return poljaNaTabli.get(koordinata);
    }

    public Igrac getTrenutniIgrac() {
        return this.trenutniIgrac;
    }

    public Collection<Potez> getSveLegalnePoteze() {
        List<Potez> sviLegalniPotezi = new ArrayList<>();
        sviLegalniPotezi.addAll(beliIgrac.getLegalniPotezi());
        sviLegalniPotezi.addAll(crniIgrac.getLegalniPotezi());
        return sviLegalniPotezi;
    }

    public Pion getEnPassantpion() {
        return enPassantpion;
    }

    public int getBrojPoteza() {
        return brojPoteza;
    }
}
