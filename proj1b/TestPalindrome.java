import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    //private Object OffByOne;
    private OffByOne offset1 = new OffByOne();
    private OffByN offsetN = new OffByN(2);

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    // Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("abbbbcbbbba"));
        assertFalse(palindrome.isPalindrome("ab"));
        assertFalse(palindrome.isPalindrome("abbbc"));
    }

    @Test
    public void testIsPalindrome2() {
        assertTrue(palindrome.isPalindrome("asctb", offset1));
        assertTrue(palindrome.isPalindrome("ab", offset1));
        assertTrue(palindrome.isPalindrome("MOPL", offset1));
        assertFalse(palindrome.isPalindrome("asctE", offset1));

    }

    @Test
    public  void testIsPalindrome3() {
        assertTrue(palindrome.isPalindrome("abdc", offsetN));
        assertTrue(palindrome.isPalindrome("jl", offsetN));
        assertTrue(palindrome.isPalindrome("jkmh", offsetN));
        assertFalse(palindrome.isPalindrome("abcd", offsetN));
    }

}
