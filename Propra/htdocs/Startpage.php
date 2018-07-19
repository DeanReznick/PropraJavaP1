<?php
session_start();

//falls man die Seite einfach so aufruft
if(!isset($_SESSION['userid'])) {
    die(' <body text="#000000" background="b.jpg" link="#FF0000" alink="#FF0000" vlink="#FF0000">
          <br> <br> <br> <center>
          <p style="font-family: Century Gothic">
          Fehler! Sie sind nicht angemeldet. Bitte loggen sie sich <A href="index.php" style="text-decoration:none;"> <font color="black"> <b>hier</b> </font> </A> erst ein.
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
  <br> <br> <br>


  <div id="menu">
  <br> <br>
  <h1> Kategorien </h1>
  <br>
  <?php
  include_once 'TreeView.php';

  ?>

  <br> <br> <br>
  <center>
  <A href="lagerplan.php" style="text-decoration:none;"> <font color="black"> <b>Lagerplan anzeigen</b> </font> </A>
  <br> <br>
  </div>


     <div id="mitteS">
     <br> <br>

     <h1> Bauteile Bestand </h1>

     <br> <br>
     Um ein Bauteil zu entnehmen, klicken Sie bitte auf die entsprechende Zeile.
     <br> <br> <br> <br>


     <table id="list">
     <tr>
       <th>Name</th>
       <th>Link zum Produkt</th>
       <th>Einzelpreis</th>
       <th>Menge</th>
       <th>Lagerort</th>
     </tr>


   <?php
   $datenbank = "Projekt1-DB.db";
   $pdo = new PDO('sqlite:' . $datenbank);



   // wenn etwas angeklickt wurde
   if(isset($_GET['id_kat'])){

                 $ID_kategorie = $_GET['id_kat'];
                 foreach ($pdo->query('SELECT * FROM TBauteil WHERE ID_TKategorie = '.$ID_kategorie.'') as $row) {
                       $name = $row['Name'];
                       $link = $row['Link'];
                       $mengeL = $row['MengeLagernd'];
                       $mengeB = $row['MengeBestellt'];
                       $mengeG = $row['MengeGeplant'];
                       $ort = $row['Lagerort'];
                       $preis = $row['Preis'];
                 ?>

                 <tr>
                   <td onclick="window.location.href='change.php?bauteil=<?php if(isset($name)) {echo $name;}?>&menge=<?php if(isset($mengeL)) {echo $mengeL;}?>'">
                     <?php
                       if(isset($name)) {
                           echo $name;
                       }
                     ?>

                   </td>
                   <td onclick="window.location.href='change.php?bauteil=<?php if(isset($name)) {echo $name;}?>&menge=<?php if(isset($mengeL)) {echo $mengeL;}?>'">
                     <?php
                       if(isset($link)) {
                           echo $link;
                       }
                     ?>
                   </td>
                   <td onclick="window.location.href='change.php?bauteil=<?php if(isset($name)) {echo $name;}?>&menge=<?php if(isset($mengeL)) {echo $mengeL;}?>'">
                     <?php
                       if(isset($preis)) {
                           echo $preis;
                       }
                     ?>
                     €
                   </td>
                   <td onclick="window.location.href='change.php?bauteil=<?php if(isset($name)) {echo $name;}?>&menge=<?php if(isset($mengeL)) {echo $mengeL;}?>'">
                     Lagernd:
                     <?php
                       if(isset($mengeL)) {
                           echo $mengeL;
                       }
                     ?>
                     <br>
                     Bestellt:
                     <?php
                       if(isset($mengeB)) {
                           echo $mengeB;
                       }
                     ?>
                     <br>
                     Geplant:
                     <?php
                       if(isset($mengeG)) {
                           echo $mengeG;
                       }
                     ?>
                     <br>
                   </td>
                   <td onclick="window.location.href='change.php?bauteil=<?php if(isset($name)) {echo $name;}?>&menge=<?php if(isset($mengeL)) {echo $mengeL;}?>'">
                     <?php
                       if(isset($ort)) {
                           echo $ort;
                       }
                     ?>
                   </td>
                 </tr>

                 <?php
                 }

                 ?>
                 </table>
                 <?php
   }
   // falls nichts angeklickt wurde, also immer dann wenn die Startseite neu geladen wird
   else{

               foreach ($pdo->query('SELECT * FROM TBauteil') as $row) {
                     $name = $row['Name'];
                     $link = $row['Link'];
                     $mengeL = $row['MengeLagernd'];
                     $mengeB = $row['MengeBestellt'];
                     $mengeG = $row['MengeGeplant'];
                     $ort = $row['Lagerort'];
                     $preis = $row['Preis'];
               ?>

               <tr>
                 <td onclick="window.location.href='change.php?bauteil=<?php if(isset($name)) {echo $name;}?>&menge=<?php if(isset($mengeL)) {echo $mengeL;}?>'">
                   <?php
                     if(isset($name)) {
                         echo $name;
                     }
                   ?>

                 </td>
                 <td onclick="window.location.href='change.php?bauteil=<?php if(isset($name)) {echo $name;}?>&menge=<?php if(isset($mengeL)) {echo $mengeL;}?>'">
                   <?php
                     if(isset($link)) {
                         echo $link;
                     }
                   ?>
                 </td>
                 <td onclick="window.location.href='change.php?bauteil=<?php if(isset($name)) {echo $name;}?>&menge=<?php if(isset($mengeL)) {echo $mengeL;}?>'">
                   <?php
                     if(isset($preis)) {
                         echo $preis;
                     }
                   ?>
                   €
                 </td>
                 <td onclick="window.location.href='change.php?bauteil=<?php if(isset($name)) {echo $name;}?>&menge=<?php if(isset($mengeL)) {echo $mengeL;}?>'">
                   Lagernd:
                   <?php
                     if(isset($mengeL)) {
                         echo $mengeL;
                     }
                   ?>
                   <br>
                   Bestellt:
                   <?php
                     if(isset($mengeB)) {
                         echo $mengeB;
                     }
                   ?>
                   <br>
                   Geplant:
                   <?php
                     if(isset($mengeG)) {
                         echo $mengeG;
                     }
                   ?>
                   <br>
                 </td>
                 <td onclick="window.location.href='change.php?bauteil=<?php if(isset($name)) {echo $name;}?>&menge=<?php if(isset($mengeL)) {echo $mengeL;}?>'">
                   <?php
                     if(isset($ort)) {
                         echo $ort;
                     }
                   ?>
                 </td>
               </tr>

               <?php
                }
               }
               ?>
               </table>


     <br> <br> <br> <br>


     </div>

</body>
</html>
