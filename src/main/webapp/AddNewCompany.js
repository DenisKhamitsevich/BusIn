const close_company_window=document.getElementById("close_company_window");
const new_company_button=document.getElementById("new_item_button_id");
const company_name = document.getElementById("new_item_name_input");

close_company_window.addEventListener("click",()=>close_company());
new_company_button.addEventListener("click",()=>new_company());

function close_company(){
    document.getElementById("overlay").setAttribute("style","display:none");
    document.getElementById("new_item_window_id").setAttribute("style","display:none");
}
function new_company(){
    document.getElementById("overlay").setAttribute("style","display:block");
    document.getElementById("new_item_window_id").setAttribute("style","display:block");
}

company_name.addEventListener("input", function (event) {
    if (company_name.validity.patternMismatch) {
        company_name.setCustomValidity(new String("Max amount of characters is 45!"));
    } else {
        company_name.setCustomValidity("");
    }

});



document.querySelector('#item_table').addEventListener('click', function(e){
    const id = e.target.id;
    if(id!="")
    {
        document.cookie="company="+id;
        window.location.href="deletecompany-servlet";
    }



});