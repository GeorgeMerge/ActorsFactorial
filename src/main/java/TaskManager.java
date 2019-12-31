import java.util.LinkedList;
import java.util.List;

public class TaskManager {
    private int MAX_THREADS = 4;
    private List<Thread> threads;
    private int value;

    private int result;

    public TaskManager(int value){
        this.value = value;
    }

    public void startComputing(){
        if(value <= 0)
            return;

        threads = new LinkedList<Thread>();
        int multiplicationsNumber = calcMultNumber();

        System.out.println(multiplicationsNumber);

        System.out.println("Assigning tasks...");

        for(int i = 0; i < MAX_THREADS; i++) {

            int leftBorder = i * multiplicationsNumber + 1, rightBorder = (i + 1) * multiplicationsNumber;
            if(leftBorder > value) break;
            if(rightBorder > value) rightBorder = value;

            System.out.println("Multiply range: " + leftBorder + " to " + rightBorder);

            threads.add(new Thread(new FactorialComputer(leftBorder, rightBorder, i)));
        }

        for(Thread thread : threads) thread.run();

        result = SingletonFactorialResult.getInstance().getFactorialResult();
    }

    private int calcMultNumber(){
        if (value <= MAX_THREADS) return 1;
        if (value % MAX_THREADS == 0) return value/MAX_THREADS;
        return value/MAX_THREADS + 1;
    }
}
