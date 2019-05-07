package nl.yacht.mostdevapi.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${nl.yacht.auth.hashedAccess}")
    private String hashedAccess;

    @Value("${nl.yacht.auth.user}")
    private String username;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors();
        http
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/projects")
            .authenticated()
            .antMatchers(HttpMethod.POST, "/projects/")
            .authenticated()
            .antMatchers(HttpMethod.DELETE, "/projects")
            .authenticated()
            .antMatchers(HttpMethod.DELETE, "/projects/")
            .authenticated()
            .and()
            .httpBasic();
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser(username)
            .password(hashedAccess)
            .roles("USER");
    }

    @Bean
    public FilterRegistrationBean corsFilterRegistrationBean() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        corsConfiguration.setAllowedMethods(Arrays.asList(
            HttpMethod.GET.name(),
            HttpMethod.POST.name(),
            HttpMethod.DELETE.name()
        ));
        source.registerCorsConfiguration("/**", corsConfiguration);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
