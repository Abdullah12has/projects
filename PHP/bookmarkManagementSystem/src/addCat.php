<?php
require "db.php" ;
//var_dump($_POST);
if ( $_SERVER["REQUEST_METHOD"] == "POST") {
    extract($_POST) ;
    $sql = "insert into catagories (catagory_name) values (?)" ;
    try{
      $stmt = $db->prepare($sql) ;
      $stmt->execute([$catago ?? ""]) ;
      addMessage("Success") ;
    }catch(PDOException $ex) {
       addMessage("Insert Failed!") ;
    }
}

header("Location: main") ;

