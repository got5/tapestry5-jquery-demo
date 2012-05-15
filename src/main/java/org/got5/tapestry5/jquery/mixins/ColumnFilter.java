package org.got5.tapestry5.jquery.mixins;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectContainer;
import org.apache.tapestry5.annotations.MixinAfter;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.InitializationPriority;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.got5.tapestry5.jquery.components.DataTable;

@MixinAfter
@Import(library = {"context:js/other/ColumnFilter/jquery.dataTables.columnFilter.js", 
		"context:js/other/ColumnFilter/demo.js"})
public class ColumnFilter {
	
	@Parameter
	private JSONObject filterJson;
	
	@Inject
	private JavaScriptSupport js;
	
	@InjectContainer
	private DataTable table;
	
	public void afterRender(){
		
		JSONObject opt = new JSONObject();
		opt.put("id", table.getClientId());
		opt.put("options", filterJson);
		
		js.addInitializerCall(InitializationPriority.LATE, "columnFilter", opt);
		js.addInitializerCall(InitializationPriority.EARLY, "addHeader", opt);
	}
	
}
