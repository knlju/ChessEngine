package gui;

import engine.tabla.figure.Boja;
import engine.tabla.figure.Figura;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class GUI extends Application {

    public static final int DIMENZIJA_POLJA = 80;
    public static final int BROJ_REDOVA = 8;
    public static final int BROJ_KOLONA = 8;
    public static final int VISINA_MENU = 25;
    public static final BorderPane root = new BorderPane();

    public static ArrayList<ImageView> figure = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(napraviSadrzaj());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.setTitle("Program za sah");
        primaryStage.show();
    }

    private Parent napraviSadrzaj() {
        root.setPrefSize(DIMENZIJA_POLJA * BROJ_KOLONA, DIMENZIJA_POLJA * BROJ_REDOVA + VISINA_MENU);
        dodajMenu();
        dodajPolja();
        napuniTablu();
        return root;
    }

    private static void dodajPolja() {
        for (int i = 0; i < BROJ_KOLONA; i++) {
            for (int j = 0; j < BROJ_REDOVA; j++) {
                root.getChildren().add(new Polje(i, j, (i + j) % 2 == 1 ? Boja.BELA : Boja.CRNA));
            }
        }
    }

    private static void dodajMenu() {
        Menu igra = new Menu("Igra");
        MenuItem novaIgra = new MenuItem("Nova igra...");
        novaIgra.setOnAction(e -> new NovaIgraDialog().display());
        MenuItem vratiPotez = new MenuItem("Vrati potez");
        vratiPotez.setOnAction(e -> Partija.vratiNaPoslednjiIgracevPotez());
        igra.getItems().addAll(novaIgra, vratiPotez);
        MenuBar mb = new MenuBar();
        mb.getMenus().addAll(igra);
        root.setTop(mb);
    }

    public static void napuniTablu() {
        for (ImageView fig :
                figure) {
            root.getChildren().remove(fig);
        }
        for (Figura figura : Partija.trenutnaPozicija.getBeleFigure()) {
            ImageView img = SlikaFigure.napraviFiguru(figura);
            figure.add(img);
            root.getChildren().add(img);
        }
        for (Figura figura : Partija.trenutnaPozicija.getCrneFigure()) {
            ImageView img = SlikaFigure.napraviFiguru(figura);
            figure.add(img);
            root.getChildren().add(img);
        }
    }

}
