package helpFunctions;

import java.util.Arrays;
import java.util.Scanner;

import ColorFolder.ConsoleColors;
import entities.Calculator;

public class Input {
    Scanner scanner = new Scanner(System.in);
    String action;

    public void userInput() {
        int[] arrayWithNumbers;
        int userNumber;

        try {
            while (true) {
                arrayWithNumbers = new int[2];
                for (int i = 0; i < arrayWithNumbers.length; i++) {

                    String iName;
                    if (i == 0) {
                        iName = "first";
                    } else {
                        iName = "second";
                    }

                    System.out.println(ConsoleColors.BLACK_BACKGROUND + "Enter the " + iName + " number:" + ConsoleColors.RESET);
                    userNumber = scanner.nextInt();
                    //scanner.hasNextInt() ///TODO
                    //checkIfUserInputItsCorrect(userNumber);

                    if (userNumber > 0) {
                        int parseStringValue = userNumber;
                        arrayWithNumbers[i] = parseStringValue;
                        System.out.println(Arrays.toString(arrayWithNumbers));
                    }
                }
                double finalValue =
                        chooseWriteAction(arrayWithNumbers[0], arrayWithNumbers[1]);
                System.out.println(ConsoleColors.RED_BRIGHT + finalValue + ConsoleColors.RESET);
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public double chooseAction(int x, int y, String action) throws Exception {
        Calculator calculator = new Calculator();

        return switch (action) {
            case ("+") -> calculator.add(x, y);
            case ("-") -> calculator.removal(x, y);
            case ("*") -> calculator.multiplication(x, y);
            case ("/") -> calculator.division(x, y);
            default -> throw new Exception(ConsoleColors.RED + "Invalid Action!!!" + ConsoleColors.RESET);
        };
    }

    public double chooseWriteAction(int x, int y) throws Exception {
        boolean isActionValid = true;
        System.out.println(ConsoleColors.BLACK_BACKGROUND + "Choose Action (+, -, *, /)" + ConsoleColors.RESET);

        do {
            action = scanner.next();
            if (action.equals("+") || action.equals("-") ||
                    action.equals("*") || action.equals("/")) {

                isActionValid = false;
            } else {
                System.out.println(ConsoleColors.RED + "Choose the right Action !!!" + ConsoleColors.RESET);
                action = scanner.nextLine();
            }
        } while (isActionValid);

        return chooseAction(x, y, action);
    }
}
