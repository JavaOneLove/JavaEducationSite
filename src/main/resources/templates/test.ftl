<#import "macro/common.ftl" as c>

<@c.page>
    <#assign count = 0>
    <form method="post">
    <#list AnswerList as test>
    <div>
        <tr>
            <td><label>${test.question}</label>
                <p><input type="text" name="answer[]"/></p></td>
        </tr>
    </div>
        <#assign count++>
    </#list>
        <input type="submit">
        <input type="hidden" name="count" value="${count}" />
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form>
</@c.page>