<#import "macro/common.ftl" as c>

<@c.page>
    <form method="post">
    <#list AnswerList as test>
    <div>
        <tr>
            <td><label>${test.question}</label>
                <p><input type="text" name="answer[]"/></p></td>
        </tr>
    </div>
    </#list>
        <input type="submit">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form>
</@c.page>