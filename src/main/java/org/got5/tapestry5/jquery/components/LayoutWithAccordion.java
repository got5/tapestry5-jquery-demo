//
// Copyright 2010 GOT5 (GO Tapestry 5)
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// 	http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package org.got5.tapestry5.jquery.components;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;

@Import(stack="themestack", stylesheet =
{ "context:css/layout/style.css" ,"context:css/demoSite.css"}
)
public class LayoutWithAccordion 
{
    @Parameter(required=true,defaultPrefix="literal")
    @Property
    private String title;

    @Inject
    private ComponentResources resources;

    @SuppressWarnings("unused")
    @Property
    @Parameter
	private int activeElement;

	@Inject
	private Messages messages;
	
	public String getHeadTitle(){ return getSeoDatas("Title"); }
	
	public String getKeywords(){ return getSeoDatas("Keywords"); }
	
	public String getDescription(){ return getSeoDatas("Description"); }
	
	private String getSeoDatas(String type){
		return messages.get(type);
	}
	
	public JSONObject getParams(){
		return new JSONObject("fillSpace", "true");
	}
}
