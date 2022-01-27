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
            <p>Настройки</p>
        </div>
        <form class="support_form" action="newname-servlet">
            <input name="email" type="email" value="${email}" class="settings_item" disabled>
            <input type="text" name="name" class="settings_item" value="${name}" required>
            <input type="text" name="surname" class="settings_item" value="${surname}" required>
            <input type="submit" value="Сохранить" class="submit_button" id="save_new_name">
        </form>
        <p class="change_password_paragraph">Изменить пароль</p>
        <form action="newpassword-servlet">
            <input type="text" name="new_password" class="settings_item" placeholder="Новый пароль" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}" id="new_password" required>
            <div id="invalid_password_message">
                <p class="password_must_contain" id="invalid_password">Пароль должен содержать:</p>
                <p class="invalid" id="invalid_length"> <span class="wrong_set" id="w_length_set"> &#9746;</span> <span class="right_set" id="r_length_set"> &#9745;</span> От 8 до 16 символов</p>
                <p class="invalid" id="invalid_number"> <span class="wrong_set" id="w_number_set"> &#9746;</span> <span class="right_set" id="r_number_set"> &#9745;</span> Хотя бы одну цифру</p>
                <p class="invalid" id="invalid_letter"> <span class="wrong_set" id="w_letter_set"> &#9746;</span> <span class="right_set" id="r_letter_set"> &#9745;</span> Хотя бы одну букву</p>
                <p class="invalid" id="invalid_upper"> <span class="wrong_set" id="w_upper_set"> &#9746;</span> <span class="right_set" id="r_upper_set"> &#9745;</span> Хотя бы одну заглавную букву</p>
            </div>
            <input type="submit" value="Сохранить" class="submit_button" id="change_password">
        </form>
    </div>




</div>
</div>
<script type="text/javascript">
    <%@include file="Settings.js"%>
</script>
</body>
</html>


