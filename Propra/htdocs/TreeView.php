<?php

function createTreeView($array, $currentParent, $currLevel = 0, $prevLevel = -1) {

foreach ($array as $categoryId => $category) {

if ($currentParent == $category['parent_id']) {
    if ($currLevel > $prevLevel) echo " <ol class='tree'> ";

    if ($currLevel == $prevLevel) echo " </li> ";

    echo '<li> <label for="subfolder2"> <A href="Startpage.php?id_kat='.$category['kategorie_id'].'" style="text-decoration:none;"> <font color="black"> '.$category['name'].' </font></A></label> <input type="checkbox" name="subfolder2"/>';

    if ($currLevel > $prevLevel) { $prevLevel = $currLevel; }

    $currLevel++;

    createTreeView ($array, $categoryId, $currLevel, $prevLevel);

    $currLevel--;
    }

}

if ($currLevel == $prevLevel) echo " </li>  </ol> ";

}
?>




<!DOCTYPE html>

<html>
  <head>
    <link rel="stylesheet" type="text/css" href="sytleTree.css" media="screen">
  </head>

<body text="#000000" background="b.jpg" link="#FF0000" alink="#FF0000" vlink="#FF0000">

<?php
$datenbank = "Projekt1-DB.db";
$pdo = new PDO('sqlite:' . $datenbank);

// erstelle ein Array
$arrayCategories = array();

//Array mit Daten aus Datenbnak befüllen
foreach($pdo->query('SELECT * FROM TKategorie') as $row){
 $arrayCategories[$row['ID_TKategorie']] = array("parent_id" => $row['ID_Parent'], "name" =>
 $row['Name'], "kategorie_id" => $row['ID_TKategorie']);
  }


?>

<div id="content" class="general-style1">

<?php
createTreeView($arrayCategories, 0);

?>

</div>
</body>
</html>
