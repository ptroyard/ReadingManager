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
    // La 1ère étape consiste à définir l'expression régulière d'une adresse email
    var regEmail = new RegExp('^[0-9a-z._-]+@{1}[0-9a-z.-]{2,}[.]{1}[a-z]{2,5}$','i');

    return regEmail.test(myVar);
  }
