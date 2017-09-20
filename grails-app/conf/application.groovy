

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'fr.mbds.tpgrails.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'fr.mbds.tpgrails.UserRole'
grails.plugin.springsecurity.authority.className = 'fr.mbds.tpgrails.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/login/auth',     access: ['permitAll']],
	[pattern: '/geoLoc/**',   access: ['isFullyAuthenticated()']],
	[pattern: '/grPOI/**',   access: ['isFullyAuthenticated()']],
	[pattern: '/illustration/**',   access: ['ROLE_ADMIN']],
	[pattern: '/poi/**',   access: ['isFullyAuthenticated()']],
	[pattern: '/user/**',   access: ['ROLE_ADMIN', 'ROLE_MODO']],
	[pattern: '/illustration/**',   access: ['isFullyAuthenticated()']],
	[pattern: '/index',          access: ['isFullyAuthenticated()']],
	[pattern: '/dbconsole/**',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['isFullyAuthenticated()']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]
// @secured = securisation d'un(e) methode/controleur, getPrincipale() => recuperation du client actuellement connecté
grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

