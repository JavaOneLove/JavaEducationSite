<#include "macro/security.ftl">
<#import "macro/common.ftl" as c>

<@c.page>
<h5>${username}</h5>
    ${message?ifExists}
<form method="post" action="/user/EditInfo">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Username:</label>
        <div class="col-sm-6">
            <input type="text" name="username" class="form-control" placeholder="username" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Password:</label>
        <div class="col-sm-6">
            <input type="password" name="password" class="form-control" placeholder="Password" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Email:</label>
        <div class="col-sm-6">
            <input type="email" name="email" class="form-control" placeholder="some@some.com" value="${email!''}" />
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit">Save</button>
</form>
<#if isStudent>
    <div style="margin: 20px">
        <h5>Оценки по тестам:</h5><p></p>
<div>
    <table>
        <thead>
        <tr>
            <th>Название теста</th>
            <th>Оценка</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
    <#list marks as mark>
        <#if mark.user.username == username>
            <tr>
                <td style="margin: 3px">${mark.test.name}</td>
                <td style="margin: 3px">${mark.value} /100</td>
            </tr>
        </#if>
    </#list>
        </tbody>
    </table>
</div>
    </div>
</#if>
<#if isAdmin>
<form name="AddCourse" method="post" action="/user/profile/AddCourse">
<div>
    <h4>Добавить курс</h4>
    <input type="text" name="coursename" placeholder="Введите название курса">
    <button type="submit" class="btn btn-outline-dark">Добавить</button>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
</div>
</form>
</#if>
</@c.page>