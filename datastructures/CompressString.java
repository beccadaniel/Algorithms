package datastructures;

public class CompressString {

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
        System.out.println(compress("a"));
    }

    public static String compressString(String word) {
        StringBuilder compressed = new StringBuilder();
        int consecutiveCount = 0;
        for (int i = 0; i < word.length(); i++) {
            consecutiveCount++;
            if ((i + 1 >= word.length()) || (word.charAt(i) != word.charAt(i+1))) {
                compressed.append(word.charAt(i));
                compressed.append(consecutiveCount);
                consecutiveCount = 0;
            }
        }
        return compressed.length() > word.length() ? word : compressed.toString();
    }

    // ALTERNATIVE METHOD
    public static int countCompressed(String word) {
        int compressedCount = 0;
        int consecutiveCount = 0;
        for (int i = 0; i < word.length(); i++) {
            consecutiveCount++;
            if ((i + 1 >= word.length()) || (word.charAt(i) != word.charAt(i+1))) {
                compressedCount += 1 + String.valueOf(consecutiveCount).length();
                consecutiveCount = 0;
            }
        }
        return compressedCount;
    }

    public static String compress(String word) {
        int compressLength = countCompressed(word);
        if (compressLength > word.length())
            return word;

        int consecutiveCount = 0;
        StringBuilder compressed = new StringBuilder(compressLength);
        for (int i = 0; i < word.length(); i++) {
            consecutiveCount++;
            if ((i + 1 >= word.length()) || (word.charAt(i) != word.charAt(i+1))) {
                compressed.append(word.charAt(i));
                compressed.append(consecutiveCount);
                consecutiveCount = 0;
            }
        }
        return compressed.toString();
    }
}
