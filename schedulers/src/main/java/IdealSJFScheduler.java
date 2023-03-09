import java.util.Iterator;

/**
 * Ideal Shortest Job First Scheduler
 * 
 * @version 2017
 */
public class IdealSJFScheduler extends AbstractScheduler {

  // TODO


  public IdealSJFScheduler() {

  }

  /**
   * Adds a process to the ready queue.
   * usedFullTimeQuantum is true if process is being moved to ready
   * after having fully used its time quantum.
   */
  public void ready(Process process, boolean usedFullTimeQuantum) {
    // We're gonna do priority at queueing as I think that's gonna be cheaper...
    int i = 0;

    for (Process value : processQueue) {
      if (value.getNextBurst() > process.getNextBurst()) {
        break;
      }
      i++;
    }

    processQueue.add(i, process);
  }

  /**
   * Removes the next process to be run from the ready queue 
   * and returns it. 
   * Returns null if there is no process to run.
   */
  public Process schedule() {

    if (!processQueue.isEmpty()) {
      return processQueue.poll();
    }

    return null;
  }
}
