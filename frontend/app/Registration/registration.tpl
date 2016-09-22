<html>
<head>
    <script type="text/javascript" src="validate.js"></script>
</head>
<body>
<form action="#" name="Registration" onsubmit="return(validate());">

    <table cellpadding="2" width="80%" bgcolor="#d3d3d3" align="center"
           cellspacing="2">

        <tr>
            <td colspan=2 style="text-align: center">
                <b style="font-size: larger">Registration Form</b>
            </td>
        </tr>

        <tr>
            <td>Name</td>
            <td><input type=text name=textnames id="textname" size="30"></td>
        </tr>

        <tr>
            <td>Postal Address</td>
            <td><input type="text" name="paddress" id="paddress" size="30"></td>
        </tr>

        <tr>
            <td>Sex</td>
            <td><input type="radio" name="sex" value="male" size="10">Male
                <input type="radio" name="sex" value="Female" size="10">Female</td>
        </tr>

        <tr>
            <td>City</td>
            <td><select name="City">
                <option value="-1" selected>select..</option>
                <option value="New Delhi">NEW DELHI</option>
                <option value="Mumbai">MUMBAI</option>
                <option value="Goa">GOA</option>
                <option value="Patna">PATNA</option>
            </select></td>
        </tr>

        <tr>
            <td>Course</td>
            <td><select name="Course">
                <option value="-1" selected>select..</option>
                <option value="B.Tech">B.TECH</option>
                <option value="MCA">MCA</option>
                <option value="MBA">MBA</option>
                <option value="BCA">BCA</option>
            </select></td>
        </tr>

        <tr>
            <td>State</td>
            <td><select Name="State">
                <option value="-1" selected>select..</option>
                <option value="New Delhi">NEW DELHI</option>
                <option value="Mumbai">MUMBAI</option>
                <option value="Goa">GOA</option>
                <option value="Bihar">BIHAR</option>
            </select></td>
        </tr>
        <tr>
            <td>PinCode</td>
            <td><input type="text" name="pincode" id="pincode" size="30"></td>

        </tr>
        <tr>
            <td>EmailId</td>
            <td><input type="text" name="emailid" id="emailid" size="30"></td>
        </tr>

        <tr>
            <td>DOB</td>
            <td><input type="text" name="dob" id="dob" size="30"></td>
        </tr>

        <tr>
            <td>MobileNo</td>
            <td><input type="text" name="mobileno" id="mobileno" size="30"></td>
        </tr>
        <tr>
            <td><input type="reset"></td>
            <td colspan="2"><input type="submit" value="Submit Form" /></td>
        </tr>
    </table>
</form>
</body>
</html>