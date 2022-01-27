const close_company_window=document.getElementById("close_people_window");
const new_company_button=document.getElementById("new_company_button");
const company_name = document.getElementById("new_company_name_input");

close_company_window.addEventListener("click",()=>close_company());
new_company_button.addEventListener("click",()=>new_company());

function close_company(){
    document.getElementById("overlay").setAttribute("style","display:none");
    document.getElementById("new_company_window_id").setAttribute("style","display:none");
}
function new_company(){
    document.getElementById("overlay").setAttribute("style","display:block");
    document.getElementById("new_company_window_id").setAttribute("style","display:block");
}

company_name.addEventListener("input", function (event) {
    if (company_name.validity.patternMismatch) {
        company_name.setCustomValidity(new String("Max amount of characters is 45!"));
    } else {
        company_name.setCustomValidity("");
    }

});



document.querySelector('#company_table_id').addEventListener('click', function(e){
    const id = e.target.id;
    if(id!="")
    {
        document.cookie="people="+id;
        window.location.href="deletepeople-servlet";
    }



});