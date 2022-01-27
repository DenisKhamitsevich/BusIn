<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="styles/IndexPageStyles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BusIn | CRM for small business</title>
</head>
<body>
<header>
    <h1>Bus<span class="h1_in">In</span></h1>
    <div class="nav_links">
        <a href="#about_us_link" class="nav_button">О компании</a>
        <a href="#features_link" class="nav_button">Дополнительные возможности</a>
        <a href="#support_link" class="nav_button">Поддержка клиентов</a>
    </div>

    <form action="signinbutton-servlet" ><input type="submit" value="Войти" class="sign_in_button"></form>
</header>
<section class="about_us">
    <p class="about_us_header">Бесплатная CRM система для каждого</p>
    <p class="about_us_paragraph">Вы - небольшая компания и хотите улучшить взаимоотношения с клиентами? Тогда BusIn - идельный выбор! </p>
</section>
<section class="why_busin_section">
    <h2 class="why_busin_header" id="about_us_link">Почему BusIn?</h2>
    <div class="flex_display">
        <p class="why_busin_paragraph">Потому что BusIn разработан специально для малого бизнеса, из-за чего почти все наши сервисы абсолютно бесплатны! А если вы хотите получить доступ ко всем функциям, то вы можете приобрести подписку.</p>
        <img src="./styles/assets/pictures/way_up.jpg" alt="null" class="why_busin_image">
    </div>
</section>
<section class="features_section">
    <h2 class="features_header" id="features_link">Дополнительные возможности:</h2>
    <div class="flex_display">
        <img src="./styles/assets/pictures/market.jpg" alt="null" class="features_image">
        <ul class="list_of_features">
            <li>
                <p class="premium_feature"> Отслеживание сделок </p>
            </li>
            <li>
                <p class="premium_feature"> Продвинутые аналитические системы </p>
            </li>
            <li>
                <p class="premium_feature"> Расширенные базы данных </p>
            </li>
            <li>
                <p class="premium_feature"> Круглосуточная поддержка клиентов </p>
            </li>
            <li>
                <p class="premium_feature"> Система автоматических напоминаний </p>
            </li>
        </ul>
    </div>

</section>
<section class="support_section" name="support_section_id">
    <h2 class="support_header" id="support_link">Поддержка клиентов</h2>
    <form method="post" class="support_form" action="support-servlet">
        <input name="email" type="email" class="email_data" id="email" placeholder="Email" required>
        <textarea name="SupportProblem" cols="30" rows="10" class="problem_data" placeholder="С чем Вам нужна помощь?" required></textarea>
        <input type="submit" value="Отправить" class="submit_button" >
    </form>

</section>

<footer>
    <p class="footer_busin">BusIn, 2022</p>


</footer>
</body>
</html>