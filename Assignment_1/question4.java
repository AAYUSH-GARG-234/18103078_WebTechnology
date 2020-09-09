import java.util.*;
public class question4 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter String 1 in lowercase characters :");
		String string1=input.next();
		System.out.println("Enter String 2 in lowercase characters:");
		String string2=input.next();
		input.close();
		//check whether length of both strings are same or not
		if(string1.length()!=string2.length())
		{
			System.out.println("Given strings are not Anagram");
			return;
		}
		//calculating frequency of each character in both strings
		int[] arr=new int[26];
		for(int i=0;i<string1.length();i++)
		{
			arr[string1.charAt(i)-'a']++;
			arr[string2.charAt(i)-'a']--;
		}
		//final check of the array that whether all indexes become zero or not
		for(int i=0;i<26;i++)
		{
			if(arr[i]!=0)
			{
				System.out.println("Given strings are not Anagram");
				return;
			}
		}
		
		System.out.println("Given Strings are Anagram!");
	}

}
