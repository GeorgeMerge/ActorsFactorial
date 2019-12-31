public class SingletonFactorialResult {
    private static SingletonFactorialResult instance = null;
    private int factorialResult;

    private SingletonFactorialResult() {
        factorialResult = 1;
    }

    public static SingletonFactorialResult getInstance() {
        if (instance == null) {
            synchronized (SingletonFactorialResult.class) {
                if (instance == null) {
                    instance = new SingletonFactorialResult();
                }
            }
        }
        return instance;
    }

    public synchronized void multiplyBy(int factor){
        factorialResult *= factor;
        System.out.println("Current value is " + factorialResult);
    }

}
