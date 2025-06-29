public class StringProcessor {
    public String concatenate(String s1, String s2) {
        return s1 + s2;
    }

    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
