<#import "macro/common.ftl" as c>
<@c.page>
<div>
    <form method="post" enctype="multipart/form-data">
        <p><input type="text" name="title" placeholder="Название лекции" /></p>
        <p><input type="text" name="text" placeholder="Текст"></p>
        <p><select name="select">
        <#list courses as course>
            <option value="${course.id}">${course.title}</option>
        </#list>
        </select>
        </p>
        <input type="file" name="filename">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить</button>
    </form>
</div>
</@c.page>