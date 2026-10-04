import java.util.Random;

/*
*
Top-down sort N = 1000: 0.003
Bottom-Up sort N = 1000: 0.005
Top-down sort N = 100000: 0.238
Bottom-Up sort N = 100000: 0.227
Top-down sort N = 200000: 0.075
Bottom-Up sort N = 200000: 0.081
Top-down sort N = 500000: 0.269
Bottom-Up sort N = 500000: 0.275
Top-down sort N = 1000000: 0.543
Bottom-Up sort N = 1000000: 0.571
*/

public class Test {

    static void main() {
        Random random = new Random(10);

        Integer[] a1000 = random.ints(1000, 1, 100).boxed().toArray( Integer[]::new );
        Integer[] a100000 = random.ints(100000, 1, 10000).boxed().toArray( Integer[]::new );
        Integer[] a1000000 = random.ints(200000, 1, 1000000).boxed().toArray( Integer[]::new );
        Integer[] a10000000 = random.ints(500000, 1, 10000000).boxed().toArray( Integer[]::new );
        Integer[] a100000000 = random.ints(1000000, 1, 100000000).boxed().toArray( Integer[]::new );

        print(a1000);
        print(a100000);
        print(a1000000);
        print(a10000000);
        print(a100000000);
    }

    public static void print(Comparable[] a){

        double time;
        Stopwatch s;

        Comparable[] clone = a.clone();
        s = new Stopwatch();
        MergeDown.sort(clone);
        time = s.elapsedTime();
        IO.println("Top-down sort N = " + a.length + ": " + time);

        s = new Stopwatch();
        MergeUp.sort(a);
        time = s.elapsedTime();
        IO.println("Bottom-Up sort N = " + a.length + ": " + time);

    }
}
