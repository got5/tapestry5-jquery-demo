package org.got5.tapestry5.jquery.pages.mixins;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.corelib.components.Zone;

public class DocsConfirm {
	
	@SuppressWarnings("unused")
	@Persist
	@Property
	private int clickCount;
	
	@Component
	private Zone counterZone;
	
	@SetupRender
	public void init() {
		clickCount = 0;
	}
	
	@OnEvent(value=EventConstants.ACTION, component="actionLinkConfirm")
	public Object onActionFromActionLinkConfirm() {
		clickCount++;
		
		return counterZone.getBody();
	}
}
