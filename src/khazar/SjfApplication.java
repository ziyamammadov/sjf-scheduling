package khazar;

public class SjfApplication {
    public static void main(String[] args) {
        Process[] proc = {new Process(1, 6, 1),
                new Process(2, 8, 1),
                new Process(3, 7, 2),
                new Process(4, 3, 3)};

        SJF.findAvgTime(proc, proc.length);
    }
}
