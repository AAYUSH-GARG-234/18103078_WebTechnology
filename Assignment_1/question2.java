import java.util.*;
public class quest2 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter paragraph: ");
		String paragraph=input.nextLine();
		System.out.println("Enter vector's size: ");
		int vectorSize=input.nextInt();
		HashSet<String> vect=new HashSet<String>();
		System.out.println("Enter "+vectorSize+" Strings:");
		//taking string input
		for(int i=0;i<vectorSize;i++)
		{
			String s=input.next();
			vect.add(s);
		}
		input.close();
		int n =paragraph.length();
		int current=0;
		System.out.println("Paragraph after format:");
		String newParagraph="";
		while(current<n) 
		{
			String s="";
			while(current<n && paragraph.charAt(current)!=' ')
			{
				s+=paragraph.charAt(current);
				current++;
			}
			if(vect.contains(s))
			{
				newParagraph+=s.charAt(0);
				for(int i=1;i<s.length();i++)
				{
					newParagraph+='*';
				}
			}
			else
			{
				newParagraph+=s;
			}
			if(current<n && paragraph.charAt(current)==' ')
			{
				newParagraph+=" ";
			}
			current++;
		}
		System.out.println(newParagraph);
	}

}
