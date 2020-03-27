<?php

  if(!isset($_GET['bezienswaardigheid'])) {
      echo 'Error, no GET value set';
      return;
  }
else{

  $bezienswaardigheid = htmlspecialchars($_GET['bezienswaardigheid']);

  require_once 'database.class.php';

  $database = new Database();
  $db = $database->getConnection();

  $query = sprintf('SELECT foto, bezienswaardigheid_id FROM bezienswaardigheid', $bezienswaardigheid);
        // Kijken of de query uitgevoerd kan worden
        $stm = $db->prepare($query);

        if($stm->execute()) {
            // Resultaat ophalen
            $result = $stm->fetchAll(PDO::FETCH_OBJ);
            // JSON terugsturen
            echo json_encode(array("item"=>$result));
        }
  }
  ?>