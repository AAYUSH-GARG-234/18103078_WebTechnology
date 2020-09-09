import java.util.Scanner;

public class ques2{		

    public static void main(String[] args)
    {
        Scanner input =new Scanner(System.in);

        System.out.println("Enter size of input stream of Elements: ");
        int size_var=input.nextInt();

        int[] array = new int[21];
        for(int i=0;i<size_var;i++){
            System.out.print("enter integer: ");
            int x = input.nextInt();
            if(x<0||x>20){
                System.out.println("Invalid input");
                break;
            }
            array[x]++;
        }
       
        System.out.println("Sorted Order is: ");
        for(int j=0;j<=20;j++){	
            while(array[j]>0){
                array[j]--;
            System.out.print(j+" ");
            }
        }    
        input.close();
    }
}
