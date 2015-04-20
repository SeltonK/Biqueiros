var login=$('#login').val();
var senha=$('#senha').val();
$("butao").click(function(){
	if (login=="") {
		alert("Login está em branco");
	};
	if (senha=="") {
		alert("Senha está em branco");
		
	};

});