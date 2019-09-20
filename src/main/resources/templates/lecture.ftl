<#import "macro/common.ftl" as c>

<@c.page>
<form  method="post">
    <select name="select" class="custom-select mr-sm-2">
        <#list courses as course>
            <option value="${course.id}">${course.title}</option>
        </#list>
    </select>
    <a href="/createTest"><button class="btn btn-success" type="submit">Создать тест</button></a>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
</form>
    <h3>Лекции</h3>
    <a href="/addLecture">Добавить лекцию</a>
    <table class="table">
        <thead>
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
        <thead>
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