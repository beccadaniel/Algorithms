package datastructures;

public class UniqueCharsInString {

    public static void main(String[] args) {
        System.out.println(isUniqueChars("step"));
    }

    // Assuming characters are ASCII encoded (7-bit encoding not 8)
    // with extra data structure
    public static boolean hasUniqueChars(String word) {
        // check if word contains more characters than in ASCII
        if (word.length() > 128) {
            return false;
        }

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < word.length(); i++) {
            int val = word.charAt(i);
            if (charSet[val]) {
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }

    // without extra data structure
    public static boolean isUniqueChars(String word) {
        // let's assume that the string can only have characters between 'a' - 'z'. This has 32 characters in.
        // create an integer with 32 bits set to 0
        int checker = 0;
        for (int i = 0; i < word.length(); i++) {
            int bitAtIndex = word.charAt(i) - 'a';
            System.out.println(bitAtIndex);

            // if the bit is set in the checker, we return false
            if ((checker & (1<<bitAtIndex)) > 0)
                return false;
            // otherwise, set the bit
            checker = checker | (1 << bitAtIndex);
        }
        return true;
    }
}
