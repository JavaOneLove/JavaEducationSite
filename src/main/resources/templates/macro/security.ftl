<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    isAdmin = user.isAdmin()
    isTeacher = user.isTeacher()
    isStudent = user.isStudent()
    >
<#else >
    <#assign
    name = "unknown"
    isAdmin = false
    isTeacher = false
    isTeacher = false
    >
</#if>