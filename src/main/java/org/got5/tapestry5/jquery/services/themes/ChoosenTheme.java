package org.got5.tapestry5.jquery.services.themes;

import org.apache.tapestry5.ioc.annotations.Inject;

public class ChoosenTheme {
	@Inject
	public ChoosenTheme() {
		super();
		themeName = "jqueryui_southstreet";
	}

	public ChoosenTheme(String theme) {
		super();
		this.themeName = theme;
	}

	private String themeName;
	
	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	@Override
	public String toString() {
		return themeName;
	}
}
