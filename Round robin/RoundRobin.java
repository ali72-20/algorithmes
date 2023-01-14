import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Vector;

public class staticRoundRobin {
    //todo: add parameters and make this function work
    public static Vector<Pair> vp = new Vector<Pair>();
    public void run(Vector<process>pro,int number_of_process){
        int[] rem_brust = new int[number_of_process];
        int[] w_time = new int[number_of_process];
        for(int i = 0;i < number_of_process; ++i){
            rem_brust[i] =pro.elementAt(i).burstTime;
        }
        int cur_time = 0;
        while(true){
            boolean finshed = true;
            for(int i = 0;i < number_of_process; ++i) {
                vp.elementAt(i).first = cur_time;
                if (rem_brust[i] > 0) {
                    finshed = false;
                    if (rem_brust[i] > pro.elementAt(i).quantumTime) {
                        rem_brust[i] -= pro.elementAt(i).quantumTime;
                        cur_time += pro.elementAt(i).quantumTime;
                    } else {
                        cur_time += rem_brust[i];
                        rem_brust[i] = 0;
                        w_time[i] = cur_time - pro.elementAt(i).burstTime;
                    }
                }
                vp.elementAt(i).second = cur_time;
            }
            if(finshed){
                for(int i = 0;i < number_of_process; ++i){
                    System.out.print("P");
                    System.out.print(i + 1);
                    System.out.print(':');
                    System.out.print(vp.elementAt(i).first);
                    System.out.print(' ');
                    System.out.print(vp.elementAt(i).second);
                }
                break;
            }
        }
    }
}
