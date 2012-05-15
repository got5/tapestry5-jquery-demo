(function( $ ) {

	T5.extendInitializers(function(){
		

		function columnFilter(specs) {
			
			//Insert second tr row in the thead part
			var oTable = $("#"+specs.id).dataTable();
			var oSettings = oTable.fnSettings();
		    for(iCol = 0; iCol < oSettings.aoPreSearchCols.length; iCol++) {
		        oSettings.aoPreSearchCols[ iCol ].sSearch = '';
		    }
		    oSettings.oPreviousSearch.sSearch = '';
		    oTable.fnDraw();
		    
			oTable.columnFilter(specs.options);
					
	        }
		function addHeader(specs) {
			var tr = $("#"+specs.id).find("thead tr");
			var copy = tr.clone(false);
			copy.insertBefore(tr);
		}
		
		return {
			columnFilter : columnFilter, 
			addHeader : addHeader
		}
	});

}) ( jQuery );