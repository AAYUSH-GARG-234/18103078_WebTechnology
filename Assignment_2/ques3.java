import java.util.Arrays;
import java.util.Scanner;

public class ques3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string: ");
        String str = sc.nextLine();

        char[] array = str.toChararray();
        for(int i=0; i < array.length; i++) {
            for(int j=i+1; j < array.length; j++) {
                if((int)array[j] < (int)array[i]) {
                    char temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        s = new String(arr);
        System.out.println("sorted string: " + s);
    }
}
