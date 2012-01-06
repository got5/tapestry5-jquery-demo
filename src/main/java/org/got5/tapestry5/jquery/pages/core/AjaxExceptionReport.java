package org.got5.tapestry5.jquery.pages.core;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.corelib.components.Zone;


public class AjaxExceptionReport {
	
	@Component
	private Zone zone;
	
	@OnEvent(value=EventConstants.ACTION, component="ajax")
	public Object displayException(){
		
		String error = null;
		System.out.println(error.contains("error"));
		
		return zone;
	}
}
