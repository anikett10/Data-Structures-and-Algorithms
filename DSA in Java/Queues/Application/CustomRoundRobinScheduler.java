import java.util.*;

/**
 * CustomRoundRobinScheduler class represents a round-robin scheduling algorithm
 * for custom processes. It allows processes to be added to a queue and executed
 * in a round-robin fashion based on a specified time quantum.
 *
 * @author Aniket Bhangale
 * @version 1.0
 */
public class CustomRoundRobinScheduler {

    /**
     * Queue to store custom processes.
     */
    public Queue<CustomProcess> customQueue;

    /**
     * Time quantum for round-robin scheduling.
     */
    private int customQuantum;

    /**
     * Constructs a CustomRoundRobinScheduler object with the given time quantum.
     *
     * @param quantum The time quantum for round-robin scheduling.
     */
    public CustomRoundRobinScheduler(int quantum) {
        this.customQueue = new LinkedList<>();
        this.customQuantum = quantum;
    }

    /**
     * Adds a custom process to the scheduling queue.
     *
     * @param process The custom process to be added to the queue.
     */
    public void addCustomProcess(CustomProcess process) {
        customQueue.add(process);
    }

    /**
     * Executes the round-robin scheduling algorithm until all processes are complete.
     * Processes are executed in a round-robin fashion based on the specified time quantum.
     */
    public void runScheduler() {
        while (!customQueue.isEmpty()) {
            CustomProcess process = customQueue.remove();
            int timeExecuted = process.execute(customQuantum);
            if (process.isProcessComplete()) {
                System.out.println("Process #" + process.getProcessId() + " completed execution.");
            } else {
                System.out.println("Process #" + process.getProcessId() + " executed for " +
                        timeExecuted + " units. Remaining execution time: " + process.getRemainingTime() + " units.");
                customQueue.add(process);
            }
        }
    }

    /**
     * CustomProcess class represents a process with an ID and remaining execution time.
     */
    public static class CustomProcess {
        private int processId;
        private int remainingTime;

        /**
         * Constructs a CustomProcess object with the given ID and remaining execution time.
         *
         * @param id            The ID of the process.
         * @param remainingTime The remaining execution time of the process.
         */
        public CustomProcess(int id, int remainingTime) {
            this.processId = id;
            this.remainingTime = remainingTime;
        }

        /**
         * Executes the process for a specified quantum of time.
         *
         * @param quantum The time quantum for execution.
         * @return The actual execution time for the process.
         */
        public int execute(int quantum) {
            int actualExecutionTime = Math.min(quantum, remainingTime);
            remainingTime -= actualExecutionTime;
            return actualExecutionTime;
        }

        /**
         * Checks if the process has completed its execution.
         *
         * @return true if the process is complete, false otherwise.
         */
        public boolean isProcessComplete() {
            return remainingTime == 0;
        }

        /**
         * Gets the ID of the process.
         *
         * @return The ID of the process.
         */
        public int getProcessId() {
            return processId;
        }

        /**
         * Gets the remaining execution time of the process.
         *
         * @return The remaining execution time of the process.
         */
        public int getRemainingTime() {
            return remainingTime;
        }
    }

    /**
     * Main method for testing the CustomRoundRobinScheduler class.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the time quantum
        System.out.print("Enter the time slicing for round-robin scheduling: ");
        int timeQuantum = scanner.nextInt();

        CustomRoundRobinScheduler scheduler = new CustomRoundRobinScheduler(timeQuantum);

        // Ask the user for the number of processes to add
        System.out.print("Enter the number of processes: ");
        int numberOfProcesses = scanner.nextInt();

        // Loop to take input for each process
        for (int i = 0; i < numberOfProcesses; i++) {
            System.out.print("Enter process ID for process #" + (i + 1) + ": ");
            int processId = scanner.nextInt();
            System.out.print("Enter execution time for process #" + (i + 1) + ": ");
            int remainingTime = scanner.nextInt();

            // Create a new custom process and add it to the scheduler
            scheduler.addCustomProcess(new CustomProcess(processId, remainingTime));
        }

        // Run the scheduler
        scheduler.runScheduler();

        // Close the scanner
        scanner.close();
    }
}
