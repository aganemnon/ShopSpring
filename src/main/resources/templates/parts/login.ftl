<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group">
            <label for="login">Login</label>
            <input type="text" name="username" class="form-control" id="login" placeholder="Enter login">
            <small id="loginHelp" class="form-text text-muted">We'll never share your login with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="InputPassword1">Password</label>
            <input type="password" name="password" class="form-control" id="InputPassword1" placeholder="Password">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-primary"><#if isRegisterForm>Sing In<#else>Log In</#if></button>
        <#if !isRegisterForm><a href="/registration">Sing In</a></#if>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-primary">Log Out</button>
    </form>
</#macro>
