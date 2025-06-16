package com.app.hospital.Config;

import com.app.hospital.Config.JwtAuthenticationFilter;
import com.app.hospital.Services.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserDetailsServiceImpl userDetailsService;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter,
            UserDetailsServiceImpl userDetailsService) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }C:\Users\amulya shetty\SpringApplication\hospital>mvn spring-boot:run
Picked up JAVA_TOOL_OPTIONS: -Dstdout.encoding=UTF-8 -Dstderr.encoding=UTF-8
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------------< com.app:hospital >--------------------------
[INFO] Building hospital 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] >>> spring-boot:3.5.0:run (default-cli) > test-compile @ hospital >>>
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ hospital ---
[INFO] Copying 1 resource from src\main\resources to target\classes
[INFO] Copying 0 resource from src\main\resources to target\classes
[INFO]
[INFO] --- compiler:3.14.0:compile (default-compile) @ hospital ---
[INFO] Recompiling the module because of added or removed source files.
[INFO] Compiling 34 source files with javac [debug parameters release 17] to target\classes
[WARNING] /C:/Users/amulya shetty/SpringApplication/hospital/src/main/java/com/app/hospital/Config/SecurityConfig.java:[50,13] csrf() in org.springframework.security.config.annotation.web.builders.HttpSecurity has been deprecated and marked for removal
[WARNING] /C:/Users/amulya shetty/SpringApplication/hospital/src/main/java/com/app/hospital/Config/SecurityConfig.java:[59,17] sessionManagement() in org.springframework.security.config.annotation.web.builders.HttpSecurity has been deprecated and marked for removal
[WARNING] /C:/Users/amulya shetty/SpringApplication/hospital/src/main/java/com/app/hospital/Config/SecurityConfig.java:[61,17] and() in org.springframework.security.config.annotation.SecurityConfigurerAdapter has been deprecated and marked for removal
[INFO] /C:/Users/amulya shetty/SpringApplication/hospital/src/main/java/com/app/hospital/Config/SecurityConfig.java: C:\Users\amulya shetty\SpringApplication\hospital\src\main\java\com\app\hospital\Config\SecurityConfig.java uses or overrides a deprecated API.
[INFO] /C:/Users/amulya shetty/SpringApplication/hospital/src/main/java/com/app/hospital/Config/SecurityConfig.java: Recompile with -Xlint:deprecation for details.
[INFO]
[INFO] --- resources:3.3.1:testResources (default-testResources) @ hospital ---
[INFO] skip non existing resourceDirectory C:\Users\amulya shetty\SpringApplication\hospital\src\test\resources
[INFO]
[INFO] --- compiler:3.14.0:testCompile (default-testCompile) @ hospital ---
[INFO] Recompiling the module because of changed dependency.
[INFO] Compiling 1 source file with javac [debug parameters release 17] to target\test-classes
[INFO] 
[INFO] <<< spring-boot:3.5.0:run (default-cli) < test-compile @ hospital <<<
[INFO]
[INFO]
[INFO] --- spring-boot:3.5.0:run (default-cli) @ hospital ---
[INFO] Attaching agents: []
Picked up JAVA_TOOL_OPTIONS: -Dstdout.encoding=UTF-8 -Dstderr.encoding=UTF-8

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.5.0)

2025-06-16T14:09:18.860+05:30  INFO 20200 --- [hospital] [           main] com.app.hospital.HospitalApplication     : Starting HospitalApplication using Java 21.0.6 with PID 20200 (C:\Users\amulya shetty\SpringApplication\hospital\target\classes started by amulya shetty in C:\Users\amulya shetty\SpringApplication\hospital)
2025-06-16T14:09:18.865+05:30  INFO 20200 --- [hospital] [           main] com.app.hospital.HospitalApplication     : No active profile set, falling back to 1 default profile: "default"
2025-06-16T14:09:20.427+05:30  WARN 20200 --- [hospital] [           main] ConfigServletWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.support.BeanDefinitionOverrideException: Invalid bean definition with name 'passwordEncoder' defined in class path resource [com/app/hospital/Config/SecurityConfig.class]: Cannot register bean definition [Root bean: class=null; scope=; abstract=false; lazyInit=null; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; fallback=false; factoryBeanName=securityConfig; factoryMethodName=passwordEncoder; initMethodNames=null; destroyMethodNames=[(inferred)]; defined in class path resource [com/app/hospital/Config/SecurityConfig.class]] for bean 'passwordEncoder' since there is already [Root bean: class=null; scope=; abstract=false; lazyInit=null; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; fallback=false; factoryBeanName=passwordConfig; factoryMethodName=passwordEncoder; initMethodNames=null; destroyMethodNames=[(inferred)]; defined in class path resource [com/app/hospital/Config/PasswordConfig.class]] bound.
2025-06-16T14:09:20.445+05:30  INFO 20200 --- [hospital] [           main] .s.b.a.l.ConditionEvaluationReportLogger : 

Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2025-06-16T14:09:20.493+05:30 ERROR 20200 --- [hospital] [           main] o.s.b.d.LoggingFailureAnalysisReporter   : 

***************************
APPLICATION FAILED TO START
***************************

Description:

The bean 'passwordEncoder', defined in class path resource [com/app/hospital/Config/SecurityConfig.class], could not be registered. A bean with that name has already been defined in class path resource [com/app/hospital/Config/PasswordConfig.class] and overriding is disabled.

Action:

Consider renaming one of the beans or enabling overriding by setting spring.main.allow-bean-definition-overriding=true

[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  16.598 s
[INFO] Finished at: 2025-06-16T14:09:20+05:30
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.springframework.boot:spring-boot-maven-plugin:3.5.0:run (default-cli) on project hospital: Process terminated with exit code: 1 -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api/auth/**",
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html")
                        .permitAll()
                        .anyRequest().authenticated())
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
