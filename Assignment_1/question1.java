import java.util.Scanner;
public class question1{
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the textString in lower case : ");
		String textString=input.next();
		System.out.println("Enter the substring in lowercase : ");
		String subString=input.next();
		int subLength=subString.length();
		int textStringLenght =textString.length();
		input.close();
		System.out.print("Answer is : ");

		if(textStringLenght <subLength)
		{
			System.out.println(0);
			return;
		}
		int[] arrayA=new int[26];
		int ans=0;
		for(int i=0;i<subLength;i++)
		{
			arrayA[textString.charAt(i)-'a']++;
			arrayA[subString.charAt(i)-'a']--;
		}
		if(areAllZeroes(arrayA))
		{
			ans++;
		}
		for(int i=subLength;i<textStringLenght ;i++)
		{
			arrayA[textString.charAt(i-subLength)-'a']--;
			arrayA[textString.charAt(i)-'a']++;
			if(areAllZeroes(arrayA))
				ans++;
		}
		System.out.println(ans);
	}
	public static boolean areAllZeroes(int[] arrayA)
	{
		for(int i=0;i<26;i++)
		{
			if(arrayA[i]!=0)
				return false;
		}
		return true;
	}
}
