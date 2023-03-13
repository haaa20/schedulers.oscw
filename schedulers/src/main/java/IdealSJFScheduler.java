/**
 * Ideal Shortest Job First Scheduler
 * 
 * @version 2017
 */
public class IdealSJFScheduler extends AbstractScheduler {

  // TODO


  public IdealSJFScheduler() {
    super();
  }

  /**
   * Adds a process to the ready queue.
   * usedFullTimeQuantum is true if process is being moved to ready
   * after having fully used its time quantum.
   */
  public void ready(Process process, boolean usedFullTimeQuantum) {
    // We're going to do priority at queueing as I think that's going to be cheaper...
    int i = 0;

    for (Process value : ready) {
      if (value.getNextBurst() > process.getNextBurst()) {
        break;
      }
      i++;
    }

    ready.add(i, process);
  }

  /**
   * Removes the next process to be run from the ready queue 
   * and returns it. 
   * Returns null if there is no process to run.
   */
  public Process schedule() {

    if (!ready.isEmpty()) {
      return ready.poll();
    }

    return null;
  }
}
