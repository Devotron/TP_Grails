<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'POI.label', default: 'POI')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <g:render template="../navbar" model="[navbar: myNavBar]" />
        <a href="#list-POI" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <sec:ifAnyGranted roles="ROLE_ADMIN, ROLE_MODERATEUR">
                    <li><g:link class="create" action="create"><g:message code="default.new.label.poi" args="[entityName]" /></g:link></li>
                    <li><g:link class="create" action="create" controller="geoLoc"><g:message code="default.new.label.geoloc"></g:message></g:link></li>
                </sec:ifAnyGranted>
            </ul>
        </div>
        <div id="list-POI" class="content scaffold-list" role="main">
            <h1>Listing des points d'interêts</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:render template="table" model="[table: table]"/>
            <div class="pagination">
                <g:paginate total="${POICount ?: 0}" />
            </div>
        </div>
    </body>
</html>