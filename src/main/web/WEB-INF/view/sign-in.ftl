<#assign tags=JspTaglibs["http://www.springframework.org/tags/form"]>

<@tags.form action = "/login" method = "post" modelAttribute = "userSignInHolder">
<fieldset>
    <div>
        <@tags.label path="email">Email</@tags.label>
        <@tags.input path="email" type="email"/>
        <@tags.errors path="email"/>
    </div>
    <div>
        <@tags.label path="password">Password</@tags.label>
        <@tags.input path="password" type="password"/>
        <@tags.errors path="password"/>
    </div>
    <div>
        <input type="submit" value="Sign ip">
    </div>
</fieldset>
<a href="/sign-up">Sign up</a>

</@tags.form>
