class Methods {
    // TRUE - daca toti parametrii sunt corecti (X sau 0 sau -) ; FALSE daca nu toti parametrii sunt corecti
    static boolean correctParameters(int[] x) {
        int isWrong = 0;
        for (int i = 0; i < 9; i++) {

            if (x[i] == 45 || x[i] == 48 || x[i] == 88)
                isWrong += 0;
            else {
                isWrong += 1;
            }
        }
        return (isWrong == 0);
    }

    // Metoda printeaza care sunt parametrii care trebuie schimbati pentru ca jocul sa functioneze
    static void printWrongValues(int[] x) {
        String wrongValues = "";
        int countWrongValues = 0;

        if (x[0] != 45 && x[0] != 48 && x[0] != 88) {
            wrongValues += " upLeft ";
            countWrongValues++;
        }
        if (x[1] != 45 && x[1] != 48 && x[1] != 88) {
            wrongValues += " leftMiddle ";
            countWrongValues++;
        }
        if (x[2] != 45 && x[2] != 48 && x[2] != 88) {
            wrongValues += " upRight ";
            countWrongValues++;
        }
        if (x[3] != 45 && x[3] != 48 && x[3] != 88) {
            wrongValues += " middleLeft ";
            countWrongValues++;
        }
        if (x[4] != 45 && x[4] != 48 && x[4] != 88) {
            wrongValues += " middleMiddle ";
            countWrongValues++;
        }
        if (x[5] != 45 && x[5] != 48 && x[5] != 88) {
            wrongValues += " middleRight ";
            countWrongValues++;
        }
        if (x[6] != 45 && x[6] != 48 && x[6] != 88) {
            wrongValues += " downLeft ";
            countWrongValues++;
        }
        if (x[7] != 45 && x[7] != 48 && x[7] != 88) {
            wrongValues += " downMiddle ";
            countWrongValues++;
        }
        if (x[8] != 45 && x[8] != 48 && x[8] != 88) {
            wrongValues += " downRight ";
            countWrongValues++;
        }
        if (countWrongValues == 1) {
            System.out.println("Ati introdus o valoare necorespunzatoare jocului X si 0! Va rugam verificati valoarea de pe pozitia:" + wrongValues);
        } else
            System.out.println("Ati introdus " + countWrongValues + " valori necorespunzatoare jocului X si 0! Va rugam verificati valorile variabilelor pe pozitiile:" + wrongValues);
    }

    // Metoda calculeaza cate valori de X avem in joc
    private static int countX(int[] x) {
        int countX = 0;
        for (int i = 0; i < 9; i++) {
            if (x[i] == 88) countX++;
        }
        return countX;
    }

    // Metoda calculeaza cate valori de 0 avem in joc
    private static int count0(int[] x) {
        int count0 = 0;
        for (int i = 0; i < 9; i++) {
            if (x[i] == 48) count0++;
        }
        return count0;
    }

    // Metoda calculeaza cate valori necompletate avem in joc
    static int countEmpty(int[] x) {
        int countEmpty = 0;
        for (int i = 0; i < 9; i++) {
            if (x[i] == 45) countEmpty++;
        }
        return countEmpty;
    }

    // TRUE - daca avem mai multi de 0 decat X in joc
    static boolean tooMany0(int[] x) {
        return (count0(x) > countX(x));
    }

    // TRUE - daca avem mai multi de X+1 decat 0 in joc
    static boolean tooManyX(int[] x) {
        return (count0(x) + 1 < countX(x));
    }

    // TRUE - daca se creaza o linie sau o diagonala numai cu 0
    static boolean oWins(int[] x) {
        return ((48 == x[0] && x[0] == x[1] && x[1] == x[2]) || (48 == x[3] && x[3] == x[4] && x[4] == x[5]) || (48 == x[6] && x[6] == x[7] && x[7] == x[8]) || (48 == x[0] && x[0] == x[3] && x[3] == x[6]) || (48 == x[1] && x[1] == x[4] && x[4] == x[7]) || (48 == x[2] && x[2] == x[5] && x[5] == x[8]) || (48 == x[0] && x[0] == x[4] && x[4] == x[8]) || (48 == x[2] && x[2] == x[4] && x[4] == x[6]));
    }

    // TRUE - daca se creaza o linie sau o diagonala numai cu X
    static boolean xWins(int[] x) {
        return ((88 == x[0] && x[0] == x[1] && x[1] == x[2]) || (88 == x[3] && x[3] == x[4] && x[4] == x[5]) || (88 == x[6] && x[6] == x[7] && x[7] == x[8]) || (88 == x[0] && x[0] == x[3] && x[3] == x[6]) || (88 == x[1] && x[1] == x[4] && x[4] == x[7]) || (88 == x[2] && x[2] == x[5] && x[5] == x[8]) || (88 == x[0] && x[0] == x[4] && x[4] == x[8]) || (88 == x[2] && x[2] == x[4] && x[4] == x[6]));
    }

    // TRUE - daca inca nu a castigat nici X nici 0 si nu sunt completate toate valorile
    static boolean unfinishedGame(int[] x) {
        return (countEmpty(x) > 0 && (!oWins(x) && !xWins(x)));
    }

    // TRUE - daca inca nu a castigat nici X nici 0 si sunt completate toate valorile
    static boolean drawGame(int[] x) {
        return (!oWins(x) && !xWins(x));
    }

    // TRUE - daca castiga si x si 0 ceea ce inseamna ca e o pozitie imposibila
    static boolean xAnd0Wins(int[] x) {
        return (oWins(x) && xWins(x));
    }

    // TRUE - daca castiga X dar 0-urile sunt in numar egal cu X ceea ce inseamna ca 0 a completat o valoare dupa ce a castigat X-ul
    static boolean xWinsTooMany0(int[] x) {
        return (xWins(x) && countX(x) == count0(x));
    }

    // TRUE - daca castiga 0 dar X-urile sunt in numar mai mare decat 0-urile ceea ce inseamna ca X a completat o valoare dupa ce a castigat 0-ul
    static boolean oWinsTooManyX(int[] x) {
        return (oWins(x) && countX(x) > count0(x));
    }

    // TRUE - daca se indeplineste una dintre booleanele de mai sus in care am verificat stari de imposibilitate a jocului
    static boolean inconsistentState(int[] x) {
        return (tooMany0(x) || tooManyX(x) || xAnd0Wins(x) || xWinsTooMany0(x) || oWinsTooManyX(x));
    }

}
