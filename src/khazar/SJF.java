package khazar;

public class SJF {
    static void findWaitingTime(Process[] proc, int n, int[] wt) {
        int[] rt = new int[n];

        for (int i = 0; i < n; i++)
            rt[i] = proc[i].getBurstTime();

        int complete = 0, t = 0, min = Integer.MAX_VALUE;
        int shortest = 0, finish_time;
        boolean check = false;

        while (complete != n) {

            for (int j = 0; j < n; j++) {
                if ((proc[j].getArrivalTime() <= t) && (rt[j] < min) && rt[j] > 0) {
                    min = rt[j];
                    shortest = j;
                    check = true;
                }
            }

            if (!check) {
                t++;
                continue;
            }

            rt[shortest]--;
            min = rt[shortest];
            if (min == 0)
                min = Integer.MAX_VALUE;

            if (rt[shortest] == 0) {

                complete++;
                check = false;
                finish_time = t + 1;
                wt[shortest] = finish_time - proc[shortest].getBurstTime() - proc[shortest].getArrivalTime();
                if (wt[shortest] < 0)
                    wt[shortest] = 0;
            }
            t++;
        }
    }

    static void findTurnAroundTime(Process[] proc, int n, int[] wt, int[] tat) {
        for (int i = 0; i < n; i++)
            tat[i] = proc[i].getBurstTime() + wt[i];
    }

    static void findAvgTime(Process[] proc, int n) {
        int[] wt = new int[n];
        int[] tat = new int[n];
        int total_wt = 0, total_tat = 0;

        findWaitingTime(proc, n, wt);

        findTurnAroundTime(proc, n, wt, tat);
        printHeader();
        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];

            System.out.println(pad(String.valueOf(proc[i].getProcessId()), 15)
                    + pad(String.valueOf(proc[i].getBurstTime()), 15)
                    + pad(String.valueOf(wt[i]), 15)
                    + pad(String.valueOf(tat[i]), 18));
        }

        System.out.println("Average waiting time = " + (float) total_wt / (float) n);
        System.out.println("Average turn around time = " + (float) total_tat / (float) n);
    }

    static String pad(String str, int n) {
        return String.format("|     " + "%-" + n + "s" + "|", str);
    }

    static void printHeader() {
        String s = "==========================================================================================";
        System.out.println(s + "+");
        System.out.println(pad("PROCESSES", 15) + pad("BURST TIME", 15) + pad("WAITING TIME", 15) + pad("TURN AROUND TIME", 18));
        System.out.println(s + "|");
    }
}
