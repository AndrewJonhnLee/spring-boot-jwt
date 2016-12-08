
package com.demo.conf;

import com.demo.jwt.JsonWebTokenSecurityConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Created by YangFan on 2016/11/28 上午10:30.
 * <p/>
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends JsonWebTokenSecurityConfig {
    @Override
    protected void setupAuthorization(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // allow anonymous access to /user/login endpoint
                .antMatchers("/user/login").permitAll()
                .antMatchers("/swagger/**").permitAll()


                // authenticate all other requests
                .anyRequest().authenticated();
    }
}
