import java.util.ArrayList;
import java.util.Collection;


public class Programmer {

    Collection<String> languages = new ArrayList<>();

    public Collection<String> getLanguages() {

        return languages ;
    }


    public void addLanguage(String language) {
        languages.add(language);

    }


    public static class ProgrammerTeacher extends Programmer {
        public boolean teach (Programmer programmer, String language) {
            if(programmer.languages.contains(language)) {
                return true;
            }
            return false;
        }

        public static void main(String[] args) {
            ProgrammerTeacher teacher = new ProgrammerTeacher();
            teacher.addLanguage("Java");

            Programmer programmer = new Programmer();
            boolean result = teacher.teach(programmer, "Java");

            for(String language : programmer.getLanguages())
                System.out.println(language);
        }

    }
}