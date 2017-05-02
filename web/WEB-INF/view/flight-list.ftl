<#include "head.ftl">
<#include "flights-schedule.ftl">

<div>
    <#list flights as flight>
        <div>
            <div>
                departure point: ${flight.departurePoint} destination point: ${flight.destinationPoint}
            </div>
            <p><a href="/country=${country_id}/flight-schedule/flight-list/flight=${flight.flightId}">more info...</a> </p>
        </div>
        <#else >
        no flights for this departure and destination points
    </#list>
</div>