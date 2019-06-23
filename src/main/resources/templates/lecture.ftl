<#import "macro/common.ftl" as c>

<@c.page>
    <form  method="post" style="border-style: solid">
       <p><input name="value" type="number">Кол-во вопросов</input></p>
        <select name="select">
        <#list courses as course>
            <option value="${course.id}">${course.title}</option>
        </#list>
        </select>
       <a href="/createTest"><button class="btn btn-success" type="submit">Создать тест</button></a>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form>
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
    List of test
    <table>
        <thead>
        </thead>
        <tbody>
    <#list tests as test>
    <div>
        <tr>
            <p><td>${test.name}</td></p>
            <p><a>Пройти тест (Coming soon...)</a></p>
        </tr>
    </div>
    </#list>
        </tbody>
    </table>
</@c.page>