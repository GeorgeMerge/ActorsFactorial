public class FactorialComputer implements Runnable {
    private int leftBorder;
    private int rightBorder;
    private int index;

    public FactorialComputer(int leftBorder, int rightBorder, int index){
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
        this.index = index;
    }

    public void run() {
        System.out.println(this.index + "th thread is doing work inside " + leftBorder + " to " + rightBorder + " interval...");

        int result = leftBorder == 0 ? 1 : leftBorder;
        if (leftBorder != rightBorder) result *= ++leftBorder;

        System.out.println("Result within thread: " + result);

        SingletonFactorialResult.getInstance().multiplyBy(result);

        if (leftBorder < rightBorder) (new Thread(new FactorialComputer(leftBorder + 1, rightBorder, this.index))).run();
    }
}
