<html>
<head>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>

<h2>Login Form</h2>

<form action="action_page.php" class="f1">


    <div class="container">
        <label><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="uname" required >

        <label><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required class="i1">

        <button type="submit" class="btn-default">Login</button>
        <input type="checkbox" checked="checked"> Remember me
    </div>

    <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="btn-default">Cancel</button>
        <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
</form>

</body>
</html>






