<?php
session_start();

//falls man die Seite einfach so aufruft
if(!isset($_SESSION['userid'])) {
    die(' <body text="#000000" background="b.jpg" link="#FF0000" alink="#FF0000" vlink="#FF0000">
          <br> <br> <br> <center>
          <p style="font-family: Century Gothic">
          Fehler! Sie sind nicht angemeldet. Bitte loggen Sie <A href="index.php" style="text-decoration:none;"> <font color="black"> <b>hier</b> </font> </A> erst ein.
          </p>
          </center> <br> <br> <br>
          </body>
        ');
}

//Abfrage der Nutzer ID vom Login
$userid = $_SESSION['userid'];

// Die Klasse Includieren
include_once 'warenkorb-class.php';

// Eine Neue Instanz der Klasse chart erstellen
$chart = new chart();

// Prüfen ob der Warenkorb besteht
$chart->initial_chart();

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
  <br> <br> <br>


     <!--
     <div id="menu">

    <h1> Kategorien </h1>
    auswahl <br>
    xy
    </div>
    -->

     <div id="mitte">
     <br> <br>

     <h1> Warenkorb </h1>

     <br> <br>
     Sie haben folgende Bauteile entnommen:
     <br> <br> <br> <br>


     <?php

     $chart->getChart();

     ?>

     <br> <br> <br> <br>

     <form action="warenkorb-successful.php?bauteil=speichern=1" method="post">
     <input type="submit" value="Änderungen speichern"> <br> <br> <br>
     </form>

     <form action="warenkorb-geloescht.php" method="post">
     <input type="submit" value="Warenkorb löschen"> <br> <br> <br>
     </form>



     <br> <br>
     </div>




</body>
</html>
