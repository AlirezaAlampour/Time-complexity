package LAB2;

import java.util.Arrays;

public class Sort {
   int[] A;
  public Sort(int[]input){
      this.A = input;
      doSort(A);
  }
  public void doSort(int[] A){
      for(int i=A.length-1;i>0;i--){
          for(int j=0;j<i;j++){
            if(A[j]>A[j+1]){
              swapValues(j,j+1);
              System.out.print("\n"+Arrays.toString(A));
            }  

          }
      }
  } 
  public void swapValues(int a, int b){
       int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
   }
}
