import java.util.LinkedList;
import java.util.List;

public class TaskManager {
    private int MAX_THREADS = 4;
    private List<Thread> threads;
    private int value;

    public TaskManager(int value){
        this.value = value;
    }

    public void startComputing(){
        if(value <= 0)
            return;

        threads = new LinkedList<Thread>();
        int multiplicationsNumber = value/MAX_THREADS;

        System.out.println(multiplicationsNumber);

        System.out.println("Assigning tasks...");
        for(int i = 0 ; i < MAX_THREADS; i++){
            if(i != MAX_THREADS - 1) {
                System.out.println(i + "th thread is assigned tasks from " + i * multiplicationsNumber + " to " + ((i+1) * multiplicationsNumber));
                threads.add(new Thread(new FactorialComputer
                        (i * multiplicationsNumber, (i+1) * multiplicationsNumber, i)));
            }
            else {
                System.out.println(i + "th thread is assigned tasks from " + i * multiplicationsNumber + " to " + (value ));
                threads.add(new Thread(new FactorialComputer
                        (i * multiplicationsNumber, value, i)));
            }
        }

        for(Thread thread : threads) thread.run();
    }
}
