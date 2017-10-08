<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'POI.label', default: 'POI')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <g:render template="../navbar" model="[navbar: myNavBar]" />
        <a href="#show-POI" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label.poi"/></g:link></li>
                <sec:ifAnyGranted roles="ROLE_ADMIN, ROLE_MODERATEUR">
                <li><g:link class="create" action="create"><g:message code="default.new.label.poi"/></g:link></li>
                </sec:ifAnyGranted>
            </ul>
        </div>
        <div id="show-POI" class="content scaffold-show" role="main">
            <h1>Détail du point d'interêt</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>

            <g:render template="showChampsPOI" model="[champs: champs]" />
            <g:render template="illustrations" model="[files: files]" />

            <div id="map" style="height: 400px; width: 100%; display:inline-block; vertical-align:middle;"></div>

            <script async defer
                    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC5g3lROuua5hCO4WwJSwDXEPqaogMawVU&callback=initMap">
            </script>
            <asset:javascript src="googlemap.js" />


            <sec:ifAnyGranted roles="ROLE_ADMIN, ROLE_MODERATEUR">
            <g:form resource="${this.POI}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.POI}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
            </sec:ifAnyGranted>
        </div>
    </body>
</html>
