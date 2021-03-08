package gui;

import engine.pretraga.AlphaBetaMax;
import engine.pretraga.MiniMax;
import engine.tabla.Tabla;
import engine.tabla.TablaBuilder;
import engine.tabla.potez.Potez;
import javafx.application.Platform;
import javafx.scene.control.Alert;

public class Partija {

    public static int dubinaPretrage = Tezina.MEDIUM.dubina;

    public static AlphaBetaMax engine = new AlphaBetaMax();

    public static Tabla trenutnaPozicija = new TablaBuilder().napraviStandardnuPocetnuPoziciju();
    public static boolean azuriraj = true;

    public static void izracunajIIzvrsiNajboljiPotez() {
        new Thread(() -> {
            Potez najboljiPotez = engine.izracunaj(trenutnaPozicija, dubinaPretrage);
            Platform.runLater(() -> {
                if (azuriraj) {
                    izvrsiPotez(najboljiPotez);
                    isKraj();
                }
            });
        }).start();
    }

    public static void izvrsiPotez(Potez potez) {
        trenutnaPozicija = potez.izvrsi();
        GUI.napuniTablu();
    }

    public static void odigrajPotez(Potez potez) {
        azuriraj = true;
        izvrsiPotez(potez);
        if (!isKraj())
            izracunajIIzvrsiNajboljiPotez();
    }

    public static boolean isKraj() {
        if (trenutnaPozicija.getTrenutniIgrac().isUMatu()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Igra je zavrsena");
            alert.setHeaderText("Igra je zavrsena matom!");
            alert.setContentText("Pobednik je " + (trenutnaPozicija.getTrenutniIgrac().getProtivnik().getBoja().isBeli() ? "beli" : "crni"));
            alert.showAndWait();
            return true;
        }
        if (trenutnaPozicija.getTrenutniIgrac().isUPatu()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Igra je zavrsena");
            alert.setHeaderText("Igra je zavrsena patom!");
            alert.setContentText("Nereseno");
            alert.showAndWait();
            return true;
        }
        return false;
    }

    public static void vratiNaPoslednjiIgracevPotez() {
        if (Partija.trenutnaPozicija.getBrojPoteza() > 2) {
            Partija.trenutnaPozicija = Partija.trenutnaPozicija.getPrelazniPotez().getPozicija();
            GUI.napuniTablu();
            azuriraj = false;
        }
    }

    public enum Tezina {
        EASY(3),
        MEDIUM(4);
//        HARD(5);          Predugo za prezentaciju

        public int dubina;

        Tezina(int dubina){
            this.dubina = dubina;
        }
    }
}
