package canessa.seach.damaged;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/*
 * 
 */
public class Solution {

	/*
	 * Build multimap from long string
	 */
	static Multimap<String, Long> buildMultiMap(String longStr, int patternLen) {
		
		// **** ****
		Multimap<String, Long> multiMap = ArrayListMultimap.create();
		
		// **** loop once per pattern ****
		for (int i = 0; i < 26; i++) {
			
			// **** build pattern ****
			char c = (char) ((i % 26) + 'A');
			String pattern = buildPattern(patternLen, c);
			
			// ???? ????
			System.out.println("buildMultiMap <<< i: " + i + " pattern ==>" + pattern + "<==");

			// **** index all known patterns ****
			long index = 0;
			while (index != -1) {
				
				// **** search for pattern ****
				index = longStr.indexOf(pattern, (int)index);

				// ???? ????
				System.out.println("buildMultiMap <<< pattern ==>" + pattern + "<== index: " + index);
				
				// **** insert in multimap (if needed) ****
				if (index != -1)
					multiMap.put(pattern, index);
				else
					break;
				
				// **** increment index to skip current pattern ****
				index += 1;
			}
		}

		// **** ****
		return multiMap;
	}
	
	/*
	 * Build a pattern string with a specified pattern.
	 */
	static String buildPattern(int len, char c) {
		
		StringBuilder pattern = new StringBuilder();
		
		// **** ****
		while (len-- > 0) {
			pattern.append(c);
		}
		
		// **** ****
		return pattern.toString();
	}
	
	/*
	 * Build a long string with a set of patterns of the specified length.
	 */
	static String buildLongString(long len, int patternLen) {
		
		StringBuilder longStr = new StringBuilder();
		
		// ???? ????
		System.out.println("buildLongString <<< len: " + len + " patternLen: " + patternLen);
		
		// **** loop generating the patterns and appending them to the string ****
		for (int i = 0; i < len / patternLen; i++) {
			
			// **** build pattern ****
			char c = (char) ((i % 26) + 'A');
			String pattern = buildPattern(patternLen, c);
			
			// ???? ????
			System.out.println("buildLongString <<< pattern ==>" + pattern + "<==");
			
			// **** append pattern to long string ****
			longStr.append(pattern);
			
			// ???? ????
			System.out.println("buildLongString <<< longStr ==>" + longStr + "<==");
		}

		// **** ****
		return longStr.toString();
	}

	/*
	 * Test scaffolding.
	 */
	public static void main(String[] args) {
		
		final int 	PATTERN_LEN 	= 8;
		final long 	LONG_STR_LEN	= 1024;
		
		// **** build long string ****
		String longStr = buildLongString(LONG_STR_LEN, PATTERN_LEN);
		
		// ???? ????
		int len = longStr.length();
		System.out.println("main <<< len: " + len + " longStr ==>" + longStr + "<==");
		
		// **** build multimap using the long string ****
		Multimap<String, Long> multiMap = buildMultiMap(longStr, PATTERN_LEN);
		
		// ???? ????
		System.out.println("main <<< multiMap: " + multiMap.toString());
	}
	
}
