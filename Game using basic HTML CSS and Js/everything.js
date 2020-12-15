
var selected = 4;
var posArs;
function getvar() {
    $("#diop").change(function () {
        selected = $(this).val();
    });
}

function generatePos(numOfVals) {
    var posArr = []; //array of object


    for (var i = 0; i < numOfVals; i++) {
        var pos = { width: 20, height: 10 };

        pos.width = Math.floor(Math.random() * 500);
        pos.height = Math.floor(Math.random() * 500);

        posArr[i] = pos;


        for (var k = 0; k < i; k++) {
            //if( (posArr[i].width >= posArr[k].width -50 && (posArr[i].height >= posArr[k].height -50 || posArr[i].height <= posArr[k].height +50 ) ) || (posArr[i].width >= posArr[k].width +50 && (posArr[i].height >= posArr[k].height -50 || posArr[i].height <= posArr[k].height +50 ) )   )
            if (posArr[i].width === posArr[k].width && posArr[i].height === posArr[k].height) {
                i--;
            }

        }
    }


    return posArr;
}


$(function () {



    $("#coverInner").slideUp(1200).delay(1200).slideDown(600);
    $("#coverInner").animate({ 'font-size': '20px' }, 1000)
        .animate({ width: 200 })
        .animate({ left: $(window).width() + 10 }, 1000)
        .animate({ right: $(window).width() + 20 }, 1000)
        .animate({ left: $(window).width() + 20 }, 1000)
        .animate({ left: 0 }, 1000);

        $("#interrupt").fadeOut(0);
        $("#success").fadeOut(0);
    getvar();




});


$(function () {

    $("#playButton").click(function () {




        $("#cover").fadeOut(500);

        $("#nextPage").fadeIn(500)
            .css({ 'width': '80%' })
            .css({ 'height': '650px' })
            .css({ 'margin-left': '130px' })
            .css({ 'margin-top': '50px' })
            .css({ 'background-image': 'url("backg7.jpg")' })
            .css({ 'background-size': 'cover' });


        posArs = generatePos(selected);



        for (var i = 0; i < selected; i++) {
            var nextid = "#0fb";

            var objects = `<div  id="${i}ob" class="box"></div>`;

            $(nextid).append(objects);

            nextid = "#" + i + "ob";


        }


        for (var i = 0; i < selected; i++) {
            $("#" + i + "ob").css({ 'margin-left': posArs[i].width + "px" })
        }


        $(function () {

            var arr = [];
            while (arr.length < selected) {
                var randomnumber = Math.ceil(Math.random() * selected)
                if (arr.indexOf(randomnumber) === -1) { arr.push(randomnumber) }
            }
            console.log(arr);

            //now the writing num to obj

            for (var i = 0; i < selected; i++) {

                var content = `<p class='a' id="aa${i}">${i + 1}</p>`;

                $("#" + (arr[i] - 1) + "ob").append(content);


                $("#aa" + i).fadeOut(0);

            }
           

            $(function () {

                var i = 0, howManyTimes = selected;
                function f() {
                   
                    $({})
                    .queue(function (next) {
                        $("#aa"+i).fadeIn(3000).fadeOut(2000, next);

                    });

                    i++;

                    if (i < howManyTimes) {
                        setTimeout(f, 3000);
                    }
                }
                f();

            });

            $(function(){

               
                function clickF() {
                   
                    var idCatch;
                    var clicked = 0;
                    var obby = `<div id="yes"> </div>`;
                    var obbn = `<div id="no"> </div>`;


                    $(".box")
                    .click(function () {

                     

                     idCatch = $(this).children().get(0).id;

                     if(idCatch < "aa"+clicked)
                     {
                         
                         
                     }

                     else if(idCatch == "aa"+clicked)
                     {
                        $(this).append(obby);
                         clicked++;
                     }
                     else{
                        
                        $(this).append(obbn);

                        $("#nextPage").fadeOut(2000);

                        $("#interrupt").fadeIn(1000);

                     }

                     alert(clicked +"  "+selected);
                     if(clicked === selected)
                     {
                        $("#nextPage").fadeOut(2000);

                        $("#success").fadeIn(1000);
                     }

                     
                    });

                    


                  
                }
               
                setTimeout(clickF, selected*3000);
               


            });



        });

    });



});