package org.got5.tapestry5.jquery.pages.mixins;

import org.apache.tapestry5.annotations.OnEvent;
import org.got5.tapestry5.jquery.JQueryEventConstants;

public class DocsSortable {
	
	@OnEvent(JQueryEventConstants.SORTABLE)
	public void onSort(String sorted_value){
		System.out.println(sorted_value);
	}
}