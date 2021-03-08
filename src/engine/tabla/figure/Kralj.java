package engine.tabla.figure;

import engine.tabla.Tabla;
import engine.tabla.TablaUtils;
import engine.tabla.polje.ValidnoPolje;
import engine.tabla.potez.NapadackiPotez;
import engine.tabla.potez.Potez;
import engine.tabla.potez.TihiPotez;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Kralj extends Figura {

    private boolean prviPotez;
    public static int[] pomeraj = {-1, 1, -10, 10, -9, 9, -11, 11};

    public Kralj(int koordinata, Boja boja) {
        super(koordinata, boja);
        prviPotez = true;
        this.tip = TipFigure.KRALJ;
    }

    public Kralj(int destinaciju, Boja boja, boolean prviPotez) {
        super(destinaciju, boja);
        this.prviPotez = prviPotez;
        this.tip = TipFigure.KRALJ;
    }

    @Override
    public Collection<Potez> izracunajLegalnePoteze(Tabla tabla) {
        List<Potez> legalniPotezi = new ArrayList<>();

        for (int kandidatPomeraj :
                pomeraj) {
            int kandidatKoordinata = this.koordinata + kandidatPomeraj;
            if(TablaUtils.validnostPolja[kandidatKoordinata]){
                ValidnoPolje kandidatPolje = tabla.getPolje(kandidatKoordinata);
                if (kandidatPolje.isZauzeto()){
                    Figura figuraNaDestinaciji = kandidatPolje.getFigura();
                    if (!figuraNaDestinaciji.getBoja().equals(this.boja)){
                        legalniPotezi.add(new NapadackiPotez(tabla,this,kandidatKoordinata,figuraNaDestinaciji));
                    }
                }else{
                    legalniPotezi.add(new TihiPotez(tabla,this,kandidatKoordinata));
                }
            }
        }

        return Collections.unmodifiableCollection(legalniPotezi);
    }

    public boolean isPrviPotez() {
        return prviPotez;
    }

    public void setPrviPotez(boolean prviPotez) {
        this.prviPotez = prviPotez;
    }

    @Override
    public Kralj napraviFiguru(Potez potez) {
        Kralj noviKralj = new Kralj(potez.getDestinaciju(),potez.getPomerenuFiguru().getBoja(),false);
        noviKralj.setPrviPotez(prviPotez);
        return noviKralj;
    }
    @Override
    public String toString() {
        return this.boja.equals(Boja.BELA) ? "K" : "k";
    }
}
