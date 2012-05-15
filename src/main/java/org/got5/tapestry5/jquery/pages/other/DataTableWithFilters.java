//
// Copyright 2010 GOT5 (GO Tapestry 5)
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package org.got5.tapestry5.jquery.pages.other;

import java.util.List;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.beaneditor.BeanModel;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.services.TypeCoercer;
import org.apache.tapestry5.json.JSONArray;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.AssetSource;
import org.apache.tapestry5.services.BeanModelSource;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.apache.tapestry5.services.TranslatorSource;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.got5.tapestry5.jquery.data.Celebrity;
import org.got5.tapestry5.jquery.data.CelebritySource;
import org.got5.tapestry5.jquery.data.IDataSource;
import org.got5.tapestry5.jquery.data.OverrideDataTableModel;
import org.got5.tapestry5.jquery.internal.DataTableModel;
import org.got5.tapestry5.jquery.internal.TableInformation;

@Import(stylesheet ={ "context:dataTables/css/demo_table_jui.css",
					  "context:dataTables/css/demo_page.css",	
					  "context:dataTables/css/demo_table.css",
					  "context:dataTables/TableTools/css/TableTools.css"})
public class DataTableWithFilters
{
	@SessionState
	private IDataSource dataSource;
	
	@Property
	private Celebrity celebrity;
	
	private CelebritySource celebritySource;
	
	@Inject
	private ComponentResources resources;

	@Inject
	private BeanModelSource beanModelSource;
	
	@Property
	private Celebrity current;
	
	@SuppressWarnings("unchecked")
	private BeanModel model;
	
	@Inject
	private JavaScriptSupport js;
	
	@Inject
	private AssetSource as;
	
	@Inject
	private TypeCoercer typeCoercer;

	@Inject
	private TranslatorSource ts;
	
	@Inject 
	private PageRenderLinkSource linkSource;
	
	@Property
	private final DataTableModel override = new OverrideDataTableModel(typeCoercer, ts, resources, linkSource);
	
	public GridDataSource getCelebritySource() {
		if(celebritySource==null)
			celebritySource = new CelebritySource(dataSource);
		return celebritySource;
	}

	public List<Celebrity> getAllCelebrities() {
		System.out.println("Getting all celebrities...");
		return dataSource.getAllCelebrities();
	}

	@SuppressWarnings("unchecked")
	public BeanModel getModel() {
		this.model = beanModelSource.createDisplayModel(Celebrity.class,
						resources.getMessages());
		this.model.get("firstName").sortable(false);
		return model;
	}
	
	public JSONObject getOptions(){
		
		JSONObject json = new JSONObject("bJQueryUI", "true", "sDom", "TC<\"clear\">Rlfrtip");

		return json;
	}
	
	@AfterRender
	public void addJsFile(){
		
		/*
		 * The dataTable js file is just here for the demo page. You do not 
		 * have to include it in your page. The DataTable will do it for you 
		 */
		js.importJavaScriptLibrary(
			as.getExpandedAsset("${assets.path}/components/datatables/jquery.dataTables.min.js"));
		
		
	}
	
	public TableInformation getTableInformation(){
		return new TableInformation() {
			
			public String getTableSummary() {
				return "This is summary for this table";
			}
			
			public String getTableCaption() {
				return "DataTable Sample";
			}
			
			public String getTableCSS() {
				return "";
			}
		};
	}
	
	public JSONObject getFilterJson(){
		JSONObject json = new JSONObject();
	
		//The filter bar will be at the top of our DataTable
		json.put("sPlaceHolder", "head:before");
		
		//We can also override the input used for each column
		JSONArray inputs = new JSONArray();
		inputs.put(new JSONObject("type", "text"))
			.put(new JSONObject("type", "text"))
			.put(new JSONObject("type", "select"));
		
		json.put("aoColumns", inputs);
     
		
		return json;
	}
}
