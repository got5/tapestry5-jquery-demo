package org.got5.tapestry5.jquery.pages.mixins;

import java.util.Date;

import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.json.JSONObject;

public class DocsCustomDatepicker {
	
	@Property
	private Date date;
	
	@Log
	public JSONObject getParams(){
		return new JSONObject("nextText", "Next Month");
	}
}