<content tag="nav" id="${navbar}">
    <ul>
        <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName }}">
            <g:if test="${c.getStaticPropertyValue('linkMe', Boolean)}">
                <li class="controller">
                    <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
                </li>
            </g:if>
        </g:each>
    </ul>
</content>