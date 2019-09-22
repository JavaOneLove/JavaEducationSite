<#import "macro/common.ftl" as c>

<@c.page>
    <h3>Лекции</h3>
    <a href="/addLecture">Добавить лекцию</a>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th>Название</th>
            <th>Описание</th>
            <th>Автор</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
    <#list lectures as lecture>
    <div>
    <tr>
        <td class="table-primary">${lecture.title}</td>
        <td class="table-primary">${lecture.text}</td>
        <td class="table-primary">${lecture.author}</td>
        <td class="table-primary">
        <#if lecture.filename??>
            <img src="/img/${lecture.filename}" style="width: 50px;height: 50px">
            <a href="/img/${lecture.filename}" download="${lecture.filename}">Скачать</a>
        </#if>
        <td>
    </tr>
    </div>
    </#list>
        </tbody>
    </table>
    <h3>Тесты</h3>
    <table class="table">
        <thead class="thead-dark">
        <tr>
        <th>Название</th>
        <th></th>
        </tr>
        </thead>
        <tbody>
    <#list tests as test>
    <div>
        <tr>
            <td>${test.name}</td>
            <td><a href="/test/${test.id}">Пройти</a></td>
        </tr>
    </div>
    </#list>
        </tbody>
    </table>
</@c.page>