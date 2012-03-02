package org.got5.tapestry5.jquery.pages.mixins;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

public class DocsBind {
	@Inject
	private Logger logger;

	@Property
	@Persist
	private String textZone;
	
	@InjectComponent
	private Zone zoneSlideChange;
	
	@OnEvent(value="slidechange")
	public Object onSlideChange(String value) {
		textZone = "The SlideChange event was triggered.";
		return zoneSlideChange.getBody();
	}
}