<#import "macro/common.ftl" as c>

<@c.page>
List of lecture
<a href="/addLecture">Добавить лекцию</a>
<table>
    <thead>
    </thead>
    <tbody>
    <#list lectures as lecture>
    <tr>
        <td>${lecture.title}</td>
        <td>${lecture.text}</td>
        <td>${lecture.author}</td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>