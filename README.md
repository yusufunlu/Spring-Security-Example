If you don't configure WebSecurityConfigurerAdapter default security filter chaing will be used

Will secure any request with 
[org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@4fa1da, 
org.springframework.security.web.context.SecurityContextPersistenceFilter@1f0c4f2, 
org.springframework.security.web.header.HeaderWriterFilter@1f23f2, 
org.springframework.security.web.csrf.CsrfFilter@143e593, 
org.springframework.security.web.authentication.logout.LogoutFilter@dd3c23, 
org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter@c03a37, 
org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter@fabd0f, 
org.springframework.security.web.authentication.ui.DefaultLogoutPageGeneratingFilter@8cd519, 
org.springframework.security.web.authentication.www.BasicAuthenticationFilter@19ccca5, 
org.springframework.security.web.savedrequest.RequestCacheAwareFilter@93d508, 
org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@1214b94, 
org.springframework.security.web.authentication.AnonymousAuthenticationFilter@192c349, 
org.springframework.security.web.session.SessionManagementFilter@d79cba, 
org.springframework.security.web.access.ExceptionTranslationFilter@1443fae, 
org.springframework.security.web.access.intercept.FilterSecurityInterceptor@108f438]

DefaultLoginPageGeneratingFilter provide login page which is located in /login. 
It doesn't require thmeleaf or sth else to show this page

If you configure it with just this code 
``    
@Override
protected void configure(HttpSecurity http) throws Exception {
http
.authorizeRequests()
.anyRequest().authenticated()
.and()
.httpBasic();
}
``
Following filters will not be used and default login page will disappear
org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter@c03a37,
org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter@fabd0f,
org.springframework.security.web.authentication.ui.DefaultLogoutPageGeneratingFilter@8cd519,
Others are still in use
Will secure any request with [org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@173200b, 
org.springframework.security.web.context.SecurityContextPersistenceFilter@1f6e406, 
org.springframework.security.web.header.HeaderWriterFilter@13deac2, 
org.springframework.security.web.csrf.CsrfFilter@16e8f77, 
org.springframework.security.web.authentication.logout.LogoutFilter@3dd56b, 
org.springframework.security.web.authentication.www.BasicAuthenticationFilter@13f3e9, 
org.springframework.security.web.savedrequest.RequestCacheAwareFilter@6f3bae, 
org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@1ff1390, 
org.springframework.security.web.authentication.AnonymousAuthenticationFilter@1c5e994, 
org.springframework.security.web.session.SessionManagementFilter@97551f, 
org.springframework.security.web.access.ExceptionTranslationFilter@1d7b27f, 
org.springframework.security.web.access.intercept.FilterSecurityInterceptor@5ac855]

If you configure AuthenticationManagerBuilder auto UUID to console will be stopped
If you use NoOpPasswordEncoder basic auth still works(no page, just popup)
If you use BCryptPasswordEncoder basic auth doesn't works I don't why(no page, just popup)
``
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
auth.
inMemoryAuthentication()
.passwordEncoder(passwordEncoder())
.withUser("yusufadmin").password("admin123").roles("ADMIN")
.and()
.withUser("yusufuser").password("user123").roles("USER");
}
``

When using TLS headers are encoded
Form based auth provide remember me option
