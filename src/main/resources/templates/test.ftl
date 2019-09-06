<#import "macro/common.ftl" as c>

<@c.page>
    <#list AnswerList as test>
    <div>
        <tr>
            <td>${test.answer}</td>
        </tr>
    </div>
    </#list>
</@c.page>