<html>

<head>

    <link rel="stylesheet" href="css/main.css">

</head>
<body>
<form action="#" name="Registration" class="form1">

    <table class="t1">

        <tr>
            <td colspan=2 style="text-align: center">
                <b style="font-size: larger">Registration Form</b>
            </td>
        </tr>

        <tr>
            <td>Use name</td>
            <td><input type=text name=textnames id="textname" size="30" required></td>
        </tr>
        <tr>
            <td>EmailId</td>
            <td><input type="text" name="emailid" id="emailid" size="30" required></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" id="password" size="30" required></td>
        </tr>
        <tr>
            <td>Occupation</td>
            <td><input type="radio" name="occupation" value="teacher" size="10" required>Teacher
                <input type="radio" name="occupation" value="student" size="10" required>Student</td>
        </tr>
        <tr>
            <td><input type="reset"></td>
            <td colspan="2"><input type="button" ng-click="validate()" value="Submit Form" /></td>
        </tr>
    </table>
</form>
</body>
</html>