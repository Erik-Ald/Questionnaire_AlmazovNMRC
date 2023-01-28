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
<div class="num background">
    <p> 1 из ${numOfPages}</p>
    <div class="line">
        <#assign n = numOfPages>
        <#list 0..<n as i>
            <#if 0 < i>
                <hr class="inactive">
            <#else>
                <hr class="active">
            </#if>
        </#list>
    </div>
</div>
    <div class="background">
        <form method="post" action="/newPatient?questionnaireType=${type}">
            <div class="question">
                <a>Фамилия</a>
                <input required class="input" name="lastName">
            </div>
            <div class="question">
                <a>Имя</a>
                <input required class="input" name="firstName">
            </div>
            <div class="question">
                <a>Отчество</a>
                <input required class="input" name="patronymic">
            </div>
            <div class="question">
                <a>E-mail</a>
                <input required class="input" type="email" name="email">
            </div>
            <div class="questionsInRow">
                <div class="question">
                    <a>Пол</a>
                    <p>
                        <input required type="radio" name="sex" value="m">Мужской
                        <input required type="radio" name="sex" value="f">Женский
                    </p>
                </div>
                <div class="question" id="birth">
                    <a>Дата рождения</a>
                    <p><input required type="date" name="dateOfBirth"></p>
                </div>
            </div>
            <input type="submit" value="Продолжить" class="submit">
        </form>
    </div>
</body>
</html>