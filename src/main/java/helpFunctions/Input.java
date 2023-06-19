package helpFunctions;

import java.util.Arrays;
import java.util.Scanner;

import entities.Calculator;

public class Input {
    Scanner scanner = new Scanner(System.in);
    String action;

    public void userInput() {

        int[] numbersArray = new int[2];
        String userNumber;

        try {
            while (true) {
                for (int i = 0; i < numbersArray.length; i++) {

                    String iName;
                    if (i == 0) {
                        iName = "first";
                    } else {
                        iName = "second";
                    }

                    System.out.println("Enter the " + iName + " number:");
                    userNumber = scanner.nextLine();

                    if (userNumber.equalsIgnoreCase("exit")) {
                        System.out.println("Process finished!!");
                        System.exit(0);
                    } else {
                        if (Integer.parseInt(userNumber) > 0) {
                            int parseStringValue = Integer.parseInt(userNumber);
                            numbersArray[i] = parseStringValue;
                            System.out.println(Arrays.toString(numbersArray));
                        } else {

                        }

                    }
                }
                chooseWriteAction(numbersArray[0], numbersArray[1]); //TODO
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public double chooseAction(int x, int y, String action) {
        Calculator calculator = new Calculator();
        try {
            return switch (action) {
                case ("+") -> calculator.add(x, y);
                case ("-") -> calculator.removal(x, y);
                case ("*") -> calculator.multi(x, y);
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
        action = scanner.nextLine();

        do {
            if (action.equals("+") || action.equals("-") ||
                    action.equals("*") || action.equals("/")) {

                isActionValid = false;
            } else {
                System.out.println("Choose the right Action!!!");
                action = scanner.nextLine();
            }
        } while (isActionValid);

        return chooseAction(x, y, action);
    }
}
