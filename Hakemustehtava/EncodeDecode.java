import java.util.Arrays;

public class EncodeDecode 
{
	String alphabet = "abcdefghijklmnopqrstuvwxyz";
	String[] key = new String[26];
	String returnString = new String();
	int i;
	StringBuilder sb = new StringBuilder();
	
		public EncodeDecode()
		{
			for(i = 1; i < 27; i++) /*When a new instance is created, we calculate the encoded value for each letter and store them in key[]*/
			{
				StringBuilder sb = new StringBuilder();
				
				if ( i % 2 == 0)
				{
					sb.append(Integer.toHexString((4*(32-i))-1));
				}
				else
				{
					sb.append(Integer.toHexString(i*2));
				}
				
				if (sb.length() == 1)
				{
					sb.insert(0, '0'); /*Pad with zero to make sure we get two digit numbers*/
				}
				
				key[i-1] = sb.toString(); /*With i-1 we make sure the letter index in the 
											alphabet-string is the same as its encoded value index in key[]*/
			}
			
		}
		
		public String Encode(String input) /*Method for decoding*/
		{
			for(i = 0; i < input.length(); i++) /*Loop trough each character in input string, first checking for special characters*/ 
			{
				if(input.charAt(i) == ' ')
				{
					sb.append("00");
				}
				else if(input.charAt(i) == ',')
				{
					sb.append("01");
				}
				else if(input.charAt(i) == '.')
				{
					sb.append("05");
				}
				else if(input.charAt(i) == '!')
				{
					sb.append("09");
				}
				else if(input.charAt(i) == '?')
				{
					sb.append("13");
				}
				else
				{
					sb.append(key[(alphabet.indexOf(input.charAt(i)))]); /*We get the encoded value from key[] using 
																		   the index of the letter in alphabet-string*/
				}

			}
			
			returnString = sb.toString();
			sb.delete(0, sb.length());   /*Empty the stringbuilder*/
			
			return returnString;
		}
		
		public String Decode(String input) /*Method for decoding*/
		{
														/*We assume all encoded hex values have two digits, so we take two chars at a time
														  and combine then to a single string */
			for (i = 0; i < input.length() ; i = i+2) 
			{
				String tmp = new StringBuilder().append(input.charAt(i)).append(input.charAt(i+1)).toString();
				
				if(tmp.equals("00")) 
				{
					sb.append(" ");
				}
				else if(tmp.equals("01"))
				{
					sb.append(",");
				}
				else if(tmp.equals("05"))
				{
					sb.append(".");
				}
				else if(tmp.equals("09"))
				{
					sb.append("!");
				}
				else if(tmp.equals("13"))
				{
					sb.append("?");
				}
				else
				{
					sb.append(alphabet.charAt(Arrays.asList(key).indexOf(tmp)));/*We get the letter from alphabet-string using 
					   															the index of the encoded value in key[]*/
				}
	
			}
			
			returnString = sb.toString();
			sb.delete(0, sb.length()); //Empty the stringbuilder
			
			return returnString;
		}
}
