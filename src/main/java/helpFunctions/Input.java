package helpFunctions;

import java.util.Arrays;
import java.util.Scanner;

import ColorFolder.ConsoleColors;
import entities.Calculator;

public class Input {
    Scanner scanner = new Scanner(System.in);
    String action;

    public void userInput() {
        double[] arrayWithNumbers;
        String userNumber;

        try {
            while (true) {
                arrayWithNumbers = new double[2];
                for (int i = 0; i < arrayWithNumbers.length; i++) {

                    String iName;
                    if (i == 0) {
                        iName = "first";
                    } else {
                        iName = "second";
                    }

                    System.out.println(
                            ConsoleColors.BLACK_BACKGROUND + "Enter the " + iName + " number:" + ConsoleColors.RESET);

                    userNumber = checkInput(scanner.next());

                    arrayWithNumbers[i] = Double.parseDouble(userNumber);
                    System.out.println(Arrays.toString(arrayWithNumbers));
                }
                double finalValue =
                        chooseWriteAction(arrayWithNumbers[0], arrayWithNumbers[1]);
                System.out.println(
                        ConsoleColors.WHITE_BACKGROUND + "<<< The final value is: " + finalValue + ". >>>" + ConsoleColors.RESET);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public String checkInput(String userNum) {
        boolean checkInput = false;
        do {
            //check the input that is only numbers not letters
            if (!userNum.matches("^[+-]?\\d+(\\.\\d+)?$")) {
                System.out.println(
                        ConsoleColors.RED_BRIGHT + "Write numbers!!" + ConsoleColors.RESET);
                checkInput = false;
                userNum = scanner.next();

            } else {
                checkInput = true;
            }
        }
        while (!checkInput);
        return userNum;
    }

    public double chooseAction(double x, double y, String action) throws Exception {
        Calculator calculator = new Calculator();

        return switch (action) {
            case ("+") -> calculator.add(x, y);
            case ("-") -> calculator.removal(x, y);
            case ("*") -> calculator.multiplication(x, y);
            case ("/") -> calculator.division(x, y);
            case ("^") -> calculator.fetchTheSquareOfNumber(x, y);
            default -> {
                System.out.println(ConsoleColors.RED + "Invalid Action!!!" + ConsoleColors.RESET);
                yield 0; //java 14 &meta!!!
                //or--> result = 0; // in Java 14 &prin: we use this with switch normally as is!!
                //or--> default -> throw new IllegalStateException("Unexpected value: " + action);
            }
        };
    }

    public double chooseWriteAction(double x, double y) throws Exception {
        boolean isActionValid = true;
        System.out.println(
                ConsoleColors.BLACK_BACKGROUND + "Choose Action (+, -, *, /, ^)" + ConsoleColors.RESET);
        do {
            action = scanner.next();
            if (action.equals("+") ||
                    action.equals("-") ||
                    action.equals("*") ||
                    action.equals("/") ||
                    action.equals("^")) {

                isActionValid = false;
            } else {
                System.out.println(
                        ConsoleColors.RED + "Invalid Action !! Choose the right Action !!!" + ConsoleColors.RESET);
                action = scanner.nextLine();
            }
        } while (isActionValid);

        return chooseAction(x, y, action);
    }
}