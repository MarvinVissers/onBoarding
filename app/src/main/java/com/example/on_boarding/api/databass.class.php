<?php

  class Database {
    public $conn;

    private $host = 'localhost';
    private $db_name = 'bezienswaardigheid';
    private $username = 'root';
    private $password = '';

    public function getCOnnection() {
      $this->conn = null;

      try {
        $this->conn = new PDO('mysql:host=' . $this->host . ';dbname=' . $this->db_name, $this->username, $this->password);
      } catch (\PDOException $exception) {
        echo 'Connection error: ' . $exception->getMessage();
      }

      return $this->conn;
    }

  }

 ?>