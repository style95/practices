package one;

public class OnePointFour {
    public static void main(String[] args) {
        Replacer r = new Replacer();
        char[] c = "Mr John Smith    ".toCharArray();
        System.out.println(r.replace(c, 13));
    }
}

class Replacer {
    public String replace(char[] c, int size) {
        int index = c.length-1;
        for(int i = c.length-1; i >= 0; i--) {
            if(c[i] != ' ') {
                c[index] = c[i];
                index--;
            } else if(index < c.length-1) {
                c[index--] = '0';
                c[index--] = '2';
                c[index--] = '%';
            }
        }
        return new String(c);
    }
}
