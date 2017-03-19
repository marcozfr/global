package com.labs.catalog.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@ImportResource("classpath:root-web-security-context.xml")
public class RootWebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    DataSource dataSource;
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//            .dataSource(dataSource)
//            .usersByUsernameQuery("select username, password, 1 from user where username = ?")
//            .authoritiesByUsernameQuery("select u.username, p.profileName from global.user u , global.user_profile up, global.profile p where u.userid = up.user_id and up.profile_id = p.profileid and u.username = ?")
//            .passwordEncoder(passwordEncoder());
//    }
    
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("user").password("password").roles("USER").build());
//        return manager;
//    }
    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().
//            anyRequest().authenticated().
//                and().
//            formLogin().
//                and().
//            httpBasic().
//                and().
//            requiresChannel().
//                anyRequest().
//                requiresInsecure();
//            
//            
//        
////        http.csrf().disable();
//    }

}
