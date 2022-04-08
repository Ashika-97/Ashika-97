package Stringsetgeeks2;

public class RemoveCharacter {
   
	public static void main(String[] args)
	{
		String text1="computer";
		String text2="cat";
		String result="";
		String letter="";
		for(int i=0;i<text1.length();i++)
		{
			letter=""+ text1.charAt(i);
			if(!text2.contains(letter))
			{
				result=result+text1.charAt(i);
			}
		}
		System.out.println("the string is "+ result);
    }
}

