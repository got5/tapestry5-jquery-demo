package org.got5.tapestry5.jquery.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.services.AssetSource;
import org.apache.tapestry5.services.javascript.JavaScriptStack;
import org.apache.tapestry5.services.javascript.StylesheetLink;

public class SmoothnessStack implements JavaScriptStack{

	private final AssetSource assetSource;
	
	public SmoothnessStack(final AssetSource assetSource)
	{
		this.assetSource = assetSource;
	}
	
	public List<String> getStacks() {
		return Collections.EMPTY_LIST;
	}

	public List<Asset> getJavaScriptLibraries() {
		return Collections.EMPTY_LIST;
	}

	public List<StylesheetLink> getStylesheets() {
		List<StylesheetLink> css = new ArrayList<StylesheetLink>();
		css.add(new StylesheetLink(assetSource.getContextAsset("css/smoothness/jquery-ui.css", null)));
		return css;
	}

	public String getInitialization() {
		return null;
	}

}
