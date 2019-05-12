<#import "macro/common.ftl" as c>
<#import "macro/login.ftl" as l>

<@c.page>
Login page
    <@l.login "/login" />
<a href="/registration">Registration</a>
</@c.page>