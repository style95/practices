package five;

public class FivePointFive {
    public static void main(String[] args) {
        TransformCounter counter = new TransformCounter();
        System.out.println(counter.count(29, 15));
    }


}

class TransformCounter {

    public int count(int A, int B) {
        int c = (A ^ B);
        int count = 0;
        for(int i = c; i != 0; i = (i & i-1)) {
            count++;
        }
        return count;
    }
}
