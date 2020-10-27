import java.util.*;

public class ArrangeWords {
    public static String arrangeWords(String text) {
        //split the text into array
        String[] text_array = text.toLowerCase().split(" ");
        Arrays.sort(text_array, new java.util.Comparator<String>(){
            @Override
            public int compare(String A, String B){
                return A.length() - B.length();
            }
        });
        String firstWordCapitalized = text_array[0].substring(0,1).toUpperCase();
        firstWordCapitalized += text_array[0].substring(1).toLowerCase();
        text_array[0] = firstWordCapitalized;
        String finalText = String.join(" ", text_array);
        return finalText;
    }

    public static void main(String[] args){
         String finalText = ArrangeWords.arrangeWords("Leetcode is cool");
         System.out.println("Final Text: " + finalText);
    }
}
