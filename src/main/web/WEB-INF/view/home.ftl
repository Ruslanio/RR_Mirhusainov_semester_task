<#include "head.ftl">
<div>
    <h3>
        Available counties:
    </h3>
<#list countries as country>
    <div class = "">
        <p><a href = "/country=${country.countryId}">${country.name}</a></p>
        <#if admin>
            <#include "country-form-delete.ftl">
        </#if>
    </div>
<#else>
    <p>
        Sorry, there are no available countries yet.
    </p>
</#list>
    <#if admin>
        <a href="/admin/new-country" class="w3-button"> Add country </a>
    </#if>
</div>

