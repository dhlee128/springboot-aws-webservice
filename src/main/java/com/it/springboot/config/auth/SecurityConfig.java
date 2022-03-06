package com.it.springboot.config.auth;

import com.it.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //SpringSecurity 설정을 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .headers().frameOptions().disable() //h2-console 화면을 사용하기 위해 옵션들을 disable 처리
            .and()
            .authorizeRequests() //URL 별 권한 관리 설정
            .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
            .antMatchers("/api/v1/**").hasRole(Role.USER.name())
            .anyRequest().authenticated() //설정된 값들 이외 나머지 URL 에 대하여 인증이 필요
            .and()
            .logout().logoutSuccessUrl("/") //로그아웃 성공시 루트 주소로 이동
            .and()
            .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService); //oauth2Login 이 성공하면 해당 서비스에서 설정을 처리
    }
}
