<#import "macro/common.ftl" as c>
<#import "macro/login.ftl" as l>

<@c.page>
<h3 style="margin: 10px">Registration a new user</h3>
    ${message?ifExists}
    <@l.login "/registration" />
</@c.page>