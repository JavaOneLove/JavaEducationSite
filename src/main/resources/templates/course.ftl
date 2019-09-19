<#import "macro/common.ftl" as c>

<@c.page>
<table>
    <thead>

    </thead>
    <tbody>
    <#list courses as course>
    <tr>
        <td style="padding-bottom: 10px;padding-left: 10px"><a href="/course/${course.id}"><button class="btn btn-outline-primary" type="submit">Лекции</button></a></td>
        <td >${course.title}</td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>