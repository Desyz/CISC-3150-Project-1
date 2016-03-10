import java.io.*;
import java.util.Scanner;

public class ReverseWords {

	public static void main(String[] args) {
		try {		
			Scanner sc = new Scanner(new File("B-small-practice.in"));
			int TC = sc.nextInt();
			sc.nextLine();
			for (int i = 1; i <= TC; i++) {
				String words = sc.nextLine();
				System.out.printf("Case #%d: %s\n", i, reverseWords(words.split(" ")));
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String reverseWords(String[] str) {
		String s = "";
		for (int i = str.length - 1; i >= 0; i--)
			s += str[i] + " ";
		return s;
	}

}
