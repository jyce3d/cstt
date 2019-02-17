package be.sdlg.webapps.utils;

public class Helper {
	public static String addOnceTo(String strTarget,  String str) {
		String result="";
		if (strTarget =="")
			return str;
		String[] arr= strTarget.split(",");
		for (String a: arr) {
			if (a.equals(str)) {
				result =  strTarget;
				break;
			} else {
				result= strTarget+",";
			}
		}
		return result;
	} 
}
