package lab2;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;


public class LAB2 {


    public static void main(String[] args)
    {
        benchmark (8, 10, 0);
    }
    
    
    public static void benchmark(int x, int y, int z)
    {
        // Then you call  the method
        int [][] myTests =  getArray(x,y,z);
        for (int []vector : myTests )
        {
            Arrays.sort(vector);
            myMethod(vector);
        }
        
    }
    
    public static int[][] getArray(int x, int y, int z)
    {
        //return IntStream.range(0, x).parallel().map(i->1).toArray()).toArray(int[][]::new);
        return IntStream.range(0, x).parallel().mapToObj(i-> new Random().ints(1*i*(int)Math.pow(y, 7), -50000, 100000).sorted().toArray()).toArray(int[][]::new);
    }
    
    
    public static void myMethod (int [] input)
    {
        
        // Then you time when the method finishes
        // First you count the start time
        //int[] A = sort1(input);
        Integer[] A = convertInt(input);
        Arrays.sort(A);
        long start = System.nanoTime();
        //Arrays.sort(input);
        //
        bubbleSort(A);
        long finish = System.nanoTime();
        // Then you solve for the actual execution time
        long algTime =  finish - start;
        System.out.println(algTime);//input.length algTime
    }
        public static Integer[] convertInt(int[] input) {
        Integer[] result = new Integer[input.length];
        for(int i = 0; i < input.length; i+=1){
            result[i] = input[i];
            
        }
        bubbleSort(result);
        return result;
    }
        public static <E extends Comparable<? super E>> void bubbleSort(E[] comparable) {
    boolean changed = false;
    //long start = System.nanoTime();
    do {
        changed = false;
        for (int a = 0; a < comparable.length - 1; a++) {
            if (comparable[a].compareTo(comparable[a + 1]) > 0) {
                E tmp = comparable[a];
                comparable[a] = comparable[a + 1];
                comparable[a + 1] = tmp;
                changed = true;
            }
        }
    } while (changed);
        //long finish = System.nanoTime();
        //long algTime =  finish - start;
        //System.out.println(algTime);
        //Arrays.sort(comparable);
        //bubbleSort(comparable);
        
}

}
/*    int [] sort(int [] input){
        return Arrays.sort(input);
    }