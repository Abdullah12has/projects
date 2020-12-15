<?php
  require "db.php" ;

  $id = $_GET["id"] ?? "";
  // $cid = $_GET['cid'] ?? ""; // problem here, quert not woring for some reason__________________

  // var_dump($cid);
  try {

      // $stmt = $db->prepare("delete from catagories where catagory_id = :cid") ;
      // $stmt->execute(["catagory_id" => $cid]) ;

      $stmt = $db->prepare("delete from bookmark where id = :id") ;
      $stmt->execute(["id" => $id]) ;

 

      if ( $stmt->rowCount() > 0) {
        echo json_encode(["status" => "ok", "message" => "$id bookmark deleted."]) ;
      } else {
        echo json_encode(["status" => "error", "message" => "id is missing or invalid"]) ;
      }

  } catch(PDOException $ex) {
    echo json_encode(["status" => "error", "message" => "Query syntax error"]) ;
  }

  
  // Redirection
  // header("Location: index.php?page=main") ; // reloading main page.