package com.nosbielc.music.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.Filter;

@SpringBootApplication
@EnableFeignClients
@EnableOAuth2Client
@EnableAuthorizationServer
public class MusicMatchApplication extends WebSecurityConfigurerAdapter {

    @Autowired
    OAuth2ClientContext oauth2ClientContext;

    public static void main(String[] args) {
        SpringApplication.run(MusicMatchApplication.class, args);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.antMatcher("/**").authorizeRequests().antMatchers( "/**").permitAll().anyRequest()
                .authenticated().and().exceptionHandling()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/")).and().logout()
                .logoutSuccessUrl("/").permitAll().and().csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class);

//        http.authorizeRequests().antMatchers("/**").permitAll().and().csrf().disable()
//                .addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class);
//
//        http.headers().frameOptions().disable();
        // @formatter:on
    }

    @Bean
    public FilterRegistrationBean<OAuth2ClientContextFilter> oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
        FilterRegistrationBean<OAuth2ClientContextFilter> registration = new FilterRegistrationBean<OAuth2ClientContextFilter>();
        registration.setFilter(filter);
        registration.setOrder(-100);
        return registration;
    }

    private Filter ssoFilter() {
        OAuth2ClientAuthenticationProcessingFilter spotifyFilter = new OAuth2ClientAuthenticationProcessingFilter(
                "/api/v1/musicMatch");
        OAuth2RestTemplate spotifyTemplate = new OAuth2RestTemplate(spotify(), oauth2ClientContext);
        spotifyFilter.setRestTemplate(spotifyTemplate);
        UserInfoTokenServices tokenServices = new UserInfoTokenServices(spotifyResource().getUserInfoUri(),
                spotify().getClientId());
        tokenServices.setRestTemplate(spotifyTemplate);
        spotifyFilter.setTokenServices(tokenServices);
        return spotifyFilter;
    }

    @Bean
    @ConfigurationProperties("spotify.client")
    public AuthorizationCodeResourceDetails spotify() {
        return new AuthorizationCodeResourceDetails();
    }

    @Bean
    @ConfigurationProperties("spotify.resource")
    public ResourceServerProperties spotifyResource() {
        return new ResourceServerProperties();
    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

}
