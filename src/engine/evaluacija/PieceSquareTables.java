package engine.evaluacija;

public class PieceSquareTables {

    public static int[] crniPion = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 5, 10, 10, -50, -75, 10, 10, 5, 0,
            0, 0, 9, -10, 10, 10, -10, 10, 0, 0,
            0, 0, 0, 0, 20, 50, 0, 0, 0, 0,
            0, 5, 5, 10, 25, 25, 10, 5, 5, 0,
            0, 10, 10, 20, 30, 30, 20, 10, 10, 0,
            0, 50, 50, 50, 50, 50, 50, 50, 50, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] crniKonj = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, -50, -30, -30, -30, -30, -30, -30, -50, 0,
            0, -40, -20, 0, 5, 5, 0, -20, -40, 0,
            0, -30, 5, 10, 15, 15, 10, 5, -30, 0,
            0, -30, 0, 15, 20, 20, 15, 0, -30, 0,
            0, -30, 5, 15, 20, 20, 15, 5, -30, 0,
            0, -30, 0, 10, 15, 15, 10, 0, -30, 0,
            0, -40, -20, 0, 0, 0, 0, -20, -40, 0,
            0, -50, -40, -30, -30, -30, -30, -40, -50, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] crniLovac = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, -20, -10, -10, -10, -10, -10, -10, -20, 0,
            0, -10, 5, 0, 0, 0, 0, 50, -10, 0,
            0, -10, 10, 10, 10, 10, 10, 10, -10, 0,
            0, -10, 0, 10, 10, 10, 10, 0, -10, 0,
            0, -10, 5, 5, 10, 10, 5, 5, -10, 0,
            0, -10, 0, 5, 10, 10, 5, 0, -10, 0,
            0, -10, 0, 0, 0, 0, 0, 0, -10, 0,
            0, -20, -10, -10, -10, -10, -10, -10, -20, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] crniTop = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 5, 5, 0, 0, 0, 0,
            0, -5, 0, 0, 0, 0, 0, 0, -5, 0,
            0, -5, 0, 0, 0, 0, 0, 0, -5, 0,
            0, -5, 0, 0, 0, 0, 0, 0, -5, 0,
            0, -5, 0, 0, 0, 0, 0, 0, -5, 0,
            0, -5, 0, 0, 0, 0, 0, 0, -5, 0,
            0, 5, 10, 10, 10, 10, 10, 10, 5, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] crnaKraljica = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, -20, -10, -10, -5, -5, -10, -10, -20, 0,
            0, -10, 0, 0, 0, 0, 0, 0, -10, 0,
            0, -10, 5, 5, 5, 5, 5, 0, -10, 0,
            0, 0, 0, 5, 5, 5, 5, 0, -5, 0,
            0, -5, 0, 5, 5, 5, 5, 0, -5, 0,
            0, -10, 0, 5, 5, 5, 5, 0, -10, 0,
            0, -10, 0, 0, 0, 0, 0, 0, -10, 0,
            0, -20, -10, -10, -5, -5, -10, -10, -20, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] crniKralj = {

            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            20, 30, 10, 0, 0, 10, 30, 20, 0, 0,
            20, 20, 0, 0, 0, 0, 20, 20, 0, 0,
            -10, -20, -20, -20, -20, -20, -20, -10, 0, 0,
            -20, -30, -30, -40, -40, -30, -30, -20, 0, 0,
            -30, -40, -40, -50, -50, -40, -40, -30, 0, 0,
            -30, -40, -40, -50, -50, -40, -40, -30, 0, 0,
            -30, -40, -40, -50, -50, -40, -40, -30, 0, 0,
            -30, -40, -40, -50, -50, -40, -40, -30, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] beliPion = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            50, 50, 50, 50, 50, 50, 50, 50, 0, 0,
            10, 10, 20, 30, 30, 20, 10, 10, 0, 0,
            5, 5, 10, 25, 25, 10, 5, 5, 0, 0,
            0, 0, 0, 20, 20, 0, 0, 0, 0, 0,
            5, 9, -10, 0, 0, -10, 10, 0, 0, 0,
            5, 10, 10, -50, -50, 10, 10, 5, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0

    };

    public static int[] beliKonj = {

            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            -50, -40, -30, -30, -30, -30, -40, -50, 0, 0,
            -40, -20, 0, 0, 0, 0, -20, -40, 0, 0,
            -30, 0, 10, 15, 15, 10, 0, -30, 0, 0,
            -30, 5, 15, 20, 20, 15, 5, -30, 0, 0,
            -30, 0, 15, 20, 20, 15, 0, -30, 0, 0,
            -30, 5, 10, 15, 15, 10, 5, -30, 0, 0,
            -40, -20, 0, 5, 5, 0, -20, -40, 0, 0,
            -50, -30, -30, -30, -30, -30, -30, -50, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] beliLovac = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            -20, -10, -10, -10, -10, -10, -10, -20, 0, 0,
            -10, 0, 0, 0, 0, 0, 0, -10, 0, 0,
            -10, 0, 5, 10, 10, 5, 0, -10, 0, 0,
            -10, 5, 5, 10, 10, 5, 5, -10, 0, 0,
            -10, 0, 10, 10, 10, 10, 0, -10, 0, 0,
            -10, 10, 10, 10, 10, 10, 10, -10, 0, 0,
            -10, 5, 0, 0, 0, 0, 50, -10, 0, 0,
            -20, -10, -10, -10, -10, -10, -10, -20, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] beliTop = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            5, 10, 10, 10, 10, 10, 10, 5, 0, 0,
            -5, 0, 0, 0, 0, 0, 0, -5, 0, 0,
            -5, 0, 0, 0, 0, 0, 0, -5, 0, 0,
            -5, 0, 0, 0, 0, 0, 0, -5, 0, 0,
            -5, 0, 0, 0, 0, 0, 0, -5, 0, 0,
            -5, 0, 0, 0, 0, 0, 0, -5, 0, 0,
            0, 0, 0, 5, 5, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] belaKraljica = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            -20, -10, -10, -5, -5, -10, -10, -20, 0, 0,
            -10, 0, 0, 0, 0, 0, 0, -10, 0, 0,
            -10, 5, 5, 5, 5, 5, 0, -10, 0, 0,
            0, 0, 5, 5, 5, 5, 0, -5, 0, 0,
            -5, 0, 5, 5, 5, 5, 0, -5, 0, 0,
            -10, 0, 5, 5, 5, 5, 0, -10, 0, 0,
            -10, 0, 0, 0, 0, 0, 0, -10, 0, 0,
            -20, -10, -10, -5, -5, -10, -10, -20, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] beliKralj = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            -30, -40, -40, -50, -50, -40, -40, -30, 0, 0,
            -30, -40, -40, -50, -50, -40, -40, -30, 0, 0,
            -30, -40, -40, -50, -50, -40, -40, -30, 0, 0,
            -30, -40, -40, -50, -50, -40, -40, -30, 0, 0,
            -20, -30, -30, -40, -40, -30, -30, -20, 0, 0,
            -10, -20, -20, -20, -20, -20, -20, -10, 0, 0,
            20, 20, 0, 0, 0, 0, 20, 20, 0, 0,
            20, 30, 10, 0, 0, 10, 30, 20, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] crniPionEndgame = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            20, 20, 20, 20, 20, 20, 20, 20, 0, 0,
            40, 40, 40, 40, 40, 40, 40, 40, 0, 0,
            50, 50, 50, 50, 50, 50, 50, 50, 0, 0,
            200, 200, 200, 200, 200, 200, 200, 200, 0, 0,
            500, 500, 500, 500, 500, 500, 500, 500, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] crniKonjEndgame = {

            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            -50, -40, -30, -30, -30, -30, -40, -50, 0, 0,
            -40, -20, 0, 5, 5, 0, -20, -40, 0, 0,
            -30, 5, 10, 15, 15, 10, 5, -30, 0, 0,
            -30, 0, 15, 20, 20, 15, 0, -30, 0, 0,
            -30, 5, 15, 20, 20, 15, 5, -30, 0, 0,
            -30, 0, 10, 15, 15, 10, 0, -30, 0, 0,
            -40, -20, 0, 0, 0, 0, -20, -40, 0, 0,
            -50, -40, -30, -30, -30, -30, -40, -50, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] crniLovacEndgame = {

            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            -20, -10, -10, -10, -10, -10, -10, -20, 0, 0,
            -10, 5, 0, 0, 0, 0, 5, -10, 0, 0,
            -10, 10, 10, 10, 10, 10, 10, -10, 0, 0,
            -10, 0, 10, 10, 10, 10, 0, -10, 0, 0,
            -10, 5, 5, 10, 10, 5, 5, -10, 0, 0,
            -10, 0, 5, 10, 10, 5, 0, -10, 0, 0,
            -10, 0, 0, 0, 0, 0, 0, -10, 0, 0,
            -20, -10, -10, -10, -10, -10, -10, -20, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] crniTopEndgame = {

            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            10, 10, 10, 10, 10, 10, 10, 10, 0, 0,
            20, 20, 20, 20, 20, 20, 20, 20, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] crnaKraljicaEndgame = {

            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            -20, -10, -10, -5, -5, -10, -10, -20, 0, 0,
            -10, 0, 0, 0, 0, 0, 0, -10, 0, 0,
            -10, 5, 5, 5, 5, 5, 0, -10, 0, 0,
            0, 0, 5, 5, 5, 5, 0, -5, 0, 0,
            -5, 0, 5, 5, 5, 5, 0, -5, 0, 0,
            -10, 0, 5, 5, 5, 5, 0, -10, 0, 0,
            -10, 0, 0, 0, 0, 0, 0, -10, 0, 0,
            -20, -10, -10, -5, -5, -10, -10, -20, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] crniKraljEndgame = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 2, 4, 4, 2, 0, 0, 0, 0,
            0, 0, 5, 10, 10, 5, 0, 0, 0, 0,
            5, 5, 5, 10, 10, 5, 5, 5, 0, 0,
            20, 20, 20, 20, 20, 20, 20, 20, 0, 0,
            50, 50, 50, 50, 50, 50, 50, 50, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] beliPionEndgame = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            500, 500, 500, 500, 500, 500, 500, 500, 0, 0,
            200, 200, 200, 200, 200, 200, 200, 200, 0, 0,
            50, 50, 50, 50, 50, 50, 50, 50, 0, 0,
            40, 40, 40, 40, 40, 40, 40, 40, 0, 0,
            20, 20, 20, 20, 20, 20, 20, 20, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] beliKonjEndgame = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            -50, -40, -30, -30, -30, -30, -40, -50, 0, 0,
            -40, -20, 0, 0, 0, 0, -20, -40, 0, 0,
            -30, 0, 10, 15, 15, 10, 0, -30, 0, 0,
            -30, 5, 15, 20, 20, 15, 5, -30, 0, 0,
            -30, 0, 15, 20, 20, 15, 0, -30, 0, 0,
            -30, 5, 10, 15, 15, 10, 5, -30, 0, 0,
            -40, -20, 0, 5, 5, 0, -20, -40, 0, 0,
            -50, -40, -30, -30, -30, -30, -40, -50, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] beliLovacEndgame = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, -20, -10, -10, -10, -10, -10, -10, -20, 0,
            0, -10, 0, 0, 0, 0, 0, 0, -10, 0,
            0, -10, 0, 5, 10, 10, 5, 0, -10, 0,
            0, -10, 5, 5, 10, 10, 5, 5, -10, 0,
            0, -10, 0, 10, 10, 10, 10, 0, -10, 0,
            0, -10, 10, 10, 10, 10, 10, 10, -10, 0,
            0, -10, 5, 0, 0, 0, 0, 5, -10, 0,
            0, -20, -10, -10, -10, -10, -10, -10, -20, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] beliTopEndgame = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 20, 20, 20, 20, 20, 20, 20, 20, 0,
            0, 10, 10, 10, 10, 10, 10, 10, 10, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

//            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,

    public static int[] belaKraljicaEndgame = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, -20, -10, -10, -5, -5, -10, -10, -20, 0,
            0, -10, 0, 0, 0, 0, 0, 0, -10, 0,
            0, -10, 5, 5, 5, 5, 5, 0, -10, 0,
            0, 0, 0, 5, 5, 5, 5, 0, -5, 0,
            0, -5, 0, 5, 5, 5, 5, 0, -5, 0,
            0, -10, 0, 5, 5, 5, 5, 0, -10, 0,
            0, -10, 0, 0, 0, 0, 0, 0, -10, 0,
            0, -20, -10, -10, -5, -5, -10, -10, -20, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] beliKraljEndgame = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 50, 50, 50, 50, 50, 50, 50, 50, 0,
            0, 20, 20, 20, 20, 20, 20, 20, 20, 0,
            0, 5, 5, 5, 10, 10, 5, 5, 5, 0,
            0, 0, 0, 5, 10, 10, 5, 0, 0, 0,
            0, 0, 0, 2, 4, 4, 2, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] crnaKraljicaOpening = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, -10, -10, -10, -10, 25, -10, -10, -10, 0,
            0, -10, -10, -10, -10, -10, -10, -10, -10, 0,
            0, -10, -10, -10, -10, -10, -10, -10, -10, 0,
            0, -10, -10, -10, -10, -10, -10, -10, -10, 0,
            0, -10, -10, -10, -10, -10, -10, -10, -10, 0,
            0, -10, -10, -10, -10, -10, -10, -10, -10, 0,
            0, -10, -10, -10, -10, -10, -10, -10, -10, 0,
            0, -10, -10, -10, -10, -10, -10, -10, -10, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] belaKraljicaOpening = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, -10, -10, -10, -10, -10, -10, -10, -10, 0,
            0, -10, -10, -10, -10, -10, -10, -10, -10, 0,
            0, -10, -10, -10, -10, -10, -10, -10, -10, 0,
            0, -10, -10, -10, -10, -10, -10, -10, -10, 0,
            0, -10, -10, -10, -10, -10, -10, -10, -10, 0,
            0, -10, -10, -10, -10, -10, -10, -10, -10, 0,
            0, -10, -10, -10, -10, -10, -10, -10, -10, 0,
            0, -10, -10, -10, -10, 25, -10, -10, -10, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

}
