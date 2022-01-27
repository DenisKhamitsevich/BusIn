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
            <p>Сделки</p>
        </div>

        <input type="submit" value=" + Добавить сделку" class="new_item_button" id="new_item_button_id">

        <div class="table_item_header" id="no_hover">
            <p class="table_item">Название</p>
            <p class="table_item">Компания</p>
            <p class="table_item_phone">Контактное лицо</p>
            <p class="table_item_address">Бюджет</p>
            <p class="table_item_location" id="table_item_location_id">Статус</p>

        </div>

        <table id="item_table">
            <c:forEach var="element" items="${deals}">
                <tr class="table_item_header" >
                    <td class="table_item" >${element.getName()}</td>
                    <td class="table_item" >${element.getCompany()}</td>
                    <td class="table_item_phone" >${element.getContact()}</td>
                    <td class="table_item_address" >${element.getBudget()}</td>
                    <td class="table_item_location" >${element.getStatus()}</td>
                    <td><input class="delete_item" type="submit" value=" &#128465;" id="${element.getId()}"></td>
                </tr>
            </c:forEach>
        </table>

    </div>


    <div class="overlay" id="overlay"></div>
    <div class="new_item_window" id="new_item_window_id">
        <div class="new_item_paragraph" id="new_deals_paragraph">
            <p>Добавить сделку:</p>
            <input type="button" value="&#10006;" class="close_window" id="close_deals_window">

        </div>

        <form method="post" action="addnewdeals-servlet">
            <input type="text" name="name" placeholder="  Название" class="new_item_input" id="new_item_name_input" pattern=".{1,45}" required>
            <input type="text" name="company" placeholder="  Компания" class="new_item_input">
            <input type="text" name="contact" placeholder="  Контактное лицо" class="new_item_input" >
            <input type="text" name="budget" placeholder="  Бюджет" class="new_item_input">
            <input type="text" name="status" placeholder="  Статус" class="new_item_input" >
            <input type="submit" value="Сохранить" class="new_item_button" id="save_new_item_button">
        </form>


    </div>


</div>
</div>
<script type="text/javascript">
    <%@include file="AddNewDeals.js"%>
</script>
</body>
</html>

