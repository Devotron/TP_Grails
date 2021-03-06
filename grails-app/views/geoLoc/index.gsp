<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'geoLoc.label', default: 'GeoLoc')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-geoLoc" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label.geoLoc"/></g:link></li>
            </ul>
        </div>
        <div id="list-geoLoc" class="content scaffold-list" role="main">
            <h1>Listing des localisations</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${geoLocList}" properties="['id', 'longitude', 'latitude']" />

            <div class="pagination">
                <g:paginate total="${geoLocCount ?: 0}" />
            </div>
        </div>
    </body>
</html>