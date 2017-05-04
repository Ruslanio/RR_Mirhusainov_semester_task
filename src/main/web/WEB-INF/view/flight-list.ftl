<#include "flights-schedule.ftl">

<div>
    <#list flights as flight>
        <div>
            <div class="w3-card">
                departure point: ${flight.departurePoint} destination point: ${flight.destinationPoint}
            </div>
            <#if admin>
                <#include "flight-form-delete.ftl">
            </#if>
            <p><a href="/country=${country_id}/flight-schedule/flight-list/flight=${flight.flightId}" class="w3-button">more info...</a> </p>
        </div>
        <#else >
        No flights for this departure and destination points
    </#list>
</div>