package org.example.app.utils;

import java.util.Scanner;

public class OptionValidator {

    // Валидация ввода номера опции действия
    public static int validateOptionInput(Scanner scanner) {

        // Массив для выбора действий
        int[] options = {0, 1, 2};

        while (!scanner.hasNextInt()) {
            String str = scanner.nextLine().trim();
            System.out.printf(Constants.NAN_NUMBER_MSG, str);
        }

        int inputData = scanner.nextInt();

        while (!contains(options, inputData)) {
            System.out.println(Constants.NO_SUCH_OPTION_MSG);
            while (!scanner.hasNextInt()) {
                String str = scanner.next().trim();
                System.out.printf(Constants.NAN_NUMBER_MSG, str);
            }
            inputData = scanner.nextInt();
        }
        return inputData;
    }

    // Проверка наличия ввода в массиве выбора
    // действий через contains()
    public static boolean contains(final int[] array, final int value) {
        boolean result = false;
        for (int i : array) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }
}
