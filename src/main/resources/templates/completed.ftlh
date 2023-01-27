<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/style.css">
    <title>Головная боль</title>
</head>
<body class ="usual">
<#include "header.ftlh">
<div class="background">
    <#if python == "successful">
        <a>Спасибо за прохождение опроса!</a>
        <#else>
        <a>${python}</a>
    </#if>

</div>
</body>
</html>