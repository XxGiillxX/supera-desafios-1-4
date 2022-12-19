package exercise_four;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exercise_four_app {
    private static final String REGEX = "^[A-Z ]{2,100}$";
    private static final String INITAL_MESSAGE = "\nInversor de texto com as seguintes regas: será fornecido um "
            + "número inicial \nque indica a quantidade de casos de teste, a frase colocada deverá conter no mínimo 2 \ne "
            + "no máximo 100 caracteres de letras maiúsculas e espaços que serão desembaralhadas.\n";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testNumber = 0;
        String number = "";
        System.out.println(INITAL_MESSAGE);
        do {
            System.out.println("Digite o número de testes: ");
            number = scan.nextLine();
        } while (Boolean.FALSE.equals(validations(number)));

        testNumber = Integer.parseInt(number);
        List<String> phrases = new ArrayList<>();
        String phrase = "";

        for (int i = 0; i < testNumber; i++) {

            do {
                System.out.printf("Digite a %dº frase: \n", (i + 1));
                phrase = scan.nextLine();
            } while (Boolean.FALSE.equals(phrase.matches(REGEX) && (phrase.length() % 2 == 0)));

            phrases.add(unscrambleSentence(phrase));

        }
        for (String phraseFormatted : phrases) {
            System.out.println(phraseFormatted);
        }
    }

    private static String unscrambleSentence(String phrase) {
        int half = phrase.length() / 2;
        String value = "";
        for (int i = half - 1; i >= 0; i--) {
            value += phrase.charAt(i);
        }

        for (int i = phrase.length() - 1; i >= half; i--) {
            value += phrase.charAt(i);
        }
        return value;
    }

    private static Boolean validations(String value) {
        return Boolean.FALSE.equals(value.isEmpty()) && Boolean.TRUE.equals(isInteger(value));
    }

    private static boolean isInteger(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
