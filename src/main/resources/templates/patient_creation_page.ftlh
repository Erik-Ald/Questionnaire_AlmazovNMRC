<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="style.css">
    <title>Головная боль</title>
</head>
<body class ="usual">
<#include "header.ftlh">
<div class="num">&lt;div&gt; 1 &lt;/div&gt;
</div>
    <div class="background">
        <form method="post" action="/newPatient?questionnaireType=${type}">
            <div class="question">
                <a>Фамилия</a>
                <input class="input" name="lastName">
            </div>
            <div class="question">
                <a>Имя</a>
                <input class="input" name="firstName">
            </div>
            <div class="question">
                <a>Отчество</a>
                <input class="input" name="patronymic">
            </div>
            <div class="question">
                <a>E-mail</a>
                <input class="input" type="email" name="email">
            </div>
            <div class="questionsInRow">
                <div class="question">
                    <a>Пол</a>
                    <p>
                        <input type="radio" name="sex" value="m">Мужской
                        <input type="radio" name="sex" value="f">Женский
                    </p>
                </div>
                <div class="question" id="birth">
                    <a>Дата рождения</a>
                    <p><input type="date" name="dateOfBirth"></p>
                </div>
            </div>
            <input type="submit" value="Продолжить" class="submit">
        </form>
    </div>
</body>
</html>