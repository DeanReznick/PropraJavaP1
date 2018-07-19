<?php
session_start();

//falls man die Seite einfach so aufruft
if(!isset($_SESSION['userid'])) {
    die(' <body text="#000000" background="b.jpg" link="#FF0000" alink="#FF0000" vlink="#FF0000">
          <br> <br> <br> <center>
          <p style="font-family: Century Gothic">
          Fehler! Sie sind nicht angemeldet. Bitte loggen Sie sich <A href="index.php" style="text-decoration:none;"> <font color="black"> <b>hier</b> </font> </A> erst ein.
          </p>
          </center> <br> <br> <br>
          </body>
        ');
}

//Abfrage der Nutzer ID vom Login
$userid = $_SESSION['userid'];

?>






<!DOCTYPE html>

<html>
  <head>
    <titel>eLab</titel>
    <link href="style.css" type="text/css" rel="stylesheet">
  </head>

<body text="#000000" background="b.jpg" link="#FF0000" alink="#FF0000" vlink="#FF0000">


  <div id="leiste">
  <br>
  <A href="Startpage.php" style="text-decoration:none;"> <font color="black"> <b>Startseite</b> </font> </A> &nbsp &nbsp | &nbsp &nbsp
  <A href="warenkorb.php" style="text-decoration:none;"> <font color="black"> <b>Warenkorb</b> </font> </A> &nbsp &nbsp | &nbsp &nbsp
  <A href="logout.php" style="text-decoration:none;"> <font color="black"> <b>Ausloggen</b> </font> </A>
  </div>
  <br> <br> <br>>

     <div id="mitte">
     <br> <br>

     <h1> Bauteile Dekrementieren </h1>


      <?php
      $bauteil = $_GET['bauteil'];
      $menge = $_GET['menge'];
      echo "<br>";
      echo "Sie haben das Bauteil ";
      echo $bauteil;
      echo " ausgewählt. <br> Wie viele Teile möchten Sie entnehmen? <br> <br> <br>";
      ?>

      <form action="changeSuccessful.php?bauteil=<?php echo $bauteil ?>&entnehmen=1" method="post">
      <input type="mengeTeile" size="10" maxlength="250" name="mengeTeile"><br> <br>
      <input type="submit" value="Weiter"> <br> <br> <br>
      </form>

      <?php
      echo " <i> Es sind ";
      echo $menge;
      echo " Stück verfügbar. </i>"
      ?>


<br> <br> <br> <br>


</div>

</body>
</html>
