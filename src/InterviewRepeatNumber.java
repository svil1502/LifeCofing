import java.util.HashSet;
import java.util.Set;

public class InterviewRepeatNumber {
    //https://friskals.medium.com/first-duplicate-d9640ffde9d2
    public static void main(String[] args) {
        //[2, 4, 3, 5, 1]
        int[] a = {8, 4, 6, 2, 6, 4, 7, 9, 5, 8};
        //{2, 1, 3, 5, 3, 2};
        System.out.println(solution(a));
        System.out.println(firstDuplicate(a));

    }

    static int solution(int[] a) {
        int n = 0;
        int min = -1;
        boolean flag = false;
        if (a.length > 1) {
            for (int i = 0; i < a.length / 2 - 1; i++) {

                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] == a[j]) {
                        flag = true;
                        n = j;
                        break;
                    }
                }
                if (!flag) {
                    min = -1;
                } else if (n > min) {
                    min = a[n];
                }
            }
        }
        return min;
    }

    static int firstDuplicate2(int[] a) {

        int[] checkDuplicate = new int[100001];

        for(int i = 0 ; i < a.length ; i++)
        {
            checkDuplicate[a[i]]++;

            if(checkDuplicate[a[i]] > 1)
            {
                return a[i];
            }
        }

        return -1;
    }

   static int firstDuplicate(int[] a) {

        Set uniqueNumbers = new HashSet();

        for(int i = 0 ; i < a.length; i++)
        {
            if(uniqueNumbers.contains(a[i])){
                return a[i];
            }
            uniqueNumbers.add(a[i]);
        }

        return -1;
    }
}
