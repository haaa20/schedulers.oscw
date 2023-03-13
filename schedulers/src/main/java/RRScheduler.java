import java.util.LinkedList;
import java.util.Properties;

/**
 * Round Robin Scheduler
 *
 * @version 2017
 */
public class RRScheduler extends AbstractScheduler {

    // The fields needed for the class to run properly
    int timeQuantum;

    public RRScheduler() {
        super();
    }

    @Override
    public void initialize(Properties parameters) {
        this.timeQuantum = Integer.parseInt(parameters.getProperty("timeQuantum"));
    }

    /**
     * Adds a process to the ready queue.
     * usedFullTimeQuantum is true if process is being moved to ready
     * after having fully used its time quantum.
     */
    public void ready(Process process, boolean usedFullTimeQuantum) {
        if (usedFullTimeQuantum) {
            // If it's used it's time, to the back
            ready.add(process);
        }
        else {
            // ... otherwise to the front
            ready.add(0, process);
        }
    }

    /**
     * Removes the next process to be run from the ready queue
     * and returns it.
     * Returns null if there is no process to run.
     */
    public Process schedule() {
        // The return method handles null checking for me... I think...
        return ready.poll();
    }
}

