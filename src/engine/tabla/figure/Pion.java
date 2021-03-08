package engine.tabla.figure;

import engine.tabla.Tabla;
import engine.tabla.TablaUtils;
import engine.tabla.polje.PraznoPolje;
import engine.tabla.polje.ValidnoPolje;
import engine.tabla.potez.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Pion extends Figura {

    private boolean prviPotez;
    public static int[] pomeraj = {9, 10, 11, 20};

    public Pion(int koordinata, Boja boja) {
        super(koordinata, boja);
        this.tip = TipFigure.PION;
        this.prviPotez = true;
    }

    public Pion(int destinaciju, Boja boja, boolean prviPotez) {
        super(destinaciju, boja);
        this.tip = TipFigure.PION;
        this.prviPotez = prviPotez;
    }

    public int izracunajPravac() {
        return this.boja.equals(Boja.BELA) ? -1 : 1;
    }

    @Override
    public Collection<Potez> izracunajLegalnePoteze(Tabla tabla) {

        List<Potez> legalniPotezi = new ArrayList<>();

        for (int kandidatPomeraj :
                pomeraj) {
            int kandidatKoordinata = this.koordinata + kandidatPomeraj * izracunajPravac();
            if (TablaUtils.validnostPolja[kandidatKoordinata]) {
                ValidnoPolje kandidatPolje = tabla.getPolje(kandidatKoordinata);

                if (kandidatPomeraj == 9 || kandidatPomeraj == 11) {
                    if (kandidatPolje.isZauzeto()) {
                        Figura napadnutaFigura = kandidatPolje.getFigura();
                        if (!napadnutaFigura.getBoja().equals(this.boja)) {
                            legalniPotezi.add(new NapadackiPotezPiona(tabla, this, kandidatKoordinata, napadnutaFigura));
                        }
                    } else {
                        if (tabla.getEnPassantpion() != null)
                            if (tabla.getEnPassantpion().getKoordinata() == this.getKoordinata() + 1 || tabla.getEnPassantpion().getKoordinata() == this.getKoordinata() - 1) {
                                legalniPotezi.add(new NapadackiPotezPiona(tabla, this, kandidatKoordinata, tabla.getEnPassantpion()));
                            }
                    }
                }
                if (kandidatPomeraj == 10) {
                    if (!kandidatPolje.isZauzeto()) {
                        legalniPotezi.add(new PotezPiona(tabla, this, kandidatKoordinata));
                    }
                }
                if (kandidatPomeraj == 20) {
                    if (isPrviPotez())
                        if (!kandidatPolje.isZauzeto()) {
                            ValidnoPolje poljeIspredPiona = tabla.getPolje(kandidatKoordinata - 10 * izracunajPravac());
                            if (!poljeIspredPiona.isZauzeto())
                                legalniPotezi.add(new SkokPiona(tabla, this, kandidatKoordinata));
                        }
                }
            }
        }

        return Collections.unmodifiableCollection(legalniPotezi);
    }

    @Override
    public Pion napraviFiguru(Potez potez) {
        return new Pion(potez.getDestinaciju(), potez.getPomerenuFiguru().getBoja());
    }

    public Pion napraviFiguru(Potez potez, boolean prviPotez) {
        Pion noviPion = new Pion(potez.getDestinaciju(), potez.getPomerenuFiguru().getBoja(), false);
        noviPion.setPrviPotez(prviPotez);
        return noviPion;
    }

    @Override
    public String toString() {
        return this.boja.equals(Boja.BELA) ? "P" : "p";
    }

    private boolean prviPotez() {
        return prviPotez;
    }

    public boolean isPrviPotez() {
        return prviPotez;
    }

    public void setPrviPotez(boolean prviPotez) {
        this.prviPotez = prviPotez;
    }
}
