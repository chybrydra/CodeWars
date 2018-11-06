/* 5kyu
being given a number of seconds, convert it to HH:MM:SS form
H - hour, M - minut, S - second
*/

public class HumanReadableTime {
	public static String makeReadable(int seconds) {
		String result = "";
		int sec =	seconds % 60;
		int min = (seconds / 60) % 60;
		int hr = seconds / 3600;
		
		if (hr>=10) result+=String.valueOf(hr)+":";
		else result+="0"+String.valueOf(hr)+":";
		
		if (min>=10) result+=String.valueOf(min)+":";
		else result+="0"+String.valueOf(min)+":";
		
		if (sec>=10) result+=String.valueOf(sec);
		else result+="0"+String.valueOf(sec);
		
	return result;
	}
}