<#assign tags=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "head.ftl">
<div>
    <h4>Enter country name: </h4>
    <@tags.form action = "/admin/new-country" method = "post" modelAttribute = "new_country">
         <fieldset>
             <div>
                 <@tags.input path="name" type="text"/>
                 <@tags.errors path="name"/>

                 <input type="submit" value="Add">
             </div>
         </fieldset>
    </@tags.form>
</div>