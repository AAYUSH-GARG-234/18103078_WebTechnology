import java.util.*;

public class ques1{		

    public static int compare(String st1,String st2)
    {
        int n = st1.length() > st2.length() ? st2.length() : st1.length();
        for(int i=0;i<n;i++){
            if((int)st1.charAt(i)!=(int)st2.charAt(i))
                return (int)st1.charAt(i)-(int)st2.charAt(i);
        }	
            return st1.length()-st2.length();

    }

    public static void main(String[] args){
        Scanner input =new Scanner(System.in);

        System.out.println("Enter 1st string:");
        String st1=input.nextLine();
        System.out.println("Enter 2nd string:");
        String st2=input.nextLine();
        int a=compare(st1,st2);
        
        if (a > 0)
                System.out.println(String.format("'%s' is lexographically greater than '%s'", st1, st2));
            else if (a < 0)
                System.out.println(String.format("'%s' is lexographically smaller than '%s'", st1, st2));
            else {
                System.out.println(String.format("'%s' is lexographically equal to '%s'", st1, st2));
            }
            input.close();
    }
}
