<#assign tags=JspTaglibs["http://www.springframework.org/tags/form"]>

<@tags.form action="/admin/delete-country" method="post">
<div>
    <button name="deleted_id" type="submit" value="${country.id}">Delete</button>
</div>
</@tags.form>