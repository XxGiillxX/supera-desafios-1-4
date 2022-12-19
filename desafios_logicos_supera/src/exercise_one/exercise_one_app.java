package exercise_one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class exercise_one_app {
    private static String message = "Digite um número que será a quantidade de números fornecidos \n"
            + "para organização de valores positivos e negativos da seguinte forma: Primeiro os pares e segundo os ímpares. \n"
            + "Sendo que deverão ser apresentados os pares em ordem crescente e depois os ímpares \n"
            + "em ordem decrescente.\n";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String amountTimes = "";
        System.out.println(message);

        do {
            System.out.println("Digite um número que será a quantidade de interação: ");
            amountTimes = scan.nextLine();
        } while (Boolean.FALSE.equals(validations(amountTimes)));

        List<Long> numbers = new ArrayList<>();
        Long amountTimesFormatted = parseStringForLong(amountTimes);
        String possibleNumber = "";
        Long number = null;
        for (int i = 0; i < amountTimesFormatted; i++) {
            do {
                System.out.printf("\nDigite o %dº número inteiro maior que 1: ", (i + 1));
                possibleNumber = scan.nextLine();
            } while (Boolean.FALSE.equals(validations(possibleNumber)));
            number = parseStringForLong(possibleNumber);
            numbers.add(number);
        }
        numbers = refactoredList(numbers);
        System.err.println("\n####################################\n");
        for (Long numberForEach : numbers) {
            System.out.println(numberForEach);
        }

        scan.close();
    }

    private static List<Long> refactoredList(List<Long> numbers) {
        List<Long> allNumbers = new ArrayList<>();
        numbers.forEach(num -> {
            if (num % 2 == 0) {
                allNumbers.add(num);
            }
        });
        numbers.removeIf(n -> n % 2 == 0);
        Collections.sort(allNumbers);
        numbers.sort(Collections.reverseOrder());
        allNumbers.addAll(numbers);
        return allNumbers;
    }

    public static Boolean validations(String var) {
        return Boolean.FALSE.equals(var.isEmpty()) && Boolean.TRUE.equals(isInteger(var))
                && Boolean.TRUE.equals(checkNumber(parseStringForLong(var)));
    }

    public static Long parseStringForLong(String amountTimes) {
        return Long.parseLong(amountTimes);
    }

    public static Boolean checkNumber(Long number) {
        return 1 < number && number <= Math.pow(10, 5);
    }

    public static boolean isInteger(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
