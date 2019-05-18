<#import "macro/common.ftl" as c>

<@c.page>
    List of lecture
    <a href="/addLecture">Добавить лекцию</a>
    <table>
        <thead>
        </thead>
        <tbody>
    <#list lectures as lecture>
    <div>
    <tr>
        <p><td>${lecture.title}</td></p>
        <p><td>${lecture.text}</td></p>
        <p><td>${lecture.author}</td></p>
        <p><td>
        <#if lecture.filename??>
            <img src="/img/${lecture.filename}" style="width: 50px;height: 50px">
            <a href="/img/${lecture.filename}" download="${lecture.filename}">Скачать</a>
        </#if>
        <td></p>
    </tr>
    </div>
    </#list>
        </tbody>
    </table>
</@c.page>