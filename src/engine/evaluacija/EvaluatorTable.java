package engine.evaluacija;

import engine.tabla.Igrac;
import engine.tabla.Tabla;
import engine.tabla.figure.Figura;
import engine.tabla.figure.Kralj;
import engine.tabla.polje.Polje;

public class EvaluatorTable {

    private static final int BONUS_ZA_POKRETLJIVOST = 2;
    private static final int BONUS_ZA_ROKADU = 60;
    private static final int BONUS_ZA_SAH = 10;
    private static final int BONUS_ZA_MAT = 50_000;
    private static final int BROJ_FIGURA_ZA_ENDGAME = 12;
    private static final int BONUS_ZA_NEBEZBEDNOST = 3;
    private static final int[] POMERAJ_KOORDINATA_OKO_KRALJA = {10, 9, 8, 1, -1, -8, -9, -10};
    private static final int BONUS_ZA_B_PAIR = 75;

    public int vratiEvaluaciju(Tabla tabla) {
        return izracunajVrednostIgraca(tabla, tabla.getBeliIgrac()) - izracunajVrednostIgraca(tabla, tabla.getCrniIgrac());
    }

    private int izracunajVrednostIgraca(Tabla tabla, Igrac igrac) {
        return vrednostFigura(igrac) + prostor(igrac) + izvrsioRokadu(igrac) + sah(igrac) + mat(igrac)
                + pozicijaFigura(igrac, tabla, tabla.getBrojPoteza()) + bezbednostKralja(igrac, tabla)
                + bishopPair(igrac);
    }

    private int bishopPair(Igrac igrac) {
        int brojLovaca = 0;
        for (Figura figura :
                igrac.getFigure()) {
            if (figura.getTip().isLovac()) {
                brojLovaca++;
            }
        }
        boolean imaPar = ((brojLovaca - 2) == 0);
        return imaPar ? BONUS_ZA_B_PAIR : 0;
    }

    private int mat(Igrac igrac) {
        return igrac.getProtivnik().isUMatu() ? BONUS_ZA_MAT : 0;
    }

    private int sah(Igrac igrac) {
        return igrac.getProtivnik().isUSahu() ? BONUS_ZA_SAH : 0;
    }

    private int izvrsioRokadu(Igrac igrac) {
        return igrac.isIzvrsioRokadu() ? BONUS_ZA_ROKADU : 0;
    }

    private int prostor(Igrac igrac) {
        return igrac.getLegalniPotezi().size() * BONUS_ZA_POKRETLJIVOST;
    }

    private int bezbednostKralja(Igrac igrac, Tabla pozicija) {
        int bezbednost = 0;
        Kralj kralj = igrac.getKralj();

        for (int pomeraj :
                POMERAJ_KOORDINATA_OKO_KRALJA) {
            int kandidatKoordinata = kralj.getKoordinata() + pomeraj;
            Polje polje = pozicija.realGetPolje(kandidatKoordinata);
            if (polje.isValidnoPolje()) {
                bezbednost -= Igrac.izracunajNapadeNaPolje(kandidatKoordinata, igrac.getProtivnik().getLegalniPotezi()).size() * BONUS_ZA_NEBEZBEDNOST;
            }
        }

        return bezbednost;
    }

    private int vrednostFigura(Igrac igrac) {
        int vrednost = 0;
        for (Figura figura :
                igrac.getFigure()) {
            vrednost += figura.getVrednost();
        }
        return vrednost;
    }

    private int pozicijaFigura(Igrac igrac, Tabla pozicija, int brojPoteza) {
        int ocena = 0;

        if (pozicija.getBrojFigura() <= BROJ_FIGURA_ZA_ENDGAME) {
            if (igrac.getBoja().isBeli()) {
                for (Figura figura : igrac.getFigure()) {
                    // ------ LOVAC ------
                    if (figura.getTip().isLovac()) {
                        int koeficijent = PieceSquareTables.beliLovacEndgame[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                    // ------ PION ------
                    if (figura.getTip().isPion()) {
                        int koeficijent = PieceSquareTables.beliPionEndgame[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                    // ------ KRALJICA -------
                    if (figura.getTip().isKraljica()) {
                        int koeficijent = PieceSquareTables.belaKraljicaEndgame[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                    // ------ KONJ -------
                    if (figura.getTip().isKonj()) {
                        int koeficijent = PieceSquareTables.beliKonjEndgame[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                    // ------ TOP -------
                    if (figura.getTip().isTop()) {
                        int koeficijent = PieceSquareTables.beliTopEndgame[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                }
            } else {
                for (Figura figura : igrac.getFigure()) {
                    // ------ LOVAC ------
                    if (figura.getTip().isLovac()) {
                        int koeficijent = PieceSquareTables.crniLovacEndgame[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                    // ------ PION ------
                    if (figura.getTip().isPion()) {
                        int koeficijent = PieceSquareTables.crniPionEndgame[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                    // ------ KRALJICA -------
                    if (figura.getTip().isKraljica()) {
                        int koeficijent = PieceSquareTables.crnaKraljicaEndgame[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                    // ------ KONJ -------
                    if (figura.getTip().isKonj()) {
                        int koeficijent = PieceSquareTables.crniKonjEndgame[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                    // ------ TOP -------
                    if (figura.getTip().isTop()) {
                        int koeficijent = PieceSquareTables.crniTopEndgame[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                }
            }
        } else {
            if (igrac.getBoja().isBeli()) {
                for (Figura figura : igrac.getFigure()) {
                    // ------ LOVAC ------
                    if (figura.getTip().isLovac()) {
                        int koeficijent = PieceSquareTables.beliLovac[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                    // ------ PION ------
                    if (figura.getTip().isPion()) {
                        int koeficijent = PieceSquareTables.beliPion[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                    // ------ KRALJICA -------
                    if (figura.getTip().isKraljica()) {
                        int koeficijent;
                        if (brojPoteza > 20) koeficijent = PieceSquareTables.belaKraljica[figura.getKoordinata()];
                        else koeficijent = PieceSquareTables.belaKraljicaOpening[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                    // ------ KONJ -------
                    if (figura.getTip().isKonj()) {
                        int koeficijent = PieceSquareTables.beliKonj[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                    // ------ TOP -------
                    if (figura.getTip().isTop()) {
                        int koeficijent = PieceSquareTables.beliTop[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                    // ------ KRALJ -------
                    if (figura.getTip().isKralj()) {
                        int koeficijent = PieceSquareTables.beliKralj[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                }
            } else {
                for (Figura figura : igrac.getFigure()) {
                    // ------ LOVAC ------
                    if (figura.getTip().isLovac()) {
                        int koeficijent = PieceSquareTables.crniLovac[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                    // ------ PION ------
                    if (figura.getTip().isPion()) {
                        int koeficijent = PieceSquareTables.crniPion[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                    // ------ KRALJICA -------
                    if (figura.getTip().isKraljica()) {
                        int koeficijent;
                        if (brojPoteza > 20) koeficijent = PieceSquareTables.crnaKraljica[figura.getKoordinata()];
                        else koeficijent = PieceSquareTables.crnaKraljicaOpening[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                    // ------ KONJ -------
                    if (figura.getTip().isKonj()) {
                        int koeficijent = PieceSquareTables.crniKonj[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                    // ------ TOP -------
                    if (figura.getTip().isTop()) {
                        int koeficijent = PieceSquareTables.crniTop[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                    // ------ KRALJ -------
                    if (figura.getTip().isKralj()) {
                        int koeficijent = PieceSquareTables.crniKralj[figura.getKoordinata()];
                        ocena += koeficijent;
                    }
                }
            }
        }

        return ocena;
    }

}
