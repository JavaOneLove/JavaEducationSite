<#import "macro/common.ftl" as c>
<#import "macro/login.ftl" as l>

<@c.page>
<h3 style="margin: 10px">Зарегестрироваться</h3>
    ${message?ifExists}
    <@l.login "/registration" />
</@c.page>