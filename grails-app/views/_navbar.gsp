<content tag="nav" id="${navbar}">
    <ul>
        %{--<li>Bonjour <sec:loggedInUserInfo field='username'/></li>--}%
        <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.getStaticPropertyValue('joliNom', String)}}">
            <g:if test="${c.getStaticPropertyValue('linkMe', Boolean)}">
                <li class="controller">
                    <g:link controller="${c.logicalPropertyName}">${c.getStaticPropertyValue('joliNom', String)}</g:link>
                </li>
            </g:if>
        </g:each>
        <li class="controller"><g:link controller='logout'><strong>Logout</strong></g:link></li>
    </ul>
</content>