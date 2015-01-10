//Check if fields are filled
function FieldVerifierInscription()
{

	var tbMail = document.getElementById("tbMail").value;
	var tbName = document.getElementById("tbName").value;
	var tbFirstName = document.getElementById("tbFirstName").value;

	if(tbMail.length==0 || tbName.length==0|| tbFirstName.length==0)
	{
		var errorNullField = document.getElementById("errorNullField");
		errorNullField.innerHTML="Please complete the mandatory fields (*)";
		
		if (isEmail(tbMail))
		{
				var errorNullField = document.getElementById("errorMail");
				errorMail.innerHTML="";
		}
	}
	else if (!isEmail(tbMail))
	{
			var errorNullField = document.getElementById("errorMail");
			errorMail.innerHTML="Incorrect format of the mail";
			
			if(tbMail.length!=0 & tbName.length!=0 & tbFirstName.length!=0)
			{
				var errorNullField = document.getElementById("errorNullField");
				errorNullField.innerHTML="";
			}
		
	}
	else
	{
	    document.getElementById("Submit").submit();
	}
	
}


//Check if the format of mail is correct
function isEmail(myVar){
    
    var regEmail = new RegExp('^[0-9a-z._-]+@{1}[0-9a-z.-]{2,}[.]{1}[a-z]{2,5}$','i');

    return regEmail.test(myVar);
  }


//Generate dynamic link to modify with parameter (now for add and delete Users etc...)
function LinkAdaptatorToModify(id) 
{
	var a = document.getElementById(id); 
	if (confirm('Do you want to modify the following user : '+ a.id )) {
		a = "ModifyUser?idModify="+a.id;
		window.location.replace(a);
	}

}


//Generate dynamic link to delete with parameter (now for add and delete Users etc...)
function LinkAdaptatorToDelete(id) 
{
	var a = document.getElementById(id);
	if (confirm('Do you want to delete the following user : '+ a.id )) {
		a = "DeleteUser?idDelete="+a.id;
		window.location.replace(a);
	}
}



function hiddenSection(a)
{
	
	var e=document.getElementById(a);
	if(!e)return true;
	if(e.style.display=="none")
	{
		e.style.display="block"
	}
	else
	{
		e.style.display="none"
	}
	return true;
	}
