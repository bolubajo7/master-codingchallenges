import java.util.ArrayList;
import java.util.StringJoiner;

public class SpinWords {

    public String spinWords(String sentence) {

        String[] wordArray = splitSentenceIntoWords(sentence);

        ArrayList<String> words = new ArrayList<>();
        if (sentenceHasMoreThanOneWord(wordArray)) {

            for (String word : wordArray) {

                if (WordIsCorrectLength(word)) {
                    words.add(reverseWord(word));
                } else {
                    words.add(word);
                }
            }
            return buildSentence(words);

        } else {
            for (String word : wordArray) {
                if (WordIsCorrectLength(word)) {
                    return reverseWord(word);
                } else {

                }
            }
        }
        return sentence;
    }

    private String [] splitSentenceIntoWords (String inputSentence) {

        String[] words = inputSentence.trim().split(" ");

        return words;

    }

    private boolean sentenceHasMoreThanOneWord(String[] inputArray) {

        if(inputArray.length > 1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean WordIsCorrectLength(String inputWord) {

        if(numberOfCharsInWord(inputWord) >= 5) {
            return true;
        }
        return false;
    }

    private int numberOfCharsInWord (String inputWord){

        return inputWord.length();


    }

    private String reverseWord (String wordToReverse) {

        StringBuilder wordInput = new StringBuilder(wordToReverse);
        return  wordInput.reverse().toString();


    }

    private String buildSentence(ArrayList<String> wordList) {
        StringJoiner joiner = new StringJoiner(" ");
        for(String word : wordList) {
            joiner.add(word);
        }
        return joiner.toString();

    }

}
