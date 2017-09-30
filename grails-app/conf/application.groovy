

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.userLookup.userDomainClassName = 'fr.mbds.tpgrails.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'fr.mbds.tpgrails.UserRole'
grails.plugin.springsecurity.authority.className = 'fr.mbds.tpgrails.Role'

grails.plugin.springsecurity.securityConfigType = grails.plugin.springsecurity.SecurityConfigType.InterceptUrlMap

grails.plugin.springsecurity.interceptUrlMap = [
		[pattern: '/geoLoc/**',   access: ['ROLE_ADMIN', 'ROLE_MODERATEUR']],
		[pattern: '/illustration/**',   access: ['ROLE_ADMIN', 'ROLE_MODERATEUR']],
		[pattern: '/grPOI/index/**',   access: ['isFullyAuthenticated()']],
		[pattern: '/grPOI/show/**',   access: ['isFullyAuthenticated()']],
		[pattern: '/grPOI/**',   access: ['ROLE_ADMIN', 'ROLE_MODERATEUR']],
		[pattern: '/poi/index/**',   access: ['isFullyAuthenticated()']],
		[pattern: '/poi/show/**',   access: ['isFullyAuthenticated()']],
		[pattern: '/poi/**',   access: ['ROLE_ADMIN', 'ROLE_MODERATEUR']],
		[pattern: '/user/profil/**',   access: ['isFullyAuthenticated()']],
		[pattern: '/user/**',   access: ['ROLE_ADMIN', 'ROLE_MODERATEUR']],
		[pattern: '/index/**',          access: ['isFullyAuthenticated()']],
		[pattern: '/index.gsp',      access: ['isFullyAuthenticated()']],
		[pattern: '/login/auth',     access: ['permitAll']],
		[pattern: '/dbconsole/**',          access: ['permitAll']],
		[pattern: '/shutdown',       access: ['permitAll']],
		[pattern: '/assets/**',      access: ['permitAll']],
		[pattern: '/**/js/**',       access: ['permitAll']],
		[pattern: '/**/css/**',      access: ['permitAll']],
		[pattern: '/**/images/**',   access: ['permitAll']],
		[pattern: '/**/favicon.ico', access: ['permitAll']],
		[pattern: '/error',          access: ['permitAll']],
		[pattern: '/**',               access: ['isFullyAuthenticated()']],
]

/**
 * ROLES : ['ROLE_ADMIN', 'ROLE_MODERATEUR', 'ROLE_UTILISATEUR']
 *
 * GEOLOC : ['ROLE_ADMIN', 'ROLE_MODERATEUR']
 * /geoLoc/**
 * /geoLoc/index/
 * /geoLoc/show/
 * /geoLoc/edit/
 * /geoLoc/delete/
 * /geoLoc/update/
 * /geoLoc/save/
 * --------------------
 * Illustration : ['ROLE_ADMIN', 'ROLE_MODERATEUR']
 * /illustration/**
 * /illustration/index/
 * /illustration/show/
 * /illustration/edit/
 * /illustration/delete/
 * /illustration/update/
 * /illustration/save/
 * ---------------------
 * POI :
 * /poi/** ['isFullyAuthenticated()']
 * /poi/index/ ['ROLE_ADMIN', 'ROLE_MODERATEUR', 'ROLE_UTILISATEUR']
 * /poi/show/  ['ROLE_ADMIN', 'ROLE_MODERATEUR', 'ROLE_UTILISATEUR']
 * /poi/edit/  ['ROLE_ADMIN', 'ROLE_MODERATEUR']
 * /poi/delete/ ['ROLE_ADMIN', 'ROLE_MODERATEUR']
 * /poi/update/ ['ROLE_ADMIN', 'ROLE_MODERATEUR']
 * /poi/save/ ['ROLE_ADMIN', 'ROLE_MODERATEUR']
 * ---------------------
 * GRPOI :
 * /grPOI/** ['isFullyAuthenticated()']
 * /grPOI/index/ ['ROLE_ADMIN', 'ROLE_MODERATEUR', 'ROLE_UTILISATEUR']
 * /grPOI/show/ ['ROLE_ADMIN', 'ROLE_MODERATEUR', 'ROLE_UTILISATEUR']
 * /grPOI/edit/ ['ROLE_ADMIN', 'ROLE_MODERATEUR']
 * /grPOI/delete/ ['ROLE_ADMIN', 'ROLE_MODERATEUR']
 * /grPOI/update/ ['ROLE_ADMIN', 'ROLE_MODERATEUR']
 * /grPOI/save/ ['ROLE_ADMIN', 'ROLE_MODERATEUR']
 * ---------------------
 * USER :
 * /user/** ['isFullyAuthenticated()']
 * /user/index/ ['ROLE_ADMIN', 'ROLE_MODERATEUR']
 * /user/show/  ['ROLE_ADMIN', 'ROLE_MODERATEUR']
 * /user/edit/  ['ROLE_ADMIN', 'ROLE_MODERATEUR']
 * /user/delete/ ['ROLE_ADMIN', 'ROLE_MODERATEUR']
 * /user/update/ ['ROLE_ADMIN', 'ROLE_MODERATEUR']
 * /user/save/   ['ROLE_ADMIN', 'ROLE_MODERATEUR']
 * /user/profil/  ['isFullyAuthenticated()']
**/

// @secured = securisation d'un(e) methode/controleur, getPrincipale() => recuperation du client actuellement connecté
grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

environments {
	development {
		uploadFolder = "/srv/http/uploads/"
	}
	test {
		uploadFolder = "/srv/http/uploads/"
	}
	production {
		uploadFolder = "/srv/http/uploads/"
	}
}