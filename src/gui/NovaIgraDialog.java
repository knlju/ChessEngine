package gui;

import engine.tabla.TablaBuilder;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NovaIgraDialog {

    private static final int WIDTH = 250;
    private static final int PADDING = 15;
    private static final int SPACING = 15;

    RadioButton crni,beli,easy,medium; // ,hard;
    HBox boja,tezina;
    ToggleGroup tgb,tgt;
    Button zapocni;

    public void display(){
        Stage w = new Stage();
        VBox layout = new VBox();
        layout.setPrefWidth(WIDTH);
        layout.setSpacing(SPACING);
        layout.setPadding(new Insets(PADDING,PADDING,PADDING,PADDING));
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        w.setScene(scene);
        w.setTitle("Nova igra");

        crni = new RadioButton("Crni");
        beli = new RadioButton("Beli");

        beli.setSelected(true);

        tgb = new ToggleGroup();

        crni.setToggleGroup(tgb);
        beli.setToggleGroup(tgb);

        easy = new RadioButton("Easy");
        medium = new RadioButton("Harder");
//        medium = new RadioButton("Medium");
//        hard = new RadioButton("Hard");

        medium.setSelected(true);

        tgt = new ToggleGroup();

        easy.setToggleGroup(tgt);
        medium.setToggleGroup(tgt);
//        hard.setToggleGroup(tgt);

        zapocni = new Button("Zapocni novu igru");

        zapocni.setOnAction(e->{
            Partija.trenutnaPozicija = new TablaBuilder().napraviStandardnuPocetnuPoziciju();
//            Smanjena tezina zbog predugog vremena pretrage
//            Partija.dubinaPretrage = easy.isSelected() ? Partija.Tezina.EASY.dubina : (medium.isSelected() ? Partija.Tezina.MEDIUM.dubina : Partija.Tezina.HARD.dubina);
            Partija.dubinaPretrage = easy.isSelected() ? Partija.Tezina.EASY.dubina : Partija.Tezina.MEDIUM.dubina;
            if (crni.isSelected()){
                Partija.izracunajIIzvrsiNajboljiPotez();
            }
            GUI.napuniTablu();
            w.close();
        });

        boja=new HBox();
        boja.setSpacing(SPACING);
        boja.setAlignment(Pos.CENTER);
        boja.getChildren().addAll(crni,beli);
        tezina=new HBox();
        tezina.setSpacing(SPACING);
        tezina.setAlignment(Pos.CENTER);
        tezina.getChildren().addAll(easy,medium); // ,hard);
        layout.getChildren().addAll(boja,tezina,zapocni);

        w.showAndWait();
    }

}
