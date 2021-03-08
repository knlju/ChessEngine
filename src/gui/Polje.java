package gui;

import engine.tabla.figure.Boja;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static gui.GUI.VISINA_MENU;

public class Polje extends Rectangle {

    private final String bela = "#6c9d41";
    private final String crna = "#e9eacf";

    public Polje(int x, int y, Boja boja) {
        setWidth(GUI.DIMENZIJA_POLJA);
        setHeight(GUI.DIMENZIJA_POLJA);

        relocate(x * GUI.DIMENZIJA_POLJA, y * GUI.DIMENZIJA_POLJA + VISINA_MENU);
        setFill(boja.isBeli() ? Color.valueOf(bela) : Color.valueOf(crna));
    }
}
