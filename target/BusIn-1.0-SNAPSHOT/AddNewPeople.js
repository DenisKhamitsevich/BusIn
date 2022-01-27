const close_ppl_window=document.getElementById("close_people_window");
const new_ppl_button=document.getElementById("new_item_button_id");
const ppl_name = document.getElementById("new_item_name_input");

close_ppl_window.addEventListener("click",()=>close_company());
new_ppl_button.addEventListener("click",()=>new_company());

function close_company(){
    document.getElementById("overlay").setAttribute("style","display:none");
    document.getElementById("new_item_window_id").setAttribute("style","display:none");
}
function new_company(){
    document.getElementById("overlay").setAttribute("style","display:block");
    document.getElementById("new_item_window_id").setAttribute("style","display:block");
}

ppl_name.addEventListener("input", function (event) {
    if (ppl_name.validity.patternMismatch) {
        ppl_name.setCustomValidity(new String("Max amount of characters is 45!"));
    } else {
        ppl_name.setCustomValidity("");
    }

});



document.querySelector('#item_table').addEventListener('click', function(e){
    const id = e.target.id;
    if(id!="")
    {
        document.cookie="people="+id;
        window.location.href="deletepeople-servlet";
    }



});