import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        char upLeft = '0';
        char upMiddle = '0';
        char upRight = '0';
        char middleLeft = '0';
        char middleMiddle = 'X';
        char middleRight = 'X';
        char downLeft = 'X';
        char downMiddle = '0';
        char downRight = 'X';

        int[] x = {upLeft, upMiddle, upRight, middleLeft, middleMiddle, middleRight, downLeft, downMiddle, downRight};
        System.out.println(Arrays.toString(x));


        //se printeazaz tabla de joc ca sa fie mai usor de urmarit

        System.out.println("+---+---+---+");
        System.out.println("| " + upLeft + " | " + upMiddle + " | " + upRight + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + middleLeft + " | " + middleMiddle + " | " + middleRight + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + downLeft + " | " + downMiddle + " | " + downRight + " |");
        System.out.println("+---+---+---+");

        if (!Methods.correctParameters(x)) {
            Methods.printWrongValues(x);
        } else {
            if (Methods.countEmpty(x) == 9) {
                System.out.println("Incepeti prin a completa variabilele din joc. ");
            } else {
                if (Methods.inconsistentState(x)) {
                    if (Methods.tooMany0(x)) {
                        System.out.println("Numarul de 0-uri nu poate depasi numarul de X-uri. Recompletati variabilele in consecinta!");
                    } else if (Methods.tooManyX(x)) {
                        System.out.println("Numarul de X-uri nu poate depasi numarul de 0-uri cu mai mult de 1. Recompletati variabilele in consecinta.");
                    } else if (Methods.xAnd0Wins(x)) {
                        System.out.println("Ati completat gresit jocul. Nu este posibil sa existe 2 castigatori.");
                    } else if (Methods.xWinsTooMany0(x)) {
                        System.out.println("Situatia de fata este una imposibila. X a castigat cu o mutare inainte!");
                    } else if (Methods.oWinsTooManyX(x)) {
                        System.out.println("Situatia de fata este una imposibila. O a castigat cu o mutare inainte!");
                    }

                } else {
                    if (Methods.countEmpty(x) > 4) {
                        System.out.println("Completati in continuare variabilele, nu sunt destule X-uri sau 0-uri pentru a se forma o linie sau diagonala cu acceasi valoare.");
                    } else {
                        if (Methods.unfinishedGame(x)) {
                            System.out.println("Completati in continuare variabilele pana toate variabilele au atribuite X-uri sau 0-uri sau pana se castiga jocul.");
                        }
                        if (Methods.drawGame(x)) {
                            System.out.println("Remiza");
                        }
                        if (Methods.xWins(x)) {
                            System.out.println("X a castigat!");
                        }
                        if (Methods.oWins(x)) {
                            System.out.println("0 a castigat!");
                        }
                    }
                }
            }
        }
    }

}
