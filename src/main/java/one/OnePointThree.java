package one;

public class OnePointThree {

    public static void main(String[] args) {
        Permutation p = new Permutation();
        String s1 = "aabbccc";
        String s2 = "bbaaccd";
        System.out.println(p.checkPerm(s1, s2));
    }

}

class Permutation {
    public boolean checkPerm(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        return sort(s1).equals(sort(s2));
    }
    public String sort(String s) {
        char[] array = s.toCharArray();
        java.util.Arrays.sort(array);
        return new String(array);
    }
}
