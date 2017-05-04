<#assign tags=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "head.ftl">

<fieldset>
    <div>
        Flights for ${country_name}: <hr>
    </div>
<@tags.form action="/country=${country_id}/flight-list" method="post" modelAttribute="points">
    <div class="w3-container">
        <@tags.label path="departure-point">Departure:</@tags.label>
        <@tags.input path="departure-point" type="text"/>
        <@tags.errors path="departure-point"/>

        <@tags.label path="destination-point">Destination:</@tags.label>
        <@tags.input path="destination-point" type="text"/>
        <@tags.errors path="destination-point"/>

        <div>
            <input type="submit" class="w3-button" value="Search">
        </div>
    </div>
</@tags.form>
    <div>
        <a href="/admin/country=${country_id}/new-flight"> Add flight </a>
    </div>
</fieldset>