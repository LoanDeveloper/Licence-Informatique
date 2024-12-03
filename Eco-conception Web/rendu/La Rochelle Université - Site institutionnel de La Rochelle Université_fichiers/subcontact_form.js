jQuery(document).ready( function() {
	
   /*(function($) {
		$.QueryString = (function(a) {
			if (a == "") return {};
			var b = {};
			for (var i = 0; i < a.length; ++i)
			{
				var p=a[i].split('=');
				if (p.length != 2) continue;
				b[p[0]] = decodeURIComponent(p[1].replace(/\+/g, " "));
			}
			return b;
		})(window.location.search.substr(1).split('&'))
	})(jQuery);*/
	
	jQuery('#contact_select').on('change', function(e) {
      e.preventDefault(); 
      var contact_id = this.value;
      jQuery.ajax({
         type : "post",
         dataType : "json",
         url : myAjax.ajaxurl,
         data : {action: "subcontact_form", contact_id : contact_id},
         success: function(response) {
            if(response.type == "success") {
				let dropdown = jQuery('#subcontact');
				dropdown.empty();
				dropdown.append('<option selected="true" disabled>—Veuillez choisir une option—</option>');
				dropdown.prop('selectedIndex', 0);
				jQuery.each(response.data, function (key, entry) {
					dropdown.append(jQuery('<option></option>').attr('value', entry.value).text(entry.label));
				});
				jQuery('#subcontact').attr('required', true);
				jQuery('#subcontact_select').show();
            }else {
				let dropdown = jQuery('#subcontact');
				dropdown.empty();
				dropdown.append('<option selected="true" disabled>—Veuillez choisir une option—</option>');
				dropdown.prop('selectedIndex', 0);
				jQuery('#subcontact').attr('required', false);
				jQuery('#subcontact_select').hide();
            }
         }
      });
   });
   
	/*var contact_id = jQuery.QueryString["contact"];
	if(contact_id){
		if( jQuery('#contact_select option[value="'+contact_id+'"]').length > 0){
			jQuery('#contact_select option[value="'+contact_id+'"]').attr("selected", "selected");
		}else{
			alert('emmpty');
		}
	}*/
   
});