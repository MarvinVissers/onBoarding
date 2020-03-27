<?php
    /**
    * Krijgen van boeken per opleiding
    */

    // Kijken of er een studentnummer is meegegeven
    if(!isset($_GET['opleiding'])){
        $error = "Er is geen opleiding meegegeven";
    }else {

        // Studentnummer in URL omzetten naar variabele
        $opleiding = htmlspecialchars($_GET['opleiding']);

        // Database connection class aanspreken
        require_once('database.class.php');

        // Variabele aanmaken voor connectie
        $database = new Database();
        $db = $database->getConnection();

        // Query maken
        // sprintf is mijn manier van querys escapen
        $query = sprintf('SELECT b.boek_isbn, b.boek_naam, b.boek_prijs_nieuw, b.boek_prijs_oud 
        FROM boek_opleiding bo 
        INNER JOIN boek b ON bo.boek_isbn = b.boek_isbn 
        WHERE bo.opleiding_id = %u', $opleiding);
        //$query = sprintf("SELECT bo.opleiding_id FROM boek_opleiding bo");

        // Query preparen, aka kijken of die uitgevoerd kan worden
        $stm = $db->prepare($query);
        // Als de query uitgevoerd wordt
        if($stm->execute()) {
            // Resultaat ophalen
            $result = $stm->fetchAll(PDO::FETCH_OBJ);

            // JSON teruggeven
            echo json_encode(array("item"=>$result));
        }
    }
?>
