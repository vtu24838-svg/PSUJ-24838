import java.util.*;
public class binary{
    public static int binarysearch(int arr[],int target){
        int left = 0;
        int right = arr.length -1;
        while(left<=right){
            int mid = (left+right)/2;
            if (arr[mid] == target){
                return mid;
            }
            else if (arr[mid]<target){
                left = mid +1;
            }
            else{
                right = mid -1;
            }
        }
        return -1;  
        
    }
    public static void main(String[] args){
        int arr[] = {2,3,4,10,40};
        int target = 2;
        int result = binarysearch (arr,target);
        if(result == -1){
            System.out.println("elemnts not found");
        }
        else{
            System.out.println("element found at index" + result);
        }
    }
}