package pst;
import java.util.*;

public class task8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Input array
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Window size
        int k = sc.nextInt();

        int[] result = maxSlidingWindow(nums, k);

        // Print result
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i != result.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[0];

        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            // Remove indices out of window
            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }

            // Remove smaller elements
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.offer(i);

            // Store result when window is full
            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peek()];
            }
        }

        return res;
    }
}
