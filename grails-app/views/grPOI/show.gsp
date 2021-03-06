<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'grPOI.label', default: 'GrPOI')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <g:render template="../navbar" model="[navbar: myNavBar]" />
        <a href="#show-grPOI" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label.grpois"/></g:link></li>
                <sec:ifAnyGranted roles="ROLE_ADMIN, ROLE_MODERATEUR">
                <li><g:link class="create" action="create"><g:message code="default.new.label.grpois"/></g:link></li>
                </sec:ifAnyGranted>
            </ul>
        </div>
        <div id="show-grPOI" class="content scaffold-show" role="main">
            <h1>Détail groupe de point d'interêt</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="grPOI" />
            <g:render template="illustrations" />
            <sec:ifAnyGranted roles="ROLE_ADMIN, ROLE_MODERATEUR">
            <g:form resource="${this.grPOI}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.grPOI}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
            </sec:ifAnyGranted>
        </div>
    </body>
</html>
