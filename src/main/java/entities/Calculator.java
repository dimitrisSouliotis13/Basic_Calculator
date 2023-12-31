package entities;

public class Calculator {
    private int xNumber;
    private int yNumber;

    public int getXNumber() {
        return xNumber;
    }

    public int getYNumber() {
        return yNumber;
    }

    public void setXNumber(int x) {
        this.xNumber = x;
    }

    public void setYNumber(int y) {
        this.yNumber = y;
    }

    /**
     * @param x first Number.
     * @param y second Number.
     * @return add of two numbers.
     */
    public double add(double x, double y) {
        return x + y;
    }

    /**
     * @param x first Number.
     * @param y second Number.
     * @return removal of two numbers.
     */
    public double removal(double x, double y) {
        return x - y;
    }

    /**
     * @param x first Number.
     * @param y second Number.
     * @return multiplication of two numbers.
     */
    public double multiplication(double x, double y) {
        return x * y;
    }

    /**
     * @param x first Number.
     * @param y second Number.
     * @return division of two numbers.
     */
    public double division(double x, double y) {
        return x / y;
    }

    public double fetchTheSquareOfNumber(double number, double exponent) {
        double result = Math.pow(number, exponent);
        return result;
    }
}
