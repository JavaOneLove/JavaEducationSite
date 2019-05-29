<#import "macro/common.ftl" as c>

<@c.page>
<#list 1..5 as x >
Вопрос #${x}:
  <form method="post" enctype="multipart/form-data">
      <p><input type="text" name="question" placeholder="Вопрос" value="${question}" /></p>
      <p><input type="text" name="answer" placeholder="Ответ"></p>
      <input type="hidden" name="_csrf" value="${_csrf.token}" />
      ${Question} += ${question};
      <input type="hidden" name="que" value="${Question}">
      <button type="submit">Добавить</button>
  </form>
</#list>
</@c.page>