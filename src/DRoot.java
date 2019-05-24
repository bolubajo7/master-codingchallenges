import java.util.ArrayList;
import java.util.List;

public class DRoot {
   private static List<Integer>result = new ArrayList<>();

    public static int digital_root(int n) {
         String num = Integer.toString(n);
         int length = num.length();
         int a = 0;
         if(length > 1 ) {
             char[] nums = num.toCharArray();
             for (int i = 0; i < nums.length; i++) {
                 a = a + nums[i] - '0';
             }
             digital_root(a);
         }
         else {
             result.add(n);
         }
        return result.get(result.size() - 1);
    }
}
