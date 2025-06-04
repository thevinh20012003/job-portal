package com.vinh20code.jobportal.config;

import com.vinh20code.jobportal.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    private final CustomUserDetailService customUserDetailService;
    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    private final String[] publicUrl = {"/",
            "/global-search/**",
            "/register",
            "/register/**",
            "/webjars/**",
            "/resources/**",
            "/assets/**",
            "/css/**",
            "/summernote/**",
            "/js/**",
            "/*.css",
            "/*.js",
            "/*.js.map",
            "/fonts**", "/favicon.ico", "/resources/**", "/error"};
    @Autowired
    public WebSecurityConfig(CustomUserDetailService customUserDetailService,
                             CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) {
        this.customUserDetailService = customUserDetailService;
        this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
    }

    // 1
    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authenticationProvider(authenticationProvider());

        http.authorizeHttpRequests(auth ->{
            auth.requestMatchers(publicUrl).permitAll();
            auth.anyRequest().authenticated();
        });
        http.formLogin(form -> form.loginPage("/login").permitAll()
                    .successHandler(customAuthenticationSuccessHandler))
            .logout(logout -> {
                logout.logoutUrl("/logout");
                logout.logoutSuccessUrl("/");
            }).cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable());
        return http.build();
    }

    // ROLE: XÁC THỰC THÔNG TIN USER
    @Bean
    protected AuthenticationProvider authenticationProvider() {
        // DaoAuthenticationProvider là một AuthenticationProvider được sử dụng để xác thực người dùng dựa trên thông tin từ cơ sở dữ liệu.
        // Nó sử dụng UserDetailsService để lấy thông tin người dùng và PasswordEncoder để mã hóa mật khẩu.
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(customUserDetailService);
        return authenticationProvider;
    }
    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    1. thêm depedencies vào maven
//    2. Cấu hình Spring security:
//            Annotate class bằng @Configuration.
//            Tạo phương thức securityFilterChain (annotate với @Bean) để Spring Security biết đến.
//            Tạo mảng String chứa các public URL (ví dụ: /register, /css/**, /js/**) – những URL này không yêu cầu đăng nhập.
//            Trong cấu hình httpSecurity:
//                Cho phép tất cả mọi người (permitAll()) truy cập các URL public.
//                Các request khác thì yêu cầu đăng nhập (authenticated()).
//    Bước 3: Custom User Authentication & Authorization
//            Tạo AuthenticationProvider:
//            Thiết lập Password Encoder:
// P          Tạo Custom User Details Service:
//            Tạo Custom User Details:
//            Tích hợp CustomUserDetailsService vào WebSecurityConfig:

}
