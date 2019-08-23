import java.util.*;

public class SumOfK {

    private static int maxNumberofDistances;
    private static int numberOfTowns;

    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        maxNumberofDistances = t;
        numberOfTowns = k;
        Map<Integer, Integer> countMap = new TreeMap<>();
        for(Integer num : ls)  {
            countMap.compute(num, (key, value) -> {
               if(value == null) {
                   return 1;
               } else {
                   return value + 1;
               }
            });
        }

      Set<Integer> sum = new TreeSet<>();
      int [] result = new int[numberOfTowns];
      int [] numbers = new int[countMap.size()];
      int [] count = new int[countMap.size()];
      int index = 0;
      for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
          numbers[index] = entry.getKey();
          count[index] = entry.getValue();
          index++;
      }
      solveCombinations(numbers, count, result, 0, sum);

      Integer answer;
      if(!sum.isEmpty()) {

          answer = ((TreeSet<Integer>) sum).last();

      } else {

          answer  = null;
      }
      return answer;
    }


    private static void solveCombinations(int[] numbers, int[] count, int[] result, int level, Set<Integer> sum) {
        int totalSum = 0;
        if(level == result.length) {


            for (int num : result) {

                totalSum = totalSum + num;
            }

            if(totalSum <= maxNumberofDistances) {

                sum.add(totalSum);
            }
            return;
        }

        for(int i = 0; i < numbers.length; i++) {
            if(count[i] == 0) {
                continue;
            }

            result[level] = numbers[i];
            count[i]--;
            solveCombinations(numbers, count, result, level + 1, sum);
            count[i]++;
        }
    }

}
