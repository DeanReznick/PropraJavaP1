<?php

class chart{

    /**
     *
     * Initialisiert die Klasse, muss in jeder Seite ausgeführt werden.
     */
    public function initial_chart()
    {

        $chart = array();
        if(!isset($_SESSION['chart']))
        {
            $_SESSION['chart']=$chart;
        }

    }



    public function insertArtikel($Bauteil, $ID_Bauteil, $ID_Person, $Timestamp, $Änderung, $Preis)
    {

        $Artikel = array($Bauteil, $ID_Bauteil, $ID_Person, $Timestamp, $Änderung, $Preis);
        $chart = $_SESSION['chart'];
        array_push($chart, $Artikel);
        $_SESSION['chart'] = $chart;

    }



    // Warenkorb in Tabelle ausgeben
    public function getChart()
    {
        $Array = $_SESSION['chart'];
        echo "<table width='100%'>";
        echo "<tr><th>Bauteil Name</th><th>Entnommene Menge</th><th>Einzelpreis</th><th>Gesamtpreis</th></tr>";
        for($i = 0 ; $i < count($Array); $i++)
        {
            $innerArray = $Array[$i];
            $preis = $innerArray[5] * $innerArray[4];

            echo "<tr>
            <td>$innerArray[0]</td>
            <td>$innerArray[4] Stk.</td>
            <td>$innerArray[5] €</td>
            <td>$preis €</td>
            </tr>";
        }

        echo "</table>";
    }


    // Warenkorb löschen
    public function undo_chart()
    {
        $_SESSION['chart'] = array();
    }


    public function delete_chartValue_at_Point($point)
    {
        $Array = $_SESSION['chart'];
        unset($Array[$point]);
    }

}

?>
