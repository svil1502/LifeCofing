import java.util.Arrays;

public class Satue {
    public static void main(String[] args) {
        int[] a = {5, 3, 2, 9};
        System.out.println(solution2(a));
    }

    static int solution(int[] statues) {
        Arrays.sort(statues);
        int count = 0;
        for (int i = 1; i < statues.length; i++) {
            int diff = statues[i] - statues[i - 1];
            if (diff > 1) {
                count += diff - 1;
            }
        }
        return count;
    }

    static int solution2(int[] a) {
        Arrays.sort(a);
        int n = a[a.length-1] - a[0];
        return n - a.length + 1;
    }

}



