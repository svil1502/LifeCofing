import java.util.stream.IntStream;

public class FindMaxTwo {
    public static void main(String[] args) {
       int [] inputArray = {3, 6, -2, -5, 7, 3};
        System.out.println(findMaxInt(inputArray));

    }
    public static int find(int[] inputArray) {
        int max = inputArray[0] * inputArray[1];
        int maxNext = 0;
        for (int i = 1 ; i< inputArray.length - 1; i++) {
            maxNext = inputArray[i] * (inputArray[i + 1]);
                     if (maxNext > max) {
                max = maxNext;
            }
        }
        return max;
    }

        public static int find2(int[] inputArray) {
            return IntStream.range(1, inputArray.length).
                    map(i->inputArray[i]*inputArray[i-1]).
                    max().
                    getAsInt();
        }

    public static int findMaxInt(int[] inputArray) {
        return IntStream.range(0, inputArray.length)
                .map(i->inputArray[i])
                .sum();
    }

}
