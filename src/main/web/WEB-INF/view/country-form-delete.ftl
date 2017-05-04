<#assign tags=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "head.ftl">
<@tags.form action="/admin/delete-country" method="post">
<div class="w3-container">
    <button name="deleted_id" class="w3-button" type="submit" value="${country.id}">Delete</button>
</div>
</@tags.form>