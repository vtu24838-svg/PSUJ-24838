import java.util.*;
public class maxnum{
    public static int maxnumber(int arr[]){
        int max = arr[0];
        for(int i =1;i<arr.length;i++){
            if (arr[i]>max){
                max = arr[i];
            
            }
        }
        return max;
    }

public static void main (String[] args){
    Scanner sc = new Scanner (System.in);
    System.out.println("enter the elements ");
    int n = sc.nextInt();
    int arr[] = new int [n];
    for(int i =0;i<n;i++){
        arr[i] = sc.nextInt();
}
    int result = maxnumber(arr);
    System.out.println("the maximum number is " + result); 
}
}