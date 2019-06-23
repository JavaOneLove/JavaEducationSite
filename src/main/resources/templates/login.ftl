<#import "macro/common.ftl" as c>
<#import "macro/login.ftl" as l>

<@c.page>
<h3 style="margin: 10px">Login page</h3>
    <@l.login "/login" />
<a href="/registration">Registration</a>
</@c.page>