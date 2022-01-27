const close_deals_window=document.getElementById("close_deals_window");
const new_deals_button=document.getElementById("new_item_button_id");
const deal_name = document.getElementById("new_item_name_input");

close_deals_window.addEventListener("click",()=>close_company());
new_deals_button.addEventListener("click",()=>new_company());

function close_company(){
    document.getElementById("overlay").setAttribute("style","display:none");
    document.getElementById("new_item_window_id").setAttribute("style","display:none");
}
function new_company(){
    document.getElementById("overlay").setAttribute("style","display:block");
    document.getElementById("new_item_window_id").setAttribute("style","display:block");
}

deal_name.addEventListener("input", function (event) {
    if (deal_name.validity.patternMismatch) {
        deal_name.setCustomValidity(new String("Max amount of characters is 45!"));
    } else {
        deal_name.setCustomValidity("");
    }

});



document.querySelector('#item_table').addEventListener('click', function(e){
    const id = e.target.id;
    if(id!="")
    {
        document.cookie="deals="+id;
        window.location.href="deletedeals-servlet";
    }



});