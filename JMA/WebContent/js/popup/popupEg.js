$(function(){
			/*$('.open-popup-link').magnificPopup({
			  type:'inline',
			  midClick: true // allow opening popup on middle mouse click. Always set it to true if you don't provide alternative source.
			});*/
			
			// Example: 2 Dynamically created
			$('.open-popup-link').magnificPopup({
				items: {
				   /* src: 'views/Login.jsp'*/
					src: 'save.action'
				  },
				  type: 'iframe',
				  tLoading: 'LOADING',
				  closeBtnInside: true
			 }); 
			
	    }); 