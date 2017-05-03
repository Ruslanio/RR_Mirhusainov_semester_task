<#assign tags=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "head.ftl">
<div>
<@tags.form action = "/admin/country=${country_id}/new-flight" method = "post" modelAttribute = "new_flight">
    <fieldset>
        <div>
            <@tags.label path ="number">Number: </@tags.label>
            <@tags.input path="number" type="text"/>
            <@tags.errors path="number"/>
            <hr>


            <@tags.label path ="planeType">Plane Type: </@tags.label>
            <@tags.input path="planeType" type="text"/>
            <@tags.errors path="planeType"/>
            <hr>

            <@tags.label path ="depPoint">Departure point: </@tags.label>
            <@tags.input path="depPoint" type="text"/>
            <@tags.errors path="depPoint"/>
            <hr>

            <@tags.label path ="destPoint">Destination point: </@tags.label>
            <@tags.input path="destPoint" type="text"/>
            <@tags.errors path="destPoint"/>
            <hr>


            <input type="submit" value="Add">
        </div>
    </fieldset>
</@tags.form>
</div>