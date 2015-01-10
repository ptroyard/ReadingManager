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

function FieldModifyVerifier()
{
	
	var tbFirstName = document.getElementById("tbName").value;
	var tbLastName = document.getElementById("tbFirstName").value;
	var tbAdress = document.getElementById("tbAddress").value;
	var tbPhone = document.getElementById("tbTelephone").value;
	
	if(tbFirstName.length==0 && tbLastName.length==0 && tbAdress.length==0 && tbPhone.length==0 )
	{
		var error = document.getElementById("errorField");
		errorField.innerHTML="Please complete at least one of the fields to modify a User";
	}
	else
	{
	    document.getElementById("submitModify").submit();
	}
}


function FieldSearchVerifier()
{
	var tbMail = document.getElementById("tbSearchByMail").value;
	var tbFirstName = document.getElementById("tbSearchByFirstName").value;
	var tbLastName = document.getElementById("tbSearchByLastName").value;
	var tbAdress = document.getElementById("tbSearchByAddress").value;
	var tbPhone = document.getElementById("tbSearchByPhone").value;
	
	if(tbMail.length==0 && tbFirstName.length==0 && tbLastName.length==0 && tbAdress.length==0 && tbPhone.length==0 )
	{
		var error = document.getElementById("errorField");
		errorField.innerHTML="Please complete at least one of the fields to search a User";
	}
	else
	{
	    document.getElementById("searchSubmit").submit();
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
