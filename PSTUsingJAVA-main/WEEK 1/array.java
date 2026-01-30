import java.util.Scanner;
public class array{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a =new int[n];
        System.out.println("enter the elements of the array");
        for (int i = 0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int j = sc.nextInt();
        System.out.println("elements at index" +j+"is"+a[j]);
        
    }
}
