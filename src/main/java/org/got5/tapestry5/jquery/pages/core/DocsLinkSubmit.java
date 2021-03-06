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

package org.got5.tapestry5.jquery.pages.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;

public class DocsLinkSubmit
{
	@Property
    @Persist
    @Validate("required,minlength=5")
    private String name;
	
	@Property
	private String value;
	
	@Property
	@Persist
	private List<String> listOfNames;
	
	public void onActivate(){
		if(listOfNames==null) listOfNames = new ArrayList<String>();
	}
	
    void onSelectedFromSend() 
    { 
    	listOfNames.add(name);
    }
}
