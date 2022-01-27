<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="model.Person" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles/MainPageStyles.css">
    <title>BusIn</title>
</head>
<body>

<div class="flex_display">
    <div class="navigation" id="navigation">
        <form action="mainpage-servlet"><input type="submit" value=" &#10026;    Обзор" class="navigation_button" ></form>
        <form action="companies-servlet"><input type="submit" value=" &#9750;    Компании" class="navigation_button" ></form>
        <form action="people-servlet"><input type="submit" value=" &#9743;    Контактные лица" class="navigation_button"></form>
        <form action="deals-servlet"><input type="submit" value=" &#9745;    Сделки" class="navigation_button"></form>
        <form action="settings-servlet"><input type="submit" value=" &#9881;    Настройки" class="navigation_button"></form>
        <form action="SupportItemPage.jsp"><input type="submit" value=" &#9432    Помощь" class="navigation_button"></form>
        <form action="exit-servlet"><input type="submit" value=" &#8658;    Выход" class="navigation_button"></form>
    </div>


    <div>
        <div class="review_paragraph">
            <p>Компании</p>
        </div>

            <input type="submit" value=" + Добавить компанию" class="new_item_button" id="new_item_button_id">

        <div class="table_item_header" id="no_hover">
            <p class="table_item">Название</p>
            <p class="table_item">Сайт</p>
            <p class="table_item_phone">Телефон</p>
            <p class="table_item_address">Адрес</p>
            <p class="table_item_location" id="table_item_location_id">Расположение</p>

        </div>
        <table id="item_table">
            <c:forEach var="element" items="${companies}">
                <tr class="table_item_header" >
                    <td class="table_item" >${element.getName()}</td>
                    <td class="table_item" >${element.getSite()}</td>
                    <td class="table_item_phone" >${element.getPhone()}</td>
                    <td class="table_item_address" >${element.getAddress()}</td>
                    <td class="table_item_location" >${element.getLocation()}</td>
                    <td><input class="delete_item" type="submit" value=" &#128465;" id="${element.getId()}"></td>
                </tr>
            </c:forEach>
        </table>

    </div>





    <div class="overlay" id="overlay"></div>
    <div class="new_item_window" id="new_item_window_id">
        <div class="new_item_paragraph">
            <p>Добавить компанию:</p>
            <input type="button" value="&#10006;" class="close_window" id="close_company_window">

        </div>

        <form method="post" action="addnewcompany-servlet">
            <input type="text" name="name" placeholder="  Название компании" class="new_item_input" id="new_item_name_input"
                   pattern=".{1,45}" required>
            <input type="text" name="site" placeholder="  Сайт" class="new_item_input" >
            <input type="text" name="phone" placeholder="  Телефон" class="new_item_input" >
            <input type="text" name="address" placeholder="  Адрес" class="new_item_input" >
            <input type="text" name="location" placeholder="  Расположение" class="new_item_input">
            <input type="submit" value="Сохранить" class="new_item_button" id="save_new_item_button">
        </form>


    </div>


    </div>
</div>
<script type="text/javascript">
    <%@include file="AddNewCompany.js"%>
</script>
</body>
</html>

