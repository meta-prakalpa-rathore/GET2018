package strings;


/**
 * this class performs operations on strings without using Java API
 * @author Prakalpa-Rathore
 *
 */
public class MyString {

	
	/**
	 * compares two strings for equality
	 * @param string1
	 * @param string2
	 * @return 1 if equal, 0 otherwise
	 */
	public int compareString(String string1, String string2)
	{
		int equal = 0;
		
		if(string1.length() == string2.length())
		{
			equal = 1;
			for(int i=0; i<string1.length(); i++)
			{
				if(string1.charAt(i) != string2.charAt(i))
				{
					equal = 0;
					break;
				}
			}
		}
		
		return equal;
	}
	
	
	/**
	 * generates the reverse of a string
	 * @param originalString
	 * @return reverse of the originalString
	 */
	public String reverseString(String originalString)
	{
		String reverseString = "";
		
		for(int i=originalString.length()-1; i>=0; i--)
		{
			reverseString += originalString.charAt(i);	
		}
		
		return reverseString;
	}
	
	
	/**
	 * converts lowercase characters in a string to uppercase characters and vice versa
	 * @param originalString
	 * @return convertedString
	 */
	public String convertString(String originalString)
	{
		String convertedString = "";
		
		for(int i=0; i<originalString.length(); i++)
		{
			if(originalString.charAt(i) >= 'a' && originalString.charAt(i) <= 'z')
				convertedString += (char)(originalString.charAt(i)-32);
			else
				if(originalString.charAt(i) >= 'A' && originalString.charAt(i) <= 'Z')
					convertedString += (char)(originalString.charAt(i)+32);
				else
					convertedString += originalString.charAt(i);
		}
		
		return convertedString;
	}
	
	
	/**
	 * finds the largest word in a string
	 * @param string
	 * @return largest word in the string
	 */
	public String largestWord(String string)
	{
		String largestWord="";
		
		for(String word:string.split(" "))
		{
			if(word.length() > largestWord.length())
				largestWord = word;
		}
		
		return largestWord;
	}
}
