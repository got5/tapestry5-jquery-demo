package org.got5.tapestry5.jquery.pages.other;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

public class ProgressiveDisplayWithModal {
	
	@Inject
	private JavaScriptSupport js;
	
	@Inject
	private Block block;
	
	@OnEvent(EventConstants.PROGRESSIVE_DISPLAY)
	public Object returnBlock() throws InterruptedException{
		Thread.sleep(2000);
		return block;
	}
}
