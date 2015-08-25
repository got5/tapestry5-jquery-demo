package org.got5.tapestry5.jquery.services.themes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ApplicationStateManager;
import org.apache.tapestry5.services.javascript.JavaScriptAggregationStrategy;
import org.apache.tapestry5.services.javascript.JavaScriptStack;
import org.apache.tapestry5.services.javascript.JavaScriptStackSource;
import org.apache.tapestry5.services.javascript.StylesheetLink;

public class ThemeStackSwitcher implements JavaScriptStack{

	private ApplicationStateManager asm;
	private JavaScriptStackSource jss;
	
	public ThemeStackSwitcher(@Inject final ApplicationStateManager asm,@Inject final JavaScriptStackSource jss) {
		super();
		this.asm = asm;
		this.jss = jss;
	}
	
	private ChoosenTheme getThemeInSession(){
		ChoosenTheme ct = asm.get(ChoosenTheme.class);
		return ct;
	}
	
	public List<String> getStacks() {
		List<String> stacks = new ArrayList<String>();
		ChoosenTheme ct = getThemeInSession();
		if(jss.getStack(ct.getThemeName())!=null){
			stacks.add(ct.getThemeName());
		}
		return stacks;
	}

	public List<Asset> getJavaScriptLibraries() {
		return Collections.emptyList();
	}

	public List<StylesheetLink> getStylesheets() {
		return Collections.emptyList();
	}

    public List<String> getModules() {
    	return Collections.emptyList();
    }

    public JavaScriptAggregationStrategy getJavaScriptAggregationStrategy() {
    	return org.apache.tapestry5.services.javascript.JavaScriptAggregationStrategy.COMBINE_AND_MINIMIZE;
    }

    public String getInitialization() {
		return null;
	}

}
