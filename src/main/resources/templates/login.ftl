<#import "macro/common.ftl" as c>
<#import "macro/login.ftl" as l>

<@c.page>
<h3 style="margin: 10px">Авторизоваться</h3>
    <@l.login "/login" />
<a href="/registration">Зарегестрироваться</a>
</@c.page>