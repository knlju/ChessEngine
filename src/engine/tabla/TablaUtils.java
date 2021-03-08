package engine.tabla;

import engine.tabla.potez.Potez;

import java.util.ArrayList;
import java.util.List;

public class TablaUtils {

    public static boolean [] validnostPolja = {
            false,false,false,false,false,false,false,false,false,false,
            false,false,false,false,false,false,false,false,false,false,
            false, true, true, true, true, true, true, true, true,false,
            false, true, true, true, true, true, true, true, true,false,
            false, true, true, true, true, true, true, true, true,false,
            false, true, true, true, true, true, true, true, true,false,
            false, true, true, true, true, true, true, true, true,false,
            false, true, true, true, true, true, true, true, true,false,
            false, true, true, true, true, true, true, true, true,false,
            false, true, true, true, true, true, true, true, true,false,
            false,false,false,false,false,false,false,false,false,false,
            false,false,false,false,false,false,false,false,false,false
    };

    public static String [] kodiranaPolja = {
            "",   "",   "",   "",   "",   "",   "",   "",   "","",
            "",   "",   "",   "",   "",   "",   "",   "",   "","",
            "", "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8","",
            "", "a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7","",
            "", "a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6","",
            "", "a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5","",
            "", "a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4","",
            "", "a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3","",
            "", "a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2","",
            "", "a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1","",
            "",   "",   "",   "",   "",   "",   "",   "",   "","",
            "",   "",   "",   "",   "",   "",   "",   "",   "",""
    };

    public static int [] koordinate = {
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1
            -1,  0,  1,  2,  3,  4,  5,  6,  7, -1
            -1,  8,  9, 10, 11, 12, 13, 14, 15, -1
            -1, 16, 17, 18, 19, 20, 21, 22, 23, -1
            -1, 24, 25, 26, 27, 28, 29, 30, 31, -1
            -1, 32, 33, 34, 35, 36, 37, 38, 39, -1
            -1, 40, 41, 42, 43, 44, 45, 46, 47, -1
            -1, 48, 49, 50, 51, 52, 53, 54, 55, -1
            -1, 56, 57, 58, 59, 60, 61, 62, 63, -1
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1
    };

    public static int [][] jednodimenzionalneUDvodimenzionalne  = {
            {-1}, {-1}, {-1}, {-1}, {-1}, {-1}, {-1}, {-1}, {-1}, {-1},
            {-1}, {-1}, {-1}, {-1}, {-1}, {-1}, {-1}, {-1}, {-1}, {-1},
            {-1}, {0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{0,6},{0,7},{-1},
            {-1}, {1,0},{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7},{-1},
            {-1}, {2,0},{2,1},{2,2},{2,3},{2,4},{2,5},{2,6},{2,7},{-1},
            {-1}, {3,0},{3,1},{3,2},{3,3},{3,4},{3,5},{3,6},{3,7},{-1},
            {-1}, {4,0},{4,1},{4,2},{4,3},{4,4},{4,5},{4,6},{4,7},{-1},
            {-1}, {5,0},{5,1},{5,2},{5,3},{5,4},{5,5},{5,6},{5,7},{-1},
            {-1}, {6,0},{6,1},{6,2},{6,3},{6,4},{6,5},{6,6},{6,7},{-1},
            {-1}, {7,0},{7,1},{7,2},{7,3},{7,4},{7,5},{7,6},{7,7},{-1},
            {-1}, {-1}, {-1}, {-1}, {-1}, {-1}, {-1}, {-1}, {-1}, {-1},
            {-1}, {-1}, {-1}, {-1}, {-1}, {-1}, {-1}, {-1}, {-1}, {-1}
    };

    public static int [][] dvodimenzionalneUJednodimenzionalne = {
            {0, 1 , 2, 3, 4, 5, 6, 7},
            {8, 9, 10,11,12,13,14,15},
            {16,17,18,19,20,21,22,23},
            {24,25,26,27,28,29,30,31},
            {32,33,34,35,36,37,38,39},
            {40,41,42,43,44,45,46,47},
            {48,49,50,51,52,53,54,55},
            {56,57,58,59,60,61,62,63}
    };

    public static int [] iz64u119 = {
            21, 22, 23, 24, 25, 26, 27, 28,
            31, 32, 33, 34, 35, 36, 37, 38,
            41, 42, 43, 44, 45, 46, 47, 48,
            51, 52, 53, 54, 55, 56, 57, 58,
            61, 62, 63, 64, 65, 66, 67, 68,
            71, 72, 73, 74, 75, 76, 77, 78,
            81, 82, 83, 84, 85, 86, 87, 88,
            91, 92, 93, 94, 95, 96, 97, 98
    };

    public static int [] iz120u64 = {
            0,	0,	0,	0,	0,	0,	0,	0,	0,	0,
            0,	0,	0,	0,	0,	0,	0,	0,	0,	0,
            0,	0,	1,	2,	3,	4,	5,	6,	7,	0,
            0,	8,	9,	10,	11,	12,	13,	14,	15,	0,
            0,	16,	17,	18,	19,	20,	21,	22,	23,	0,
            0,	24,	25,	26,	27,	28,	29,	30,	31,	0,
            0,	32,	33,	34,	35,	36,	37,	38,	39,	0,
            0,	40,	41,	42,	43,	44,	45,	46,	47,	0,
            0,	48,	49,	50,	51,	52,	53,	54,	55,	0,
            0,	56,	57,	58,	59,	60,	61,	62,	63,	0,
            0,	0,	0,	0,	0,	0,	0,	0,	0,	0,
            0,	0,	0,	0,	0,	0,	0,	0,	0,	0
    };

    public static boolean [] promocijaBelog = {
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false,  true,  true,  true,  true,  true,  true,  true,  true, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false
    };

    public static boolean [] promocijaCrnog = {
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false,  true,  true,  true,  true,  true,  true,  true,  true, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false
    };


    public static List<Potez> poslednjihNPoteza(final Tabla tabla, int N) {
        final List<Potez> poslednjiPotezi = new ArrayList<>();
        Potez trenutniPotez = tabla.getPrelazniPotez();
        int i = 0;
        while(trenutniPotez.isNullPotez() && i < N) {
            poslednjiPotezi.add(trenutniPotez);
            trenutniPotez = trenutniPotez.getPozicija().getPrelazniPotez();
            i++;
        }
        return poslednjiPotezi;
    }

    public static int brojPoljaNaTabli = 120;

}
