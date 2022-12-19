package exercise_two;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class exercise_two_app {
    private static final Double MAX_VALUE = 1000000.00;
    private static final String INITAL_MESSAGE = "Calculadora que retornará o menor número de notas e moedas possíveis no qual o valor pode ser decomposto.";

    public static void main(String[] args) {
        System.out.println(INITAL_MESSAGE);
        Scanner scannerValue = new Scanner(System.in);
        String possibleDouble;

        do {
            System.out.println("Qual valor de entrada: ");
            possibleDouble = scannerValue.nextLine();
        } while (Boolean.FALSE.equals(validations(possibleDouble)));

        Double valor = parseStringForDouble(possibleDouble);
        System.out.printf("R$ %.2f \n", valor);
        final List<Double> valuesMoneyDoubles = new ArrayList<>(
                Arrays.asList(100.00, 50.00, 20.00, 10.00, 5.00, 2.00, 1.00, 0.50, 0.25, 0.10, 0.05, 0.01));
        List<Integer> valuesNotesAndCentsIntegers = new ArrayList<>();

        resolveNotesAndCents(valor, valuesMoneyDoubles, valuesNotesAndCentsIntegers);
        resolveMessage(valuesNotesAndCentsIntegers);
        scannerValue.close();
    }

    private static void resolveMessage(List<Integer> valuesNotesAndCentsIntegers) {
        List<String> stringsMoney = new ArrayList<>(Arrays.asList("100.00", "50.00", "20.00", "10.00", "5.00", "2.00",
                "1.00", "0.50", "0.25", "0.10", "0.05", "0.01"));
        String titleMoney = "NOTAS: ";
        String typeMoney = "nota(s) ";
        System.out.println(titleMoney);
        for (int i = 0; i < stringsMoney.size(); i++) {
            if (i == 6) {
                titleMoney = "MOEDAS: ";
                typeMoney = "moeda(s)";
                System.out.println(titleMoney);
            }
            System.out.printf("%d %s de R$ %6s \n", valuesNotesAndCentsIntegers.get(i), typeMoney,
                    stringsMoney.get(i));
        }
    }

    private static void resolveNotesAndCents(Double valor, List<Double> valuesMoneyDoubles,
            List<Integer> valuesNotesAndCentsIntegers) {
        for (Double valueMoney : valuesMoneyDoubles) {
            int nota = 0;
            if (valor >= valueMoney) {
                nota = (int) (valor / valueMoney);
                valor = valor % valueMoney;
            }
            valuesNotesAndCentsIntegers.add(nota);
        }
    }

    private static Boolean validations(String value) {
        return Boolean.FALSE.equals(value.isEmpty()) && Boolean.TRUE.equals(isDouble(value))
                && Boolean.TRUE.equals(checkDouble(parseStringForDouble(value)));
    }

    private static Boolean checkDouble(Double value) {
        return 0 <= value && value <= MAX_VALUE;
    }

    private static Double parseStringForDouble(String value) {
        return Double.parseDouble(value);
    }

    private static Boolean isDouble(String value) {
        Double varDouble = null;
        try {
            varDouble = Double.parseDouble(value);
        } catch (Exception e) {
            System.out.println("O valor que foi digitado não é um valor válido: " + value);
        }
        return Objects.nonNull(varDouble);
    }
}
