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

<div class="middle_section">
    <div class="navigation" id="navigation">
        <form action="mainpage-servlet"><input type="submit" value=" &#10026;    Обзор" class="navigation_button" id="review_button" ></form>
        <form action="companies-servlet"><input type="submit" value=" &#9750;    Компании" class="navigation_button" id="companies_button"></form>
        <form action="people-servlet"><input type="submit" value=" &#9743;    Контактные лица" class="navigation_button" id="faces_button"></form>
        <form action="deals-servlet"><input type="submit" value=" &#9745;    Сделки" class="navigation_button" id="sales_button"></form>
        <form action="settings-servlet"><input type="submit" value=" &#9881;    Настройки" class="navigation_button" id="settings_button"></form>
        <form action="SupportItemPage.jsp"><input type="submit" value=" &#9432    Помощь" class="navigation_button" id="help_button"></form>
        <form action="exit-servlet"><input type="submit" value=" &#8658;    Выход" class="navigation_button" id="exit_button"></form>
    </div>

    <div class="companies" id="companies">
        <div class="review_paragraph">
            <p>Компании</p>
        </div>

            <input type="submit" value=" + Добавить компанию" class="new_company_button" id="new_company_button">

        <div class="company_table_header" id="no_hover">
            <p class="company_item">Название</p>
            <p class="company_item">Сайт</p>
            <p class="company_item_phone">Телефон</p>
            <p class="company_item_address">Адрес</p>
            <p class="company_item_location" id="company_location">Расположение</p>

        </div>
        <table id="company_table_id">
            <c:forEach var="element" items="${companies}">
                <tr class="company_table_header" >
                    <td class="company_item" >${element.getName()}</td>
                    <td class="company_item" >${element.getSite()}</td>
                    <td class="company_item_phone" >${element.getPhone()}</td>
                    <td class="company_item_address" >${element.getAddress()}</td>
                    <td class="company_item_location" >${element.getLocation()}</td>
                    <td><input class="delete_company" type="submit" value=" &#128465;" id="${element.getId()}"></td>
                </tr>
            </c:forEach>
        </table>

    </div>


    <div class="overlay" id="overlay"></div>
    <div class="new_company_window" id="new_company_window_id">
        <div class="new_company_paragraph">
            <p>Добавить компанию:</p>
            <input type="button" value="&#10006;" class="close_window" id="close_company_window">

        </div>

        <form action="addnewcompany-servlet">
            <input type="text" name="name" placeholder="  Название компании" class="new_company_input" id="new_company_name_input" pattern=".{1,45}" required>
            <input type="text" name="site" placeholder="  Сайт" class="new_company_input" id="new_company_site_input">
            <input type="text" name="phone" placeholder="  Телефон" class="new_company_input" id="new_company_phone_input">
            <input type="text" name="address" placeholder="  Адрес" class="new_company_input" id="new_company_address_input">
            <input type="text" name="location" placeholder="  Расположение" class="new_company_input" id="new_company_location_input">
            <input type="submit" value="Сохранить" class="new_company_button" id="save_new_company_button">
        </form>


    </div>


    </div>
</div>
<script type="text/javascript">
    <%@include file="AddNewCompany.js"%>
</script>
</body>
</html>

