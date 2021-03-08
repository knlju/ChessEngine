package gui;

import engine.tabla.TablaUtils;
import engine.tabla.figure.Boja;
import engine.tabla.figure.Figura;
import engine.tabla.figure.TipFigure;
import engine.tabla.potez.Potez;
import engine.tabla.potez.PrelazPoteza;
import javafx.scene.image.ImageView;

import static gui.GUI.VISINA_MENU;

public class SlikaFigure extends ImageView {

    private static String ct = "gui/img/ct.png";
    private static String bt = "gui/img/bt.png";
    private static String cp = "gui/img/cp.png";
    private static String bp = "gui/img/bp.png";
    private static String cn = "gui/img/cn.png";
    private static String bn = "gui/img/bn.png";
    private static String cq = "gui/img/cq.png";
    private static String bq = "gui/img/bq.png";
    private static String ck = "gui/img/ck.png";
    private static String bk = "gui/img/bk.png";
    private static String cl = "gui/img/cl.png";
    private static String bl = "gui/img/bl.png";

    public SlikaFigure(Figura figura, String url, int koordinata) {
        super(url);
        int[] koordinate = TablaUtils.jednodimenzionalneUDvodimenzionalne[koordinata];
        setFitWidth(GUI.DIMENZIJA_POLJA);
        setFitHeight(GUI.DIMENZIJA_POLJA);
        relocate(koordinate[1] * GUI.DIMENZIJA_POLJA, koordinate[0] * GUI.DIMENZIJA_POLJA + VISINA_MENU);

        setOnMouseDragged(e -> {
            toFront();
            relocate(e.getSceneX() - GUI.DIMENZIJA_POLJA / 2, e.getSceneY() - GUI.DIMENZIJA_POLJA / 2 + VISINA_MENU);
        });

        setOnMouseReleased(e -> {
            int x = (int) (e.getSceneX() / GUI.DIMENZIJA_POLJA);
            int y = (int) (e.getSceneY() / GUI.DIMENZIJA_POLJA);
            if(x > 7 || x < 0 || y > 7 || y < 0){
                int[] pozicija = TablaUtils.jednodimenzionalneUDvodimenzionalne[figura.getKoordinata()];
                relocate(pozicija[1] * GUI.DIMENZIJA_POLJA, pozicija[0] * GUI.DIMENZIJA_POLJA + VISINA_MENU);
                return;
            }
            int konverzija = TablaUtils.dvodimenzionalneUJednodimenzionalne[y][x];
            int krajnjaKoordinata = TablaUtils.iz64u119[konverzija];
            Potez potez = Potez.izgradiPotez(Partija.trenutnaPozicija, figura.getKoordinata(), krajnjaKoordinata);
            if (potez.isNullPotez()) {
                int[] pozicija = TablaUtils.jednodimenzionalneUDvodimenzionalne[figura.getKoordinata()];
                relocate(pozicija[1] * GUI.DIMENZIJA_POLJA, pozicija[0] * GUI.DIMENZIJA_POLJA + VISINA_MENU);
                return;
            }
            PrelazPoteza pp = Partija.trenutnaPozicija.getTrenutniIgrac().napraviPotez(potez);
            if (pp.getStatusPoteza().isNelegalan()) {
                int[] pozicija = TablaUtils.jednodimenzionalneUDvodimenzionalne[figura.getKoordinata()];
                relocate(pozicija[1] * GUI.DIMENZIJA_POLJA, pozicija[0] * GUI.DIMENZIJA_POLJA + VISINA_MENU);
                return;
            }

            Partija.odigrajPotez(potez);
        });
    }

    public static SlikaFigure napraviFiguru(Figura figura) {
        TipFigure tip = figura.getTip();
        Boja boja = figura.getBoja();
        int koordinata = figura.getKoordinata();
        switch (tip) {
            case TOP: {
                return new SlikaFigure(figura, boja.isBeli() ? bt : ct, koordinata);
            }
            case PION: {
                return new SlikaFigure(figura, boja.isBeli() ? bp : cp, koordinata);
            }
            case KONJ: {
                return new SlikaFigure(figura, boja.isBeli() ? bn : cn, koordinata);
            }
            case KRALJ: {
                return new SlikaFigure(figura, boja.isBeli() ? bk : ck, koordinata);
            }
            case LOVAC: {
                return new SlikaFigure(figura, boja.isBeli() ? bl : cl, koordinata);
            }
            case KRALJICA: {
                return new SlikaFigure(figura, boja.isBeli() ? bq : cq, koordinata);
            }
        }
        return null;
    }


}
