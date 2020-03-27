<?php

  require_once 'database.class.php';

  $database = new Database();
  $db = $database->getConnection();

  echo "Team 04";

  if($db)
    echo "<br/> Database OK!";

 ?>
