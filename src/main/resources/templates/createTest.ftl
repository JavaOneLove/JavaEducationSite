<#import "macro/common.ftl" as c>

<@c.page>
  <form method="post" enctype="multipart/form-data">
      <p><input type="text" name="title" placeholder="Название теста"/></p>
      <#list 1..countQuestion as x>
      Вопрос №${x}:
      <p><input type="text" name="question[]" placeholder="Вопрос"/></p>
      <p><input type="text" name="answer[]" placeholder="Ответ"/></p>
      </#list >
      <input type="hidden" name="_csrf" value="${_csrf.token}" />
      <button type="submit">Добавить</button>
    </form>
</@c.page>