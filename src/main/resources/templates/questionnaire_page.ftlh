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
<div class="num background">
    <#assign currentPage =  pageNum?number + 1>
    <p> ${currentPage}  из ${numOfPages}</p>
    <div class="line">
        <#assign n = numOfPages>
        <#list 0..<n as i>
            <#if pageNum?number < i>
                <hr class="inactive">
            <#else>
                <hr class="active">
            </#if>
        </#list>
    </div>
</div>
<div class="background">
    <form method="post" action="/questionnaire/Migraine/15?pageNum=${pageNum}">
        <#assign num = 0>
        <#list questions as question>
            <input required type="hidden" name="listAnswer[${num}].question.id" value="${question.id}">
            <div class="question">
                <a>${question.question}</a>
                <#switch "${question.answerType}">
                    <#case 'num'>
                        <input required type="number" class="input" name="listAnswer[${num}].answer" max="99" min="0">
                        <#break>
                    <#case 'var'>
                    <p>
                        <#list answerOptions as answer>
                            <#if answer.question.id == question.id>
                                    <input required type="radio" name="listAnswer[${num}].answer" value="${answer.answer}">
                                    ${answer.answer}
                            </#if>
                        </#list>
                    </p>
                    <#break>
                    <#case 'textPlus'>
                    <#break>
                </#switch>
            </div>
            <#assign num++>
        </#list>
        <input type="submit" value="Продолжить" class="submit">
    </form>
</div>
</body>
</html>