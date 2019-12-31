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

        if (leftBorder < rightBorder) (new Thread(new FactorialComputer(leftBorder + 1, rightBorder, this.index))).run();

        SingletonFactorialResult.getInstance().multiplyBy(result);

        /*int result = leftBorder == 0 ? 1 : leftBorder;
        result *= ++leftBorder;

        Thread thread;
        if(leftBorder <= rightBorder) {
            thread = new Thread(new FactorialComputer(leftBorder, rightBorder, this.index));
            thread.run();
        }

        SingletonFactorialResult.getInstance().multiplyBy(result);*/

    }
}
