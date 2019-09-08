<#import "macro/common.ftl" as c>

<@c.page>
<div>Hello, ${User.username}</div>
<a href="/user">Main page</a>
<a href="/user/profile">Profile</a>
<a href="/course">Курсы</a>
</@c.page>