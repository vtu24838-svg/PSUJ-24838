HackerLand University has the following grading policy:

Every student receives a  in the inclusive range from  to .
Any  less than  is a failing grade.
Sam is a professor at the university and likes to round each student's  according to these rules:

If the difference between the  and the next multiple of  is less than , round  up to the next multiple of .
If the value of  is less than , no rounding occurs as the result will still be a failing grade.
Examples

 round to  (85 - 84 is less than 3)
 do not round (result is less than 38)
 do not round (60 - 57 is 3 or higher)
Given the initial value of  for each of Sam's  students, write code to automate the rounding process.

Function Description

Complete the function  with the following parameter(s):

: the grades before rounding
Returns

: the grades after rounding
Input Format

The first line contains a single integer, , the number of students.
Each line  of the  subsequent lines contains a single integer, .

Constraints

Sample Input 0

4
73
67
38
33
Sample Output 0

75
67
40
33
Program:
import java.util.*;

class Result {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> res = new ArrayList<>();

        for (int g : grades) {
            if (g < 38) {
                res.add(g);
            } else {
                int rem = g % 5;
                if (rem >= 3) {
                    g += (5 - rem);
                }
                res.add(g);
            }
        }
        return res;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> grades = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            grades.add(sc.nextInt());
        }

        List<Integer> result = Result.gradingStudents(grades);

        for (int x : result) {
            System.out.println(x);
        }
    }
}
