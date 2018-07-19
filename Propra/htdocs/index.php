<?php
session_start();
$showFormular = true;
$datenbank = "Projekt1-DB.db";
$pdo = new PDO('sqlite:' . $datenbank);


if(isset($_GET['login'])) {
    $email = $_POST['email'];
    $passwort = $_POST['passwort'];

    function saltPassword($passwort, $salt)
    {
     return hash('sha256', $passwort . $salt);
    }

    $salt = "PROPRA";
    $passworthash    = saltPassword($passwort, $salt);

    $statement = $pdo->prepare("SELECT * FROM Person WHERE Mail = :email");
    $result = $statement->execute(array('email' => $email));
    $user = $statement->fetch();

    if ($user !== false && $passworthash == $user['Passwort']) {
        $_SESSION['userid'] = $user['ID_Person'];
        $showFormular = false;
        $loginSuccesfull = 'Login erfolgreich. Weiter zum <A href="Startpage.php" style="text-decoration:none;"> <font color="black"> <b>internen Bereich</b> </font> </A> <br> <br> <br> <br>';
    } else {
        $errorMessage = "Die E-Mail oder das Passwort war ungültig.<br><br><br>";
    }

}


if(isset($_GET['glogin'])) {

    $_SESSION['userid'] = 'GastAccount';
    $showFormular = false;
    $loginSuccesfull = 'Sie werden als Gast angemeldet. Weiter zum <A href="Startpage.php" style="text-decoration:none;"> <font color="black"> <b>internen Bereich</b> </font> </A> <br> <br> <br> <br>';


}
?>





<!DOCTYPE html>

<html>
  <head>
    <titel>eLab</titel>
    <link href="style.css" type="text/css" rel="stylesheet">
  </head>

<body text="#000000" background="b.jpg" link="#FF0000" alink="#FF0000" vlink="#FF0000">

     <div id="mitte">
     <br> <br> <br>

     <h1> Willkommen bei eLab! </h1>

     <br> <br><br>
     Bitte loggen Sie sich ein, oder melden sie sich als Gast an.
     <br> <br> <br> <br>

      <?php
      if(isset($errorMessage)) {
          echo $errorMessage;
      }

      if(isset($loginSuccesfull)){
        $showFormular = false;
        echo $loginSuccesfull;
      }

      ?>

      <?php
      if($showFormular){

       ?>

      <form action="?login=1" method="post">
      E-Mail:<br>
      <input type="email" size="40" maxlength="250" name="email"><br><br>

      Passwort:<br>
      <input type="password" size="40"  maxlength="250" name="passwort"><br>

      <br>
      <input type="submit" value="Weiter">
      </form>



      <form action="?glogin=1" method="post">

      <br> <br> <br>
      <input type="submit" value="Als Gast anmelden">
      </form>

     <br> <br> <br> <br>

     <?php
   } ?>


     </div>



</body>
</html>
