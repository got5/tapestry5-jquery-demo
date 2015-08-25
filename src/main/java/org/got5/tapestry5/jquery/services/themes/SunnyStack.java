package org.got5.tapestry5.jquery.services.themes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.services.AssetSource;
import org.apache.tapestry5.services.javascript.JavaScriptAggregationStrategy;
import org.apache.tapestry5.services.javascript.JavaScriptStack;
import org.apache.tapestry5.services.javascript.StylesheetLink;

public class SunnyStack implements JavaScriptStack{

	private final AssetSource assetSource;
	
	public SunnyStack(final AssetSource assetSource)
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
		css.add(new StylesheetLink(assetSource.getContextAsset("css/sunny/jquery-ui-1.8.19.custom.css", null)));
		return css;
	}

	public String getInitialization() {
		return null;
	}

	public JavaScriptAggregationStrategy getJavaScriptAggregationStrategy() {
		return org.apache.tapestry5.services.javascript.JavaScriptAggregationStrategy.COMBINE_AND_MINIMIZE;
	}

	public List<String> getModules() {
		return Collections.emptyList();
	}


}
