package by.epam.barkou.controller.multithread.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpHelper {

	
	public static boolean hasMatches(String pattern, String entryString){

	      Pattern r = Pattern.compile(pattern);

	      Matcher matcher = r.matcher(entryString);
	      if (matcher.find()) {
	    	 
	    		return true;
	      }else {
	    		return false;
	      }
	
		
	}
}
