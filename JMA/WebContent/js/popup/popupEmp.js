$(function(){
			/*$('.open-popup-link').magnificPopup({
			  type:'inline',
			  midClick: true // allow opening popup on middle mouse click. Always set it to true if you don't provide alternative source.
			});*/
			
			// Example: 2 Dynamically created
			$('.open-popup-link').magnificPopup({
					
				  type: 'iframe',
				  tLoading: 'LOADING',
				  verticalFit: true,
				  midClick: true,
				  fixedBgPos : false,
				  closeBtnInside: false,
				 /* callbacks: {
			            open: function () {
			                $.magnificPopup.instance.close = function () {
			                    var confirmed = confirm("Are you sure?");
			                    if (!confirmed) {
			                        return;
			                    }
			                    $.magnificPopup.proto.close.call(this);
			                };
			            }
			        }*/
			 });
			$('.open-popup-link-img').magnificPopup({
				
				  type: 'image',
				  verticalFit: true,
				  horizontalFit: true,
				  fixedBgPos : false,
				  closeBtnInside: false,
				  gallery: {
			          enabled:true
			        },
				  retina: {
					    ratio: 1, // Increase this number to enable retina image support.
					    // Image in popup will be scaled down by this number.
					    // Option can also be a function which should return a number (in case you support multiple ratios). For example:
					    // ratio: function() { return window.devicePixelRatio === 1.5 ? 1.5 : 2  }
					    

					    replaceSrc: function(item, ratio) {
					      return item.src.replace(/\.\w+$/, function(m) { return '@2x' + m; });
					    }
				  },
			gallery:{
			    enabled:true
			  }
			 });
			
	    }); 