package datastructures;

public class PalindromePermutation {

    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("taco cat"));
    }

    // To be a permutation of a palindrome, a string can have no more than
    // one character that is odd.

    // Using a hash table to count how many times each character occurred
    private static boolean isPalindromePermutation(String word) {
        int[] hashTable = buildCharacterHashTable(word);
        int oddCount = 0;
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] % 2 != 0) {
                oddCount++;
                if (oddCount > 1)
                    return false;
            }
        }
        return true;
    }

    private static int getCharacterNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);

        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    private static int[] buildCharacterHashTable(String word) {
        int[] hashTable = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c: word.toCharArray()) {
            int val = getCharacterNumber(c);
            if (val != -1) {
                hashTable[val] += 1;
            }
        }
        return hashTable;
    }

    public boolean isPalindrome(String word) {
        if (word.length() == 0) {
            return true;
        }
        word = word.toLowerCase();
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if ((word.charAt(left) < 97 && word.charAt(left) > 57)
                    || (word.charAt(left) < 48)
                    || (word.charAt(left) > 122)) {
                left++;
                continue;
            }
            if ((word.charAt(right) < 97 && word.charAt(right) > 57)
                    || (word.charAt(right) < 48)
                    || (word.charAt(right) > 122)) {
                right--;
                continue;
            }

            if (word.charAt(left) == word.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
