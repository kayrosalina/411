<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>123 Testing</title>
</head>
<body>


#if($error)
<p>$error</p>
#end

<form method = "post" action = "Login">
    Username: <input type="text" name="username" required/><br><br>
    Password: <input type="text" name="password" required/><br><br>

    <input type = "submit" value = "Login"/>
</form>


</body>
</html>


