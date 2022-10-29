package com.challenge.utils;

import java.util.HashMap;
import java.util.Map;

import com.challenge.pages.*;

public final class PageObjectHandler {
	private static PageObjectHandler instance = new PageObjectHandler();
	private ThreadLocal <Map<String, Object>> threadPagesContainer = new ThreadLocal <Map<String, Object>>();
	private final String packageName = AutoTool.getSetupValue("PageObjectsPackage");
	
    private PageObjectHandler() {
    }

    public static PageObjectHandler getInstance() {
        return instance;
    }
    

	public void setThreadPagesContainer() {
		threadPagesContainer.set(new HashMap<String, Object>());
	}

	public void removeThreadPagesContainer() {
		threadPagesContainer.remove();
	}
	

	private Object getPageObjectByClassName(String pageObjectType) {
		String classCanonicalName = packageName+pageObjectType;
		try {
			Class<?> cls = Class.forName(classCanonicalName);
			threadPagesContainer.get().putIfAbsent(pageObjectType, cls.getDeclaredConstructor().newInstance());
		} catch (Exception exp) {
			System.out.println("There is no page object defined with class "+classCanonicalName);
			exp.printStackTrace();
		}
		return threadPagesContainer.get().get(pageObjectType);
	}

	public YourLogoHome yourLogoHome(){
		return (YourLogoHome) getPageObjectByClassName("YourLogoHome");
	}

	public YourLogoAuth yourLogoAuth(){
		return (YourLogoAuth) getPageObjectByClassName("YourLogoAuth");
	}

	public YourLogoCatalog yourLogoCatalog(){
		return (YourLogoCatalog) getPageObjectByClassName("YourLogoCatalog");
	}
}