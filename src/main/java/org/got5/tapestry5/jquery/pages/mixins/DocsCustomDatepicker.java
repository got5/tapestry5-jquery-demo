package org.got5.tapestry5.jquery.pages.mixins;

import java.util.Date;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.json.JSONObject;

public class DocsCustomDatepicker {
	
	@Property
	private Date date;
	
	public JSONObject getParams(){
		return new JSONObject("nextText", "Next Month");
	}
}