import java.util.*;


public class ques6{		
    
    public static void Halistone(int n){
        System.out.print(n+" ");
        if(n==1)return;
        if(n%2==0)Halistone(n/2);
        else {Halistone(n*3 + 1);}
    }

    public static void main(String[] args)
    {
        Scanner input =new Scanner(System.in);

        System.out.println("Enter any N>0: ");

        int n=input.nextInt();
        if(n<=0)System.out.println("Invalid Input");
        else{Halistone(n);}
    }
}
