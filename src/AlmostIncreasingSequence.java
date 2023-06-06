import java.util.Set;
import java.util.TreeSet;

public class AlmostIncreasingSequence {
    public static void main(String[] args) {
        int [] sec = {1, 3, 2, 1, 5};
        System.out.println(solution(sec));
    }

    static boolean solution(int[] sequence) {


        int k = 0;

        for (int i=1; i<sequence.length - 1; i++ ) {
            if ( ((sequence[i + 1] > sequence[i]) &&  (sequence[i - 1] > sequence[i])) || ((sequence[i + 1] < sequence[i]) &&  (sequence[i - 1] < sequence[i])) ) {
                k++;
            }
            if  ( (k == 1) && (sequence[i -1] > sequence[sequence.length-1]) )   {
                k++;
            }

        }

        return (k>1)? false : true;
    }
}
