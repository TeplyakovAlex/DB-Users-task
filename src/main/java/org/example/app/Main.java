package org.example.app;

import org.example.app.services.ReadAlphabetService;
import org.example.app.services.ReadAscService;
import org.example.app.utils.Constants;
import org.example.app.utils.OptionValidator;

import java.util.Scanner;

public class Main {
    static Scanner scanner;

    public static void main(String[] args) {
        runOption(getOption());
    }

    public static int getOption() {

        scanner = new Scanner(System.in);

        System.out.print("""
                --------------------------
                Choose an option:
                1 - View data in ascending order.
                2 - View data in alphabetical order.
                0 - Close the app.
                """);

        return OptionValidator.validateOptionInput(scanner);
    }

    private static void runOption(int option) {
        switch (option) {
            case 1 -> {
                ReadAscService service = new ReadAscService();
                getOutput(service.getData());
            }
            case 2 -> {
                ReadAlphabetService service = new ReadAlphabetService();
                getOutput(service.getData());
            }
            case 0 -> {
                String output = Constants.APP_CLOSED_MSG;
                getOutput(output, option);
            }
        }
    }

    private static void getOutput(String output) {
        System.out.println(output);
        scanner.close();
    }

    private static void getOutput(String output, int choice) {
        if (choice == 0) System.out.println(output);
        scanner.close();
        System.exit(0);
    }

}