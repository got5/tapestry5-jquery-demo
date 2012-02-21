(function( $ ) {

	T5.extendInitializers(function(){
		
		function init(spec) {
			$('#myDiv').addClass('reveal-modal');
			
	    	$('#myDiv').reveal({
	    		animation:'none'
	        });
	    	
		}
		
		return {
			indicator : init
		}
	});
	
}) ( jQuery );
