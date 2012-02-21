package org.got5.tapestry5.jquery.services;

import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.model.MutableComponentModel;
import org.apache.tapestry5.plastic.MethodAdvice;
import org.apache.tapestry5.plastic.MethodInvocation;
import org.apache.tapestry5.plastic.PlasticClass;
import org.apache.tapestry5.plastic.PlasticMethod;
import org.apache.tapestry5.services.AssetSource;
import org.apache.tapestry5.services.TransformConstants;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.apache.tapestry5.services.transform.ComponentClassTransformWorker2;
import org.apache.tapestry5.services.transform.TransformationSupport;

public class IndicatorWorker implements ComponentClassTransformWorker2{

	private AssetSource as;
	private JavaScriptSupport js;
	
	public IndicatorWorker(AssetSource as, JavaScriptSupport js) {
		super();
		this.as = as;
		this.js = js;
	}

	public void transform(PlasticClass plasticClass,
			TransformationSupport support, MutableComponentModel model) {
		if(plasticClass.getClassName().contains("ProgressiveDisplay")){
			
			PlasticMethod afterRender = plasticClass.introduceMethod(TransformConstants.AFTER_RENDER_DESCRIPTION);
			
			afterRender.addAdvice(new MethodAdvice() {
				
				public void advise(MethodInvocation invocation) {
					invocation.proceed();
					js.importStylesheet(as.getClasspathAsset("org/got5/tapestry5/jquery/assets/mixins/reveal/reveal.css"));
					js.importJavaScriptLibrary(as.getClasspathAsset("org/got5/tapestry5/jquery/assets/mixins/reveal/jquery.reveal.js"));
					js.importJavaScriptLibrary(as.getContextAsset("js/other/indicator.js", null));
					js.addInitializerCall("indicator", new JSONObject());
					
				}
			});
			
			model.addRenderPhase(AfterRender.class);
			
		}
		
	}
}
