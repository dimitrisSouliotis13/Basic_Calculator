package entities;

public class Calculator {
    private int xNumber;
    private int yNumber;

    /**
     * Constructor noValues.
     */
    public Calculator() {
    }

    /**
     * Constructor withValues.
     */
    public Calculator(int x, int y) {
        this.xNumber = x;
        this.yNumber = y;
    }

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
    public double add(int x, int y) {
        return x + y;
    }

    /**
     * @param x first Number.
     * @param y second Number.
     * @return removal of two numbers.
     */
    public double removal(int x, int y) {
        return x - y;
    }

    /**
     * @param x first Number.
     * @param y second Number.
     * @return multiplication of two numbers.
     */
    public double multi(int x, int y) {
        return x * y;
    }

    /**
     * @param x first Number.
     * @param y second Number.
     * @return division of two numbers.
     */
    public double division(int x, int y) {
        return (double) (x / y);
    }
}
