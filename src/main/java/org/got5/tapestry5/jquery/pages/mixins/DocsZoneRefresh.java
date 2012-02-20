//
// Copyright 2010 GOT5 (Gang Of Tapestry 5)
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

package org.got5.tapestry5.jquery.pages.mixins;

import java.util.Date;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

public class DocsZoneRefresh
{
	
	@Inject
	private JavaScriptSupport js;
	
	 public Date getNow()
	 {
		 return new Date();
	 }
	 
	/**
	* Add handlers method to the links, in order to stop/start refreshing the zone.
	*/
	public void afterRender(){
		js.addScript("$(\"#stop\").bind(\"click\", function(){$(\"#clickZone\").trigger(\"stopRefresh\");});");
		js.addScript("$(\"#start\").bind(\"click\", function(){$(\"#clickZone\").trigger(\"startRefresh\");});");
	}
}
