public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> res = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); ++i) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word) {
        Deque words = wordToDeque(word);
        while (words.size() > 1) {
            char first = (char) words.removeFirst();
            char last = (char) words.removeLast();
            if (first != last) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque words = wordToDeque(word);
        while (words.size() > 1) {
            if (!cc.equalChars((char) words.removeFirst(), (char) words.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
