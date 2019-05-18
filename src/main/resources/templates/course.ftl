<#import "macro/common.ftl" as c>

<@c.page>
<table>
    <thead>

    </thead>
    <tbody>
    <#list courses as course>
    <tr>
        <td>${course.title}</td>
        <td><a href="/course/${course.id}"><button type="submit">Лекции</button></a></td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>