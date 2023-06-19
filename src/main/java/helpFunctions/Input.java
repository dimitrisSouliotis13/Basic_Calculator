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

                    System.out.println("Enter the " + iName + " number:");
                    userNumber = scanner.nextInt();
                    //scanner.hasNextInt()

                    if (userNumber > 0) {
                        int parseStringValue = userNumber;
                        arrayWithNumbers[i] = parseStringValue;
                        System.out.println(Arrays.toString(arrayWithNumbers));
                    }
                }
                double finalValue = chooseWriteAction(arrayWithNumbers[0], arrayWithNumbers[1]);
                System.out.println(finalValue);
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public void checkIfUserInputItsCorrect(String value) {
        boolean isActionValid = true;
        do {
            action = scanner.next();
            if () {
                isActionValid = false;
            } else {
                System.out.println();
                action = scanner.nextLine();
            }
        } while (isActionValid);
    }

    public double chooseAction(int x, int y, String action) {
        Calculator calculator = new Calculator();
        try {
            return switch (action) {
                case ("+") -> calculator.add(x, y);
                case ("-") -> calculator.removal(x, y);
                case ("*") -> calculator.multiplication(x, y);
                case ("/") -> calculator.division(x, y);
                default -> 0;
            };
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public double chooseWriteAction(int x, int y) {
        boolean isActionValid = true;
        System.out.println("Choose the Action you want (+, -, *, /)");

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

    //method to check for double
    public double validDouble(double num) {

        while (true) {
            try {
                num = Double.parseDouble(scanner.next());
                break;
            } catch (NumberFormatException nfe) {
                System.out.print(ConsoleColors.RED + "Type only numbers: " + ConsoleColors.RESET);
            }
        }
        return 999;
    }
}
