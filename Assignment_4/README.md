QUESTIONS:


1. A farmer wants to reorganize the crops growing in his farm. The farm is in the form of an
N X M grid with each cell in the grid being a square plot. Each plot has to be planted with
a variety of crop. The farmer has 26 varieties of crops that he can plant. The plant varieties
are represented by lowercase English alphabets. He wants to follow the following condition
while planting: In each row, there must be at least 2 different varieties of crops (any number
of crops can be used in a column)No two nearby (Top, bottom, left, right) plots can have
the same variety of crops. Given the current state of the farm, find the minimum number
of plots that have to replant with a different crop so that the above conditions are satisfied.
Input The first line contains two integers N and M, the dimensions of the farm. The next N
lines contain M lowercase characters from‘a’ to ‘z’ representing the crop variety at that
plot. Output a single integer denoting the minimum number of plots that have to be
replanted in order to satisfy the conditions imposed.
code snippet:
import java.util.Scanner;
class Solution {
public static void main(String[] args)
{
int n;
Scanner in = new Scanner(System
n = in.nextInt();
in.nextLine();
String[] crops = new String[n];
for (int i=0;i<n;i++){
crops[i]=in.nextLine().trim
}

System.out.print(replant(crops)
}
public static int replant(String[] crops){
// Write your code here
// Return the number of replanted crops
return 0;
}
}
Example#1 Input 4 4 acaa dddd bbbb ccce Output 6 Explanation: In this Example, We may replant
the farm to look like: acac dede baba cece This arrangement of crop varieties satisfies the given
conditions and the cost of this replacement is 6.



2. The prgram starts with the int value -1, then casts the int to a byte, then to a char, and finally back to
an int. The first cast nar- rows the value from 32 bits down to 8, the second widens it from 8 bits to
16, and the final cast widens it from 16 bits back to 32. Does the value end up back where it started?
If you ran the program, you found that it does not.
