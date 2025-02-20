package javaTasks;

public class Search {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "banana"};
        String targetWord = "banana";

        for (String word : words){
            if (word.equals(targetWord)){
                System.out.println("found");
            } else System.out.println("not_found");
        }
    }
}
