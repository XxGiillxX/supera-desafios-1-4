package exercise_three;

import java.util.Objects;
import java.util.Scanner;

public class exercise_three_app {
    private static final String MESSAGE_ERROR = "A entrada não é um número inteiro válido, tente novamente.";

    public static void main(String[] args) {
        Scanner value = new Scanner(System.in);
        String arrayPosition;
        String targetNumber;
        do {
            System.out.println("Digite o tamanho do array: ");
            arrayPosition = value.nextLine();
        } while (Boolean.FALSE.equals(validations(arrayPosition)));

        int arrayPositions = parseStringForInteger(arrayPosition);
        int target = 0;
        int count = 0;
        int[] array = new int[arrayPositions];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        do {
            System.out.println("Digite o número alvo: ");
            targetNumber = value.nextLine();
        } while (Boolean.FALSE.equals(isIntegerPositiveOrNegative(targetNumber)));
        target = parseStringForInteger(targetNumber);

        for (int i = 0; i < array.length; i++) {
            int valuePosition = array[i];
            for (int j = 0; j < array.length; j++) {
                if ((valuePosition - array[j]) == target) {
                    count++;
                }
            }
        }
        System.out.println(count);
        value.close();

    }

    private static Boolean validations(String var) {
        return Boolean.FALSE.equals(var.isEmpty()) && Boolean.TRUE.equals(isInteger(var));
    }

    private static Integer parseStringForInteger(String amountTimes) {
        return Integer.parseInt(amountTimes);
    }

    private static boolean isInteger(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static Boolean isIntegerPositiveOrNegative(String s) {
        Integer value = null;
        try {
            value = Integer.parseInt(s);
        } catch (Exception e) {
            System.out.println(MESSAGE_ERROR);
        }
        return Objects.nonNull(value);
    }
}
