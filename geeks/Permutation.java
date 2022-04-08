package geeks;

import java.util.*;

public class Permutation {
	public static void main(String[] args) {
		String S = "atn";
		List<String> list = new ArrayList<>();
  
		permute(S, " ", list);
		System.out.println(list);
	}

	static void permute(String str, String input, List<String> list) {
		if (str.length() == 0) {
			list.add(input);

		}
		for (int i = 0; i < str.length(); i++) 
		{
			char ch = str.charAt(i);
			String text = str.substring(0, i) + str.substring(i + 1);
			permute(text, input + ch, list);

		}
	}
}

