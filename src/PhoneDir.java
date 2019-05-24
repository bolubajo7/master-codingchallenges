import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneDir {

    private static String name;


    private static List<String> matchingResults = new ArrayList<>();

    public static  String phone(String strng, String num) {
        String result = "";
        String [] phoneLines = splitInputStringByNewLine(strng);
        int numberOfMatches = searchMatchingPhoneNo(phoneLines, num);
        if (numberOfMatches == 0) {

            result = "Error => Not found:" + " " + num;
        }
        else if (numberOfMatches == 1) {

            result = processPhoneLine(num);
        }
        else {

            result = "Error => Too many people:" +" "+ num;
        }
        matchingResults.clear();

    return result;
    }

    public  static String [] splitInputStringByNewLine(String input) {

        return input.split("\n");
    }

    public static int searchMatchingPhoneNo(String [] input, String no) {
        int count = 0;
        for (String line : input) {
            Pattern p = Pattern.compile("\\b+[0-9]{1,2}[-][0-9]{3}[-][0-9]{3}[-][0-9]{4}");
            Matcher m = p.matcher(line);
            if(m.find()) {
                String phoneNum = m.group();
                if(no.equalsIgnoreCase(phoneNum)) {
                    matchingResults.add(line);
                    count++;
                }
            }

        }
        return count;
    }

    public static String processPhoneLine(String phonenumber) {
        name = extractName();
        String address = extractAddress(phonenumber);

        String result = "Phone => " + phonenumber + ", Name => " + name + ", Address => " + address;

        return result;
    }

    public static String extractName() {
        String name = "";
        for (String match : matchingResults) {
            Pattern p = Pattern.compile("<.*>");
            Matcher m = p.matcher(match);
            if(m.find()) {
                String nameOfContact = m.group();
                name = nameOfContact.replaceAll(">", "");
                name = name.replaceAll("<","").trim();
            }

        }
        return name;
    }

    public static String extractAddress(String phonenumber){
        String address = "";
        String  line = matchingResults.get(0);
        line = line.replace(name,"").replace(phonenumber,"");
        line = line.replaceAll("[^A-Za-z0-9\\\\. -]"," ");
        line = line.replaceAll(" +"," ").trim();
        address = line;

        return address;

    }
}
