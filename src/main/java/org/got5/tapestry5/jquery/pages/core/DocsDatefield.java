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

package org.got5.tapestry5.jquery.pages.core;

import java.util.Date;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.ajax.MultiZoneUpdate;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.DateField;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;

public class DocsDatefield
{	
	@Persist
	@Property
	private int activePanel;
	
    public void onActivate(){
		if (_firstName == null && _lastName == null) {
			_firstName = "Humpty";
			_lastName = "Dumpty";
		}
	}
	
	
	public void onSubmitFromSimpleDate(){
		activePanel=1;
	}
/**simple page ****************************************************/
@Persist
@Property
private Date date;
    
/**AjaxForm ****************************************************/
@Property
private String _firstName;

@Property
private String _lastName;
	
@Property
private Date birthdayAjax;
	
@Component
private Form ajaxForm;
    
@Component(id = "BirthdayAjax",parameters ={"validate=required"})
private DateField df;
    
@Component(id = "firstName")
private TextField _firstNameField;
    
@Component(id = "lastName")
private TextField _lastNameField;

@Component(id="nameZone")
private Zone nameZone;
	
@Component(id="formZone")
private Zone formZone;

@Inject
private AjaxResponseRenderer renderer;

@OnEvent(value = EventConstants.VALIDATE, component="ajaxForm")
void onValidateAjaxForm() {
	if (_firstName == null || _firstName.trim().equals("")) {
		ajaxForm.recordError(_firstNameField, "First Name is required.");
	}
	if (_lastName == null || _lastName.trim().equals("")) {
		ajaxForm.recordError(_lastNameField, "Last Name is required.");
	}
		
	if(birthdayAjax==null){
		ajaxForm.recordError(df, "You must provide a value for the Birthday");
	}
	else
	{
		Date now = new Date();
		if(birthdayAjax.after(now))
		{
			ajaxForm.recordError(df, "invalid birthday");
		}
	}
}

@OnEvent(value = EventConstants.SUCCESS, component="ajaxForm")
void onSuccessAjaxForm() {
	renderer.addRender(nameZone).addRender(formZone);
}
	
void onFailure() {
	renderer.addRender(formZone).addRender(nameZone);
}

public String getName() {
	return _firstName + " " + _lastName;
}
}
