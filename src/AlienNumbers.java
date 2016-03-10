import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AlienNumbers {

	public static void main(String[] args) {
		try {
			BufferedReader fin = new BufferedReader(new FileReader(args[0]));
			//First line is number of cases
			int TC = Integer.parseInt(fin.readLine());
			int firstIndex, lastIndex;
			String Buffer,num;
			char[] TB, AB;
			for (int i = 1; i <= TC; i++) {
				Buffer = fin.readLine();
				firstIndex = Buffer.indexOf(" ");
				lastIndex = Buffer.lastIndexOf(" ");
				num = Buffer.substring(0, firstIndex);
				TB = Buffer.substring(firstIndex + 1, lastIndex).toCharArray();
				AB = Buffer.substring(lastIndex + 1).toCharArray();
				System.out.printf("Case #%d: %s\n", i, toAlienBase(toDecimal(num,TB), AB));
			}
			
			fin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static int toDecimal(String targetNum, char[] targetBase) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int TB = targetBase.length;
		for (Integer i = 0; i < targetBase.length; i++)
			map.put(targetBase[i], i);
		if ( targetNum.length() == 1 && map.get(targetNum.charAt(0)) == 0 )	
			return 0;
		int base10 = 0;
		for (int i = 0; i < targetNum.length(); i++) {
			base10 += map.get(targetNum.charAt(i)) * Math.pow(TB, targetNum.length() - i - 1);
		}
		return base10;
	}
	
	public static String toAlienBase(int base10Num, char[] targetNum) {
		Map<Integer, Character> map = new HashMap<Integer, Character>();
		int base = targetNum.length;
		for (Integer i = 0; i < targetNum.length; i++)
			map.put(i, targetNum[i]);
		String str = "";
		int index;
		while (base10Num != 0) {
			index = base10Num % base;
			base10Num /= base;
			str = map.get(index) + str;
		}
		return str;
	}

}
