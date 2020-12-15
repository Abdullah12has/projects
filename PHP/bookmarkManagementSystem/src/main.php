<?php
   
   require "db.php" ;

    // To remember sort between pages.
    // You can use the same technique for page numbers in pagination.
    //$sort = $_GET["sort"] ?? "created" ;
   if ( !isset($_GET["sort"])) {
        $sort = $_SESSION["sort"] ?? "created" ;
    } else {
        $sort = $_GET["sort"] ;
        $_SESSION["sort"] = $sort ; 
    } 
    
  
    $users = $db->query("select * from user order by name")->fetchAll(PDO::FETCH_ASSOC) ;
    $bookmarks = $db->query("select user.id uid, bookmark.id bid, name, title, note, created, url, bookmark.catagory
                            from bookmark, user 
                            where user.id = bookmark.owner and user.id = {$_SESSION["user"]["id"]}
                            order by $sort desc")->fetchAll(PDO::FETCH_ASSOC) ;
    $catagories = $db->query("select * from catagories order by catagory_name ASC")->fetchAll(PDO::FETCH_ASSOC) ;
    // var_dump($catagories);




?>

<!-- Floating button at the bottom right -->
<div class="fixed-action-btn">
  <a class="btn-floating btn-large red modal-trigger z-depth-2" href="#add_form">
    <i class="large material-icons">add</i>
  </a>
</div>



<div class="row">

<div class="col s2">
  <!-- Grey navigation panel -->
  <!-- Adding the catagories table here -->
 
  <div>

  <table class='center'>
        <thead>
          <tr>
              <th class='center card-panel teal lighten-2' >ALL</th>
          </tr>
        </thead>
        <tbody>
           <?php foreach($catagories as $ctg)  : ?>
            <tr id="cat<?= $ctg["catagory_id"] ?>">
            <td class='center'><span class="truncate"><?= $ctg['catagory_name'] ?>  <a href="<?= $ctg['catagory_id'] ?>" class="ctg-delete btn-floating btn-small"><i class="material-icons">remove</i></a></span> </td>
            </tr>
          <?php endforeach ?>
        </tbody>
      </table>

  </div>
  <!-- the + button -->
  <div class='center' style="padding-top:5px;"> <a href='#add_cat' class="btn-floating btn-small waves-effect waves-light"><i class="material-icons">add</i></a>
 </div>
 
 
</div>

<div class="col s10">
  <!-- Teal page content  -->
  <!-- Main Table for all bookmarks -->
<div>
    <table class="striped"  id="main-table">
     <tr style="height:60px" class="grey lighten-5">
         <th class="title">
             <a href="?sort=title">Title 
             <?= $sort == "title" ? "<i class='material-icons'>arrow_drop_down</i>": "" ?>
             </a>
        </th>
         <th class="note">
             <a href="?sort=note">Note 
             <?= $sort == "note" ? "<i class='material-icons'>arrow_drop_down</i>": "" ?>
             </a>
        </th>
         <th class="created hide-on-med-and-down">
             <a href="?sort=created">Date 
             <?= $sort == "created" ? "<i class='material-icons'>arrow_drop_down</i>": "" ?>
             </a>
        </th>
         <th class="action">Actions</th>
     </tr>
     <?php foreach($bookmarks as $bm)  : ?>
       <tr id="row<?= $bm["bid"] ?>">
           <td><span class="truncate"><a href="<?= $bm['url'] ?>"><?= $bm['title'] ?></a></span></td>
           <td><span class="truncate"><?= $bm['note'] ?></span></td>
           <td class="created hide-on-med-and-down"><?php
              $date = new DateTime($bm['created']);
              echo $date->format("d M y"); 
             ?>
            </td>
            <td class="action">
               <a href="<?= $bm["bid"] ?>" class="bms-delete btn-small"><i class="material-icons">delete</i></a>
               <a class="btn-small bms-view" href="<?= $bm['bid'] ?>"><i class="material-icons">visibility</i></a>
            </td>
       </tr>
     <?php endforeach ?>
    </table>

</div>
</div>

</div>





<!-- All modal bookmarks in detail to show after clicking view buttons -->
  <div id="bm-detail" class="modal">
  <div class="modal-content">
    <table class="striped">
        <tr>
            <td>Title:</td>
            <td id="detail-title"></td>
        </tr>
        <tr>
            <td>Note:</td>
            <td id="detail-note"></td>
        </tr>
        <tr>
            <td>URL:</td>
            <td id="detail-url"></td>
        </tr>
        <tr>
            <td>Date:</td>
            <td id="detail-date"></td>
        </tr>
    </table>
  </div>
  <div class="modal-footer">
    <a href="#!" class="modal-close waves-effect waves-green btn-flat">Close</a>
  </div>
</div>


<!-- Modal Form for new Bookmark -->
<div id="add_form" class="modal">
  <form action="addBM" method="post" >
    <div class="modal-content">
        <h5 class="center">New Bookmark</h5>
        <input type="hidden" name="owner" value="<?= $_SESSION["user"]["id"]?>">
        <div class="input-field">
          <input id="title" type="text" name="title" >
          <label for="title">Title</label>
        </div>
        <div class="input-field">
            <input id="url" type="text" name="url" >
            <label for="url">URL</label>
        </div>
        <div class="input-field">
          <textarea id="note" class="materialize-textarea" name="note"></textarea>
          <label for="note">Notes</label>
        </div>
      </div>
      <div class="modal-footer">
        <button  class="btn waves-effect waves-light" type="submit" name="action">Add
         <i class="material-icons right">send</i>
      </button>
    </div>
  </form>
  
</div>


<!-- Modal Form for new catagory -->
<div id="add_cat" class="modal">
  <form action="addCat" method="post">
    <div class="modal-content">
        <h5 class="center">New Catagory</h5>
        <div class="input-field">
          <input id="cat_name" type="text" name="cat_name" >
          <label for="cat_name">Catagory Name</label>
        </div>
      </div>
      <div class="modal-footer">
        <button  class="btn waves-effect waves-light" type="submit" name="action"> Add Catagory
         <i class="material-icons right">send</i> 
      </button>
    </div>
  </form>
  
</div>

<!-- ----------------------------- -->

<div class="center hide" id="loader">
  <div class="preloader-wrapper small active">
      <div class="spinner-layer spinner-green-only">
        <div class="circle-clipper left">
          <div class="circle"></div>
        </div><div class="gap-patch">
          <div class="circle"></div>
        </div><div class="circle-clipper right">
          <div class="circle"></div>
        </div>
      </div>
    </div>
</div> 

<!-- Initialization of modal elements and listboxes -->
  <script>

    var instanceDetail ;
    document.addEventListener('DOMContentLoaded', function() {
        var elems = document.querySelectorAll('.modal');
        var instances = M.Modal.init(elems);
        instanceDetail = M.Modal.init(document.getElementById("bm-detail")) ;

        elems = document.querySelectorAll('select');
        M.FormSelect.init(elems);
    });


    $(function(){
       // page is loaded
       //alert("jquery works");
       $(".bms-delete").click(function(e){
          e.preventDefault() ;
         // alert("Delete Clicked") ;
         let id = $(this).attr("href") ;
        //  alert( id + " clicked");
         $("#loader").toggleClass("hide") ; // show loader.
         $.get("delete",
               { "id" : id},
               function(data) {
                  console.log(data) ;
                  $("#row" + id).remove(); // removes from html table.
                  $("#loader").toggleClass("hide") ; // hide loader.
                  M.toast({html: 'Deleted', classes: 'rounded', displayLength: 1000});
               },
               "json" 
         );
       });

      //  function to delete catagory

      $(".ctg-delete").click(function(e){
          e.preventDefault() ;
        //  alert("Delete Clicked") ;
         let id = $(this).attr("href") ;
        //  alert( id + " clicked"); //gets the id
         $("#loader").toggleClass("hide") ; // show loader.
         $.get("delete",   //for some reason doesn't delete the catagory from the database
               { "cid" : id},
               function(data) {
                  console.log(data) ;
                  $("#cat" + id).remove(); // removes from html table.
                  $("#loader").toggleClass("hide") ; // hide loader.
                  M.toast({html: ' Catagory Deleted', classes: 'rounded', displayLength: 1000});
               },
               "json"
         );
       });


       $(".bms-view").click(function(e){
          e.preventDefault();
          let id = $(this).attr("href");
          console.log("bms view clicked id " + id) ;
          $("#loader").toggleClass("hide") ; // show loader.
          $.get("getBM",
                {"id" : id},
                function (data) {
                   console.log(data) ;
                   $("#detail-title").text(data.title) ;
                   $("#detail-url").text(data.url) ;
                   $("#detail-note").text(data.note) ;
                   $("#detail-date").text(data.created) ;
                   instanceDetail.open() ;
                   $("#loader").toggleClass("hide") ; // hide loader.
                } 
                , "json"
          )
       });
    });

  </script>




  
