<#assign tags=JspTaglibs["http://www.springframework.org/tags/form"]>

<@tags.form action = "/sign-up" method = "post" modelAttribute = "userSUholder">
<fieldset>
    <div>
        <@tags.label path="email">Email:</@tags.label>
        <@tags.input path="email" type="email"/>
        <@tags.errors path="email"/>
    </div>
    <div>
        <@tags.label path="name">Name:</@tags.label>
        <@tags.input path="name" type="text"/>
        <@tags.errors path="name"/>
    </div>
    <div>
        <@tags.label path="password">Password:</@tags.label>
        <@tags.input path="password" type="password"/>
        <@tags.errors path="password"/>
    </div>
    <div>
        <@tags.label path="password">Repeat Password:</@tags.label>
        <@tags.input path="repeatPassword" type="password"/>
        <@tags.errors path="repeatPassword"/>
    </div>
    <div>
        <input type="submit" value="Sign up">
    </div>
</fieldset>

</@tags.form>