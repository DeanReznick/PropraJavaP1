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

//Rechnung erstellen

$timestamp = time();
$ts = date("d.m.Y - H:i", $timestamp);
$typ = "Auftrags-Rechnung";

$stmt = $pdo->prepare("INSERT INTO BRechnung (ID_BRechnung, Name, ID_Auftraggeber, ID_Ansprechpartner, Art_Bezahlung, Betrag, Beschreibung, ID_Bearbeiter, Timestamp, ID_Topf, Typ) VALUES (:idR, :name, :idAu, :idan, :artb, :betr, :besch, :idBe, :ts, :idTo, :typ)");
$result = $stmt->execute(array('name' => 'Online_Bestellung', 'idAu' => $userid, 'artb' => 'Bar', 'betr' => 100, 'ts' => $ts, 'typ' => $typ));


// ID der Rechnung holen, damit sie in die Bauteile reingeschrieben werden kann
$qu = "SELECT * FROM BRechnung WHERE Timestamp = '$ts'";
foreach ($pdo->query($qu) as $r) {
        $ID_Rechnung = $r['ID_BRechnung'];
}

$betrag = 0;



if(empty($_SESSION['chart'])){
  echo "Der Warenkorb ist leer.";
}
else{
  echo "Deine Entnahme über <br> <br>";
// Bauteile in die Datenbank schreiben
    $Array = $_SESSION['chart'];
    $summe = 0;
    for($i = 0 ; $i < count($Array); $i++)
    {
        $innerArray = $Array[$i];

        $Bauteil = $innerArray[0];
        $bauteilid = $innerArray[1];
        $ID_Person = $innerArray[2];
        $Timestamp = $innerArray[3];
        $Änderung = $innerArray[4];
        $Preis = $innerArray[5];

        $betrag = $betrag + $Preis * $Änderung;


        $stmt = $pdo->prepare("INSERT INTO 'Mischtabelle-TBauteil-BRechnung' (ID_TBauteil, ID_BRechnung, Menge) VALUES (:idB, :idR, :men)");
        $result = $stmt->execute(array('idB' => $bauteilid, 'idR' => $ID_Rechnung, 'men' => $Änderung));

        //Menge der entommenen Bauteile in der Tabelle Bauteile abziehen
        $q = "SELECT * FROM TBauteil WHERE ID_TBauteil = '$bauteilid'";
        foreach ($pdo->query($q) as $ro) {
                $mL = $ro['MengeLagernd'];
        }
        $neueMenge = $mL - $Änderung;
        $sql = "UPDATE TBauteil SET MengeLagernd = :menge WHERE ID_TBauteil = :idB";
        $statem = $pdo->prepare($sql);
        $statem->bindParam(':menge', $neueMenge);
        $statem->bindParam(':idB', $bauteilid);
        $statem->execute();

        echo "$Änderung x  $Bauteil <br>";
    }


    $sql = "UPDATE BRechnung SET Betrag = :betrag WHERE ID_BRechnung = :idR";
    $stmtt = $pdo->prepare($sql);
    $stmtt->bindParam(':betrag', $betrag);
    $stmtt->bindParam(':idR', $ID_Rechnung);
    $stmtt->execute();



      echo "<br> wurde gespeichert. ";

      $chart->undo_chart();
    }
?>

Zurück zur <A href="Startpage.php" style="text-decoration:none;"> <font color="black"> <b>Startseite</b> </font> </A>


<br> <br> <br> <br>


</div>

</body>
</html>
