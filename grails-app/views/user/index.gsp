<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    <g:render template="../navbar" model="[navbar: myNavBar]" />
        <a href="#list-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                <li><g:link class="create" action="create"><g:message code="default.new.label.user" args="[entityName]" /></g:link></li>
                </sec:ifAnyGranted>
            </ul>
        </div>
        <div id="list-user" class="content scaffold-list" role="main">
            <h1>Listing utilisateur</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:if test="${flash.error}">
                <div class="errors" role="status">${flash.error}</div>
            </g:if>


            <f:table collection="${userList}" properties="['username', 'nom', 'prenom', 'accountLocked', 'accountExpired']" />

            <div class="pagination">
                <g:paginate total="${userCount ?: 0}" />
            </div>
        </div>
    </body>
</html>