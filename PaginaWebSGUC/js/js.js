$(document).ready(function(){

	$("#banner").css({"height":$(window).height() + "px"});

	var flag = false;
	var scroll;

	$(window).scroll(function(){
		scroll = $(window).scrollTop();

		if(scroll > 200){
			if(!flag){
				$("#logo").css({"margin-top": "-5px", "width": "50px","height":"50px"});

				$("header").css({"background-color": "#3C3C3C"});
				flag = true;
			}
		}else{
			if(flag){
				$("#logo").css({"margin-top": "150px", "width": "250px","height":"250px"});

				$("header").css({"background-color": "transparent"});
				flag = false;
			}
		}


	});

});


$(document).on("ready", inicio);

function inicio(){
	$("#container img").on("click",abrirFull);
	$("#muestra").on("click", cerrarFull);
};

function abrirFull(){
	//alert($(this).attr("alt"));
	var nombre = $(this).attr("alt") + "G";
	var direccion = "gallery/" + nombre + ".jpg";

	$("#imgBIG").attr("src",direccion);

	$("#muestra").fadeIn();
};

function cerrarFull(){
	$(this).fadeOut();
};

var expr = /^[a-zA=Z0-9_\.\-]+@[a-zA=Z0-9\-]+\.[a-zA=Z0-9\-\.]+$/;
$(document).ready(function(){
	$("#bEnviar").click(function(){
		var nombre = $("#itNombre").val();
		var correo = $("#itMail").val();
		var asunto = $("#itAsunto").val();

		if(nombre == ""){
			$("#mensaje1").fadeIn();
			return false;
		}else{
			$("#mensaje1").fadeOut();
			if(correo == "" || !expr.test(correo)){
				$("#mensaje2").fadeIn();
				return false;
			}else{
				$("#mensaje2").fadeOut();
				if(asunto == ""){
					$("#mensaje3").fadeIn();
					return false;
				}
			}
		}

	});
});