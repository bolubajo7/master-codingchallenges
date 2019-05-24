import java.util.StringJoiner;

public class DubStep {
    public static String SongDecoder (String song)
    {
        String [] splitSong = song.split("WUB");
        StringJoiner sj = new StringJoiner(" ");
        for (String word : splitSong) {
            if (word.matches("")) {

            }
            else {
                sj.add(word);
            }
        }
        return sj.toString().trim();
    }
}
