<#import "macro/common.ftl" as c>

<@c.page>
List of users
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td style="margin: 4px">${user.username}</td>
        <td style="margin: 4px"><#list user.roles as role>${role}<#sep>, </#list></td>
        <td style="margin: 4px"><a href="/user/${user.id}">edit</a></td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>