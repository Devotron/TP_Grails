import fr.mbds.tpgrails.UserPasswordEncoderListener
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener, ref('hibernateDatastore'))

    localeResolver(SessionLocaleResolver) {
        defaultLocale= new Locale('fr');
    }
}
