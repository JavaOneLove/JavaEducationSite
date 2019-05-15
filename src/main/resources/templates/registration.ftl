<#import "macro/common.ftl" as c>
<#import "macro/login.ftl" as l>

<@c.page>
Registration a new user
    ${message?ifExists}
    <@l.login "/registration" />
</@c.page>