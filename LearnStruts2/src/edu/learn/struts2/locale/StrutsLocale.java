package edu.learn.struts2.locale;

import com.opensymphony.xwork2.DefaultTextProvider;

public class StrutsLocale {
	
	private static final long serialVersionUID = 1L;
	
	private static DefaultTextProvider textProvider = new DefaultTextProvider();
	
	public static String getText(String key) {
//		System.out.println("key: " + key);
		return textProvider.getText(key);
	}
}
