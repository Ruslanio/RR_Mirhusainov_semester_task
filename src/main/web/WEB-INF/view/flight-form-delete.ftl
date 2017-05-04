<#assign tags=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "head.ftl">

<@tags.form action="/admin/country=${country_id}/delete-flight" method="post">
<div>
    <button name="deleted_id" class="w3-button" type="submit" value="${flight.flightId}">Delete</button>
</div>
</@tags.form>