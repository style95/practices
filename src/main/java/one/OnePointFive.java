package one;

public class OnePointFive {
    public static void main(String[] args) {
        Compressor c = new Compressor();
        String s = "aabccccccccaaa";
        System.out.println(c.compress(s));
    }
}

class Compressor {
    public String compress(String s) {
        StringBuffer str = new StringBuffer();
        int count = 0;
        int ch = '\0';
        for(char c : s.toCharArray()) {
            if(c != ch && count == 0) {
                str.append(c);
                ch = c;
                count++;
            } else if (c != ch) {
                str.append(count);
                str.append(c);
                ch = c;
                count = 1;
            } else {
                count++;
            }
        }
        str.append(count);
        String result = str.toString();
        return result.length() > s.length() ? s : result;
    }
}
