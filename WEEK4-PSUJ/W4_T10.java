import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */

    public static void matrixRotation(List<List<Integer>> matrix, int r) {

    int m = matrix.size();
    int n = matrix.get(0).size();

    int layers = Math.min(m, n) / 2;

    for (int layer = 0; layer < layers; layer++) {

        List<Integer> list = new ArrayList<>();

        int top = layer, left = layer;
        int bottom = m - 1 - layer, right = n - 1 - layer;

        // top row
        for (int j = left; j <= right; j++)
            list.add(matrix.get(top).get(j));

        // right column
        for (int i = top + 1; i < bottom; i++)
            list.add(matrix.get(i).get(right));

        // bottom row
        for (int j = right; j >= left; j--)
            list.add(matrix.get(bottom).get(j));

        // left column
        for (int i = bottom - 1; i > top; i--)
            list.add(matrix.get(i).get(left));

        int size = list.size();
        int shift = r % size;

        Collections.rotate(list, -shift);

        int idx = 0;

        // put back
        for (int j = left; j <= right; j++)
            matrix.get(top).set(j, list.get(idx++));

        for (int i = top + 1; i < bottom; i++)
            matrix.get(i).set(right, list.get(idx++));

        for (int j = right; j >= left; j--)
            matrix.get(bottom).set(j, list.get(idx++));

        for (int i = bottom - 1; i > top; i--)
            matrix.get(i).set(left, list.get(idx++));
    }

    // print
    for (List<Integer> row : matrix) {
        for (int val : row)
            System.out.print(val + " ");
        System.out.println();
    }
}


}

public class W4_T10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
