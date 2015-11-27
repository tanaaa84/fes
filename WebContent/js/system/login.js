function userpass_onkeypress(){
	var userpass = document.getElementById("userpass");
	if(event.keyCode == 13){
		if(!userpass.value){
			userpass.focus();
			return false;
		}
		else{
			document.form.submit();
		}
	}
}

function name_onkeypress(){
	var username = document.getElementById("username");
	var userpass = document.getElementById("userpass");
	if(event.keyCode == 13){
		if(!username.value){
			username.focus();
			return false;
		}
		else{
			userpass.focus();
		}
	}
}

function btn_chkfrm(){
	var username = document.getElementById("username");
	var userpass = document.getElementById("userpass");
	if(!username.value){
		username.focus();
		return false;
	}
	else{
		userpass.focus();
		if(!userpass.value){
			userpass.focus();
			return false;
		}else{
			document.form.submit();
		}
	}
}