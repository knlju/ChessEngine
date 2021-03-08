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

public class Konj extends Figura {

    public static int[] pomeraj = {-12, -8, -21, -19, 12, 8, 21, 19};

    public Konj(int koordinata, Boja boja) {
        super(koordinata, boja);
        this.tip = TipFigure.KONJ;
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

    @Override
    public Konj napraviFiguru(Potez potez) {
        return new Konj(potez.getDestinaciju(),potez.getPomerenuFiguru().getBoja());
    }

    @Override
    public String toString() {
        return this.boja.equals(Boja.BELA) ? "N" : "n";
    }
}
