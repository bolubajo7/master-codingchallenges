import java.util.*;

public class SumOfK {

    private static int maxNumberOfDistances;

    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        maxNumberOfDistances = t;
        int numberOfTowns = k;

      Set<Integer> sum = new TreeSet<>();
      int [] numbers = new int[ls.size()];
      int index = 0;
        for (Integer num : ls) {
            numbers[index] = num;
            index++;
        }

      generate(numberOfTowns, numbers, sum);

      Integer answer;
      if(!sum.isEmpty()) {

          answer = ((TreeSet<Integer>) sum).last();

      } else {

          answer  = null;
      }
      return answer;
    }


    public  static List<int[]> generate(int r, int [] numbers, Set<Integer> sum) {
        int[] input = numbers.clone();    // input array
        int k = r;                             // sequence length

        List<int[]> subsets = new ArrayList<>();

        int[] s = new int[k];                  // here we'll keep indices
        // pointing to elements in input array

        if (k <= input.length) {
            // first index sequence: 0, 1, 2, ...
            for (int i = 0; (s[i] = i) < k - 1; i++) ;
            subsets.add(getSubset(input, s, sum));
            for (; ; ) {
                int i;
                // find position of item that can be incremented
                for (i = k - 1; i >= 0 && s[i] == input.length - k + i; i--) ;
                if (i < 0) {
                    break;
                }
                s[i]++;                    // increment this item
                for (++i; i < k; i++) {    // fill up remaining items
                    s[i] = s[i - 1] + 1;
                }
                subsets.add(getSubset(input, s, sum));
            }
        }
        return subsets;
    }

// generate actual subset by index sequence
        public static int[] getSubset(int[] input, int[] subset, Set<Integer> sum) {
            int[] result = new int[subset.length];
            for (int i = 0; i < subset.length; i++) {
                result[i] = input[subset[i]];
            }

            int totalSum = 0;
            for (int num : result) {

                totalSum = totalSum + num;
            }

            if(totalSum <= maxNumberOfDistances) {

                sum.add(totalSum);
            }


            return result;
        }


}
