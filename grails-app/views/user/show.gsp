<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title>Détail utilisateur</title>
    </head>
    <body>
    <g:render template="../navbar" model="[navbar: myNavBar]" />
        <a href="#show-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                </sec:ifAnyGranted>
            </ul>
        </div>
        <div id="show-user" class="content scaffold-show" role="main">
            <h1>Détail utilisateur</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>

            <f:with bean="user">
                <f:field property="nom">
                    <f:display property="nom" ></f:display>
                </f:field>
                <f:field property="prenom">
                    <f:display property="prenom"></f:display>
                </f:field>
                <f:field property="username" label="Login">
                    <f:display property="username" ></f:display>
                </f:field>
                <f:field property="password" label="Mot de passe" >
                    <f:display property="password"></f:display>
                </f:field>
                <f:field property="accountExpired" label="Compte expiré">
                    <g:checkBox name="accountExpired" checked="${user.accountExpired}" disabled=""></g:checkBox>
                </f:field>
                <f:field property="accountLocked" label="Compte cloturé" >
                    <g:checkBox name="accountLocked" checked="${user.accountLocked}" disabled=""></g:checkBox>
                </f:field>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                    <f:field property="passwordExpired" label="Mot de passe expiré" >
                        <g:checkBox name="passwordExpired" checked="${user.passwordExpired}" disabled=""></g:checkBox>
                    </f:field>
                    <f:field property="enabled" label="Compte activé" >
                        <g:checkBox name="enabled" checked="${user.enabled}" disabled=""></g:checkBox>
                    </f:field>
                </sec:ifAnyGranted>

            </f:with>

                <g:form resource="${this.user}" method="DELETE">
                    <fieldset class="buttons">
                        <g:link class="edit" mapping="userEdit" resource="${this.user}"><g:message code="default.button.edit.label" default="Edit" ></g:message></g:link>
                        <sec:ifAnyGranted roles="ROLE_ADMIN">
                            <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                        </sec:ifAnyGranted>
                    </fieldset>
                </g:form>

        </div>
    </body>
</html>
