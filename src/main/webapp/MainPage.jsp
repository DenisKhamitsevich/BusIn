<%@ page import="model.Person" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <%
        Person person=(Person)session.getAttribute("person");
    %>
    <div  class="value_section">
        <p class="review_time">${part_of_the_day}, <%= person.getName()%>!</p>

        <div class="review" id="review">
            <div class="review_paragraph">
                <p>Обзор</p>
            </div>
            <div class="review_summary">
                <div class="summary">
                    <p class="summary_companies_h">Компании</p>
                    <p>Количество сотрудничающих компаний: <span class="amount_of"><%= person.getAmount_of_com()%></span></p>
                </div>
                <div class="summary">
                    <p class="summary_faces_h">Контактные лица</p>
                    <p>Количество контактных лиц: <span class="amount_of"><%= person.getAmount_of_ppl()%></span></p>
                </div>
                <div class="summary">
                    <p class="summary_sales_h">Сделки</p>
                    <p>Количество завершенных сделок: <span class="amount_of"><%= person.getAmount_of_deals()%></span></p>
                </div>

            </div>


        </div>

    </div>
</div>
</body>
</html>