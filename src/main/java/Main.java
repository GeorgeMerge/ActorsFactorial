public class Main {
    public static void main(String args[]){
        TaskManager taskManager = new TaskManager(3);
        taskManager.startComputing();

        System.out.println("Result: " + SingletonFactorialResult.getInstance().getFactorialResult());
    }
}
