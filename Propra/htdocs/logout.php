<?php
session_start();
session_destroy();

$Message = "Logout war erfolgreich!";
?>



<!DOCTYPE html>

<html>
  <head>
    <titel>eLab</titel>
    <link href="style.css" type="text/css" rel="stylesheet">
  </head>

<body text="#000000" background="b.jpg" link="#FF0000" alink="#FF0000" vlink="#FF0000">

     <div id="mitte">
     <br> <br>

       <?php
       if(isset($Message)) {
           echo $Message;
       }
       ?>
       
     <br> <br>
     Zum <A href="index.php" style="text-decoration:none;"> <font color="black"> <b>Login</b> </font> </A>
     <br> <br>
     </div>

</body>
</html>
