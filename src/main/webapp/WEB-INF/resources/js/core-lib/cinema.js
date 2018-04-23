jQuery.noConflict();

(function($){
	var methods = {
		/* function that loads exception in the page */
		loadException : function (data) {
			$('.syg_error').remove();
			data = $.parseJSON(JSON.stringify(data));
			var problemFound = data.exception_detail;
			html = '<div class="syg_error"><p><strong>An error was found while updating your style.</strong></p><ul>';
			$.each(problemFound, function(key, val) {
				html = html + '<li>' + val.field + ' - ' + val.msg + '</li>';
			});
			html = html + '</ul></div>';
			$('#syg_status_bar').prepend(html);
		},
		
		/* function that alert exception in the page */
		cinemaAlert : function (windowTitle, message, type, callbck) {
			if (type == 'confirm') {
				$(".dialog-confirm").attr("title", windowTitle);			
				$(".dialog-confirm").empty();
				$(".dialog-confirm").prepend(message);
				$(".dialog-confirm").dialog({
					resizable: false,
					modal: true,
					buttons: {
						Ok : function() {
                   			$(this).dialog('close');
                   			callbck();
						},
						Cancel : function() {
							$(this).dialog("close");
						}
					}
				});
			} else if (type == 'info') {
				$(".dialog-info").attr("title", windowTitle);			
				$(".dialog-info").empty();
				$(".dialog-info").prepend(message);			
				$(".dialog-info").dialog({
					modal: true,
					draggable: false,
					resizable: false,
					buttons: {
						Ok: function() {
							$(this).dialog( "close" );
						}
					}
				});
			} else if (type == 'error') {
				$(".dialog-error").attr("title", windowTitle);			
				$(".dialog-error").empty();
				$(".dialog-error").prepend(message);			
				$(".dialog-error").dialog({
					modal: true,
					draggable: false,
					resizable: false,
					buttons: {
						Ok: function() {
							$(this).dialog( "close" );
						}
					}
				});
			}
		},
		
		/* function that alert exception in the page */
		alertException : function (data) {
			data = $.parseJSON(JSON.stringify(data));
			var problemFound = data.exception_detail;
			html = '<ul>';
			$.each(problemFound, function(key, val) {
				html = html + '<li><strong>' + val.field + '</strong> - ' + val.msg + '</li>';
			});
			html = html + '</ul>';
			
			$(".dialog-error").attr("title", "Preview Errors:");
			$(".dialog-error").empty();
			$(".dialog-error").prepend(html);
		
			 $(".dialog-error").dialog({
				modal: true,
				draggable: false,
				resizable: false,
				buttons: {
					Ok: function() {
						$(this).dialog( "close" );
					}
				}
			});
		},
		
		/* function that automatically creates a table by json input */
		createTableView : function (objArray, theme, enableHeader) {
		    if (theme === undefined) {
		        theme = 'mediumTable';
		    }
		    if (enableHeader === undefined) {
		        enableHeader = true;
		    }
		    var array = typeof objArray != 'object' ? JSON.parse(objArray) : objArray;
		    var str = '<table class="' + theme + '">';
		    // table head
		    if (enableHeader) {
		        str += '<thead><tr class="tableRow">';
		        for (var index in array[0]) {
		            str += '<th scope="col">' + index + '</th>';
		        }
		        str += '</tr></thead>';
		    }
		    // table body
		    str += '<tbody>';
		    for (var i = 0; i < array.length; i++) {
		        str += (i % 2 == 0) ? '<tr class="alt">' : '<tr>';
		        for (var index in array[i]) {
		            str += '<td>' + array[i][index] + '</td>';
		        }
		        str += '</tr>';
		    }
		    str += '</tbody>';
		    str += '</table>';
		    return str;
		},
		
		/* function that loads the data in the table */ 
		loadPurchase : function (data, pageNum) {
			// clean the grid
			$('#DynamicGrid').html("");
			// clean the paginator
			$('#paginator').html("");
			// get pages information
			var pagesAvailable = data.pagesAvailable;
			var pageNumber = data.pageNumber;
			// start to parse items
			var parsed = {items: []};
			$.each(data.pageItems, function(key, value){
				var item = {};
				item.purchaseId = data.pageItems[key].purchaseId;
				item.purchaseDate = data.pageItems[key].purchaseDate;
				item.date = data.pageItems[key].schedule.scheduleDate;
				item.movieName = data.pageItems[key].schedule.movie.movieName;
				item.sitCode = data.pageItems[key].purchaseSitCode;
				item.theatreName = data.pageItems[key].schedule.theatre.theatreName;
				item.action = '<a href="/CCBillCinema/upcomingSchedules/refund.html?idSchedule=' + data.pageItems[key].schedule.idSchedule + '" class="btn btn-info">Refund this schedule <i class="icon-white icon-facetime-video"></i></a>';
				parsed.items[key] = item;
			});
			// append html to the grid
			$($.fn.cinema('createTableView', parsed.items, "table", true)).hide().appendTo('#DynamicGrid').fadeIn(2000);
			
			// paginator creation
			var htmlPaginator = '<li class="disabled"><a href="#">&laquo;</a></li>';
			$(htmlPaginator).hide().appendTo('#paginator').fadeIn(2000);
			for (var i=0;i<pagesAvailable;i++) {
				if (pageNumber == (i + 1)) {
					htmlPaginator = '<li class="active"><a href="#">' + (i+1).toString() + '</a></li>';
				} else {
					htmlPaginator = '<li><a href="#">' + (i+1).toString() +'</a></li>';
				}
				$(htmlPaginator).hide().appendTo('#paginator').fadeIn(2000);
			}
			
			// add pagination events
			$.fn.cinema('addPaginationClickEvent', '#paginator', 'purchase');
		},
		
		/* function that loads the data in the table */ 
		loadSchedule : function (data) {
			// clean the grid
			$('#DynamicGrid').html("");
			// clean the paginator
			$('#paginator').html("");
			// get pages information
			var pagesAvailable = data.pagesAvailable;
			var pageNumber = data.pageNumber;
			// start to parse items
			var parsed = {items: []};
			$.each(data.pageItems, function(key, value){
				var item = {};
				item.theatreName = data.pageItems[key].theatre.theatreName;
				item.movieName = data.pageItems[key].movie.movieName;
				item.movieGenre = data.pageItems[key].movie.movieGenre;
				item.scheduleDate = data.pageItems[key].scheduleDate;
				item.slotStartTime = data.pageItems[key].slot.slotStartTime;
				item.slotEndTime = data.pageItems[key].slot.slotEndTime;
				item.moviePrice = data.pageItems[key].movie.moviePrice;
				item.action = '<a href="/CCBillCinema/shoppingCart/buy.html?idSchedule=' + data.pageItems[key].idSchedule + '" class="btn btn-success">Book this Schedule <i class="icon-white icon-facetime-video"></a>';
				parsed.items[key] = item;
			});
			// append html to the grid
			$($.fn.cinema('createTableView', parsed.items, "table", true)).hide().appendTo('#DynamicGrid').fadeIn(2000);
			
			// paginator creation
			var htmlPaginator = '<li class="disabled"><a href="#">&laquo;</a></li>';
			$(htmlPaginator).hide().appendTo('#paginator').fadeIn(2000);
			for (var i=0;i<pagesAvailable;i++) {
				if (pageNumber == (i + 1)) {
					htmlPaginator = '<li class="active"><a href="#">' + (i+1).toString() + '</a></li>';
				} else {
					htmlPaginator = '<li><a href="#">' + (i+1).toString() +'</a></li>';
				}
				$(htmlPaginator).hide().appendTo('#paginator').fadeIn(2000);
			}
			
			// add pagination events
			$.fn.cinema('addPaginationClickEvent', '#paginator', 'schedule');
		},
		
		/* function that loads the data in the table */ 
		loadSearch : function (data, pageNum) {
			data = $.parseJSON(JSON.stringify(data));
			var table = 'galleries';
			methods.hideLoad.call(this);
			
			if (!jQuery.isEmptyObject(data)) {
				var rowsPrinted = 0;
				$.each(data, function(key, val) {
					// put data
					val.dato;
				});
			} else {
				// no data found
			}
		},
		
		/* function that add pagination event per table */
		addPaginationClickEvent : function (rootTag, query) {		
			var li = $(rootTag).children();
			$(li).click(function() {
				var pageNum = $(this).children().text();
				if (query == 'schedule') {
					$.getJSON('/CCBillCinema/rest/schedule/pages/' + pageNum, function (data) {
						methods.loadSchedule.call(this, data);
					});
				} else if (query == 'purchase') {
					// request for json schedules data
					$.getJSON('/CCBillCinema/rest/purchase/pages/' + pageNum , function (data) {
						methods.loadPurchase.call(this, data)
					});
				}
			});
		},
		
		/* pageMapper function */
		pageMapper : function (url) {
			var href = new String(url);
			href = href.substr(href.lastIndexOf('/') + 1);
			
			if (href.match(/welcome.html.*/)) {
				return 'cinema-schedules';
			} else if (href.match(/index.html.*/)) {
				return 'cinema-schedules';
			} else if (href.trim() == '' || href == 'undefined') {
				return href;
			} else if (href.match(/cart.html.*/)) {
				return 'cinema-cart';
			} else if (href.match(/buy.html.*/)) {
				return 'cinema-book';
			} else if (href.match(/search.html.*/)) {
				return 'cinema-search';
			} else if (href.match(/refund.html.*/)) {
				return 'cinema-refund';
			} else {
				return href;
			}
		},
		
		/* function that init style ui */
		intiPurchaseUi : function () {
			
		},
		
		/* function that init gallery ui */
		initScheduleUi : function () {
			
		},
		
		/* function that init settings ui */
		initSearchUi: function () {
			
		},
		
		/* function that register ajax loader handlers */
		registerAjaxLoadersHandlers : function () {
			$(document).ajaxStart(function() {
				  $('#DynamicGridLoading').fadeIn(1250);
			});
			$(document).ajaxStop(function() {
				  $('#DynamicGridLoading').fadeOut(1250);
			});
		}
	};
	
	$.fn.cinema = function( method ) {
    	// Method calling logic
    	if (methods[method]) {
			return methods[ method ].apply( this, Array.prototype.slice.call( arguments, 1 ));
    	} else {
    		$.error( 'Method ' +  method + ' does not exist on jQuery.cinema' );
		}
    };
})(jQuery);

/**************************************
 # jQuery onready and onload function #
 **************************************/ 

jQuery(document).ready(function($) {
	// dirty thing but necessary at the moment
	var page = $.fn.cinema('pageMapper', document.URL);
	var pageNum = (isNaN($.fn.cinema('pageMapper', document.URL))) ? 1 : $.fn.cinema('pageMapper', document.URL); 
	
	// register loader ajax handlers
	$.fn.cinema('registerAjaxLoadersHandlers');

	// switch json request basing on page
	switch (page) {
		case 'cinema-schedules':			
			// request for json schedules data
			$.getJSON('/CCBillCinema/rest/schedule/pages/' + pageNum, function (data) {
				$.fn.cinema('loadSchedule', data, 'schedule');
			});
			
			break;
		case 'cinema-cart':
			// request for json schedules data
			$.getJSON('/CCBillCinema/rest/purchase/pages/' + pageNum , function (data) {
				$.fn.cinema('loadPurchase', data, 'purchase');
			});
			
			break;
		case 'cinema-search':	
			// request for json schedules data
			$('#scheduleSearch').click(function() {
				$.fn.cinema('cinemaAlert', 'Feature not available', 'Please come back here for the next version', 'info');
			});
			
			break;
		case 'cinema-refund':	
			// request for json schedules data
			$('#refund').click(function() {
				$.fn.cinema('cinemaAlert', 'Feature not available', 'Please come back here for the next version', 'info');
			});
			
			break;
		case 'cinema-book':
			$("#book-now").click(function() {
				$("#buy").submit();
			});
			
			$("#buy").submit(function(event) {
				event.preventDefault();
				var fcallback = function () {
					$("#buy").unbind('submit').submit();
				};
				$.fn.cinema('cinemaAlert', 'Are you sure?', 'You are about to book this schedule', 'confirm', fcallback);
			});
			break;
		default:
			return false;
	}
});