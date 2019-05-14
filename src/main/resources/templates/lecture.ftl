<#import "macro/common.ftl" as c>

<@c.page>
List of lecture

<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Text</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list lecture as user>
    <tr>
        <td>${lecture.}</td>
        <td><#list user.roles as role>${role}<#sep>, </#list></td>
        <td><a href="/user/${user.id}">edit</a></td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>