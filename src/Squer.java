public class Squer {
    public static void main(String[] args) {

        System.out.println(solution(4));

    }

    static int solution(int n) {
        int summa = 1;
        while (n > 0) {
            summa = summa + 4 * n - 4;
            n = n - 1;
        }
        return summa;
    }
}

