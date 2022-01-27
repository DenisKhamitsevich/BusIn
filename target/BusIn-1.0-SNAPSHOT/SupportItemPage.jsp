<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <div class="support" id="companies">
        <div class="review_paragraph">
            <p>Помощь</p>
    </div>
        <form class="support_form" action="support-servlet">
            <input name="email" type="email" value="${email}" class="value_field" disabled>
            <textarea name="SupportProblem" cols="30" rows="10" class="problem_data" placeholder="С чем Вам нужна помощь?" required></textarea>
            <input type="submit" value="Отправить" class="submit_button" >
        </form>
    </div>




</div>
</div>
</body>
</html>


