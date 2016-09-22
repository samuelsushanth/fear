function validate()
{
    if( document.Registration.textnames.value == "" )
    {
        alert( "Please provide your Name!" );
        document.Registration.textnames.focus() ;
        return false;
    }

    if( document.Registration.paddress.value == "" )
    {
        alert( "Please provide your Postal Address!" );
        document.Registration.paddress.focus() ;
        return false;
    }

    if ( ( Registration.sex[0].checked == false ) && ( Registration.sex[1].checked == false ) )
    {
        alert ( "Please choose your Gender: Male or Female" );
        return false;
    }
    if( document.Registration.City.value == "-1" )
    {
        alert( "Please provide your City!" );
        document.Registration.City.focus() ;
        return false;
    }
    if( document.Registration.Course.value == "-1" )
    {
        alert( "Please provide your Course!" );

        return false;
    }

    if( document.Registration.State.value == "-1" )
    {
        alert( "Please provide your Select State!" );

        return false;
    }
    if( document.Registration.pincode.value == "" ||
        isNaN( document.Registration.pincode.value) ||
        document.Registration.pincode.value.length != 6 )
    {
        alert( "Please provide a pincode in the format ######." );
        document.Registration.pincode.focus() ;
        return false;
    }
    var email = document.Registration.emailid.value;
    atpos = email.indexOf("@");
    dotpos = email.lastIndexOf(".");
    if (email == "" || atpos < 1 || ( dotpos - atpos < 2 ))
    {
        alert("Please enter correct email ID")
        document.Registration.emailid.focus() ;
        return false;
    }
    if( document.Registration.dob.value == "" )
    {
        alert( "Please provide your DOB!" );
        document.Registration.dob.focus() ;
        return false;
    }
    if( document.Registration.mobileno.value == "" ||
        isNaN( document.Registration.mobileno.value) ||
        document.Registration.mobileno.value.length != 10 )
    {
        alert( "Please provide a Mobile No in the format 123." );
        document.Registration.mobileno.focus() ;
        return false;
    }
    return( true );
}