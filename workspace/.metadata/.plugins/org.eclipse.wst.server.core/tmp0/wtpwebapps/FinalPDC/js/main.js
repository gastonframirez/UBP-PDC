jFinal = {
		chasis: function(obj){
			console.log("buscando");
			$.ajax({
	            url: "./BuscarServlet.jsp",
	            type: "POST",
	            dataType: "html",
	            data: {"nrochasis" : $(obj).val()},
	            error: function(hr){
	            	console.log("error"+ hr.responseText);
	                jUtils.hiding("");
	                jUtils.showing("existe", hr.responseText);
	            },
	            success: function(html) {
	                jUtils.showing("existe", html);
	            }
	        });
		},
		bloquear : function(obj){
			
				jUtils.hiding("ocultables");
			
		},
		mostrar : function(obj){
			
				jUtils.showing("ocultables","");
			
			
		},
		registrar: function (preferencia) {
			
			
			 $.ajax({
		            url: "./BuscarServlet.jsp",
		            type: "POST",
		            dataType: "html",
		            data: $.param($("#form")),
		            error: function(hr){
		                jUtils.hiding("iresult");
		                jUtils.showing("message", hr.responseText);
		            },
		            success: function(html) {
		                jUtils.showing("iresult", html);
		            }
		        });		
   }
}
		