package org.got5.tapestry5.jquery.pages.other;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.json.JSONObject;

@Import(stylesheet = "context:css/colorbox.css")
public class DocumentViewer {
	
	public JSONObject getParams(){
		JSONObject json = new JSONObject();
		json.put("iframe", true);
		json.put("width", "80%");
		json.put("height", "80%");
		return json;
	}
}
