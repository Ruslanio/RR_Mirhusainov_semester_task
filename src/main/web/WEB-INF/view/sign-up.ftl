<#assign tags=JspTaglibs["http://www.springframework.org/tags/form"]>

<@tags.form action = "/sign-up" method = "post" modelAttribute = "userSignUpHolder">
<fieldset>
    <div class="w3-container"></div>
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
        <input type="submit" class="w3-button" value="Sign up">
    </div>
    </div>
</fieldset>
</@tags.form>
<div>
    <a href="/sign-in" class="w3-button"> Sign in</a>
</div>