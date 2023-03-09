import java.util.LinkedList;

/**
 * Round Robin Scheduler
 *
 * @version 2017
 */
public class RRScheduler extends AbstractScheduler {

    // TODO
    int timeQuantum;

    public RRScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    /**
     * Adds a process to the ready queue.
     * usedFullTimeQuantum is true if process is being moved to ready
     * after having fully used its time quantum.
     */
    public void ready(Process process, boolean usedFullTimeQuantum) {
        // Here's where I'm confused: usedFullTimeQuantum should be redundant, right?
        // f0r RR scheduling it shouldn't matter... right...?
        processQueue.add(process);
        // I must be paranoid cos I'm thinking "THERE'S NO WAY IT'S THIS SIMPLE!!"

    }

    /**
     * Removes the next process to be run from the ready queue
     * and returns it.
     * Returns null if there is no process to run.
     */
    public Process schedule() {
        // The return method handles null checking for me... I think...
        return processQueue.poll();
    }
}

