package one;

public class OnePointOne {
    public static void main(String[] args) {
        UniqueChecker checker = new UniqueChecker();
        String s = "tesqwezx  q";
        System.out.println(checker.checkUnique(s));
    }
}

class UniqueChecker {
    public boolean checkUnique(String s) {
        boolean[] set = new boolean[128];

        for( Character c : s.toCharArray()) {
            if(set[c]) {
                return false;
            } else {
                set[c] = true;
            }
        }
        return true;
    }
}
