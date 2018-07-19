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

     <div id="mitte">
     <br> <br>

     <h1> Entnahme  </h1>

     <br> <br>



<?php
$datenbank = "Projekt1-DB.db";
$pdo = new PDO('sqlite:' . $datenbank);
$bauteil = $_GET['bauteil'];

$statement = $pdo->prepare('SELECT ID_TBauteil FROM TBauteil WHERE Name = :name');
$result = $statement->execute(array('name' => $bauteil));
$bt = $statement->fetch();




if(isset($_GET['entnehmen'])) {
    $mengeTeile = $_POST['mengeTeile'];
    if(empty($mengeTeile)){
      echo "Leere Eingabe.";
    }
    else{
    $bauteilid = $bt['ID_TBauteil'];

    $q = "SELECT * FROM TBauteil WHERE ID_TBauteil = '$bauteilid'";
    foreach ($pdo->query($q) as $ro) {
            $preis = $ro['Preis'];
    }


    $timestamp = time();
    $ts = date("d.m.Y - H:i", $timestamp);

    $chart->insertArtikel($bauteil, $bauteilid, $userid, $ts, $mengeTeile, $preis);

    echo 'Die Entnahme wurde im Warenkorb hinterlegt.';
  }

    /* EINZELND IN DIE DATENBANK SCHREIBEN:
    ------------------------------------------------------------
    $stmt = $pdo->prepare("INSERT INTO Änderung (ID_Änderung, ID_Bauteil, ID_Person, Timestamp, Änderung) VALUES (:idA, :idB, :idP, :ts, :and)");
    $result = $stmt->execute(array('idB' => $bauteilid, 'idP' => $userid, 'ts' => $ts, 'and' => $mengeTeile));

    if($result) {
          echo 'Die Entnahme wurde erfolgreich gespeichert. <br>
                Sie wird anschließend von einem Mitarbeiter bestätigt. <br>
                Bei Fragen oder Anmerkungen können Sie sich gerne an uns wenden.';
    } else {
          echo 'Beim Abspeichern ist leider ein Fehler aufgetreten<br>';
    }

    */

}

?>
 <br> <br>
 Zurück zur <A href="Startpage.php" style="text-decoration:none;"> <font color="black"> <b>Startseite</b> </font> </A>


<br> <br> <br> <br>


</div>

</body>
</html>
