package org.got5.tapestry5.jquery.components;

import java.util.TreeMap;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.internal.TapestryInternalUtils;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.apache.tapestry5.services.javascript.JavaScriptStackSource;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.got5.tapestry5.jquery.services.ChoosenTheme;

@Import(library="ThemeSwitcher.js")
public class ThemeSwitcher {
	
	@SessionState
	private ChoosenTheme choosen;
	private boolean choosenExists;
	
	@Property
	private String theme;
	
	@Parameter (value="FALSE")
	@Property
    private Boolean labelVisible;
	
	
	@Inject
	private JavaScriptSupport javascriptsupport;
	
	@Inject
	private JavaScriptStackSource stackSource;
	
	@Inject
	private Messages messages;
	
	@Inject
	private ComponentResources cr;
	
	@Inject
	private PageRenderLinkSource prls;
	
	@Parameter
	private String urlParam; 
	
	@SetupRender
	public void init(){
		
		theme = choosen.getThemeName();
		
	}
	
	@AfterRender
	public void finish(){
		javascriptsupport.addInitializerCall("themeswitcher",new JSONObject());
	}
	
	
	private TreeMap<String,String> getThemeStacks(){
		
		TreeMap<String,String> stacks = new TreeMap<String, String>();
		
		for(String name : stackSource.getStackNames()){
			if(name.startsWith("jqueryui_"))
				stacks.put(name, messages.get(name));
		}
		
		return stacks;
		
	}
	
	public SelectModel getThemeModel(){
		return TapestryInternalUtils.toSelectModel(getThemeStacks());
	}
	
	
	@OnEvent(EventConstants.SUCCESS)
	public Link changeTheme(){
		String themeName = theme.substring("jqueryui_".length());
		choosen = new ChoosenTheme(theme);
			
		return prls.createPageRenderLink(cr.getPageName());
	}
}
