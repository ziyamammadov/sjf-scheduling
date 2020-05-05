package khazar;

public class Process {
    private final int processId;
    private final int burstTime;
    private final int arrivalTime;

    public Process(int processId, int burstTime, int arrivalTime) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
    }

    public int getProcessId() {
        return processId;
    }

    public int getBurstTime() {
        return burstTime;
    }


    public int getArrivalTime() {
        return arrivalTime;
    }
}
