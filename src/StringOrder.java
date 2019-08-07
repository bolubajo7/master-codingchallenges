import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOrder {

    public static String sortString (String input) {
        String result = "";
        Map<Integer, String> map = new TreeMap<>();
        if (!input.isEmpty()) {
            String [] words = input.trim().split(" ");
            Pattern p = Pattern.compile("\\d");
            for (String word: words) {
                Matcher m = p.matcher(word);
                if(m.find()) {
                    int number = Integer.parseInt(m.group());
                    map.put(number, word);

                }
            }
            StringJoiner joiner = new StringJoiner(" ");
            for(Map.Entry m : map.entrySet()){
                joiner.add(m.getValue().toString());
            }
            result = joiner.toString();
        }

        return result;
    }

}
