package com.project.calendar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    //시큐리티 설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //시큐리티 빌더
        http.cors() //크로스 오리진 정책
                .and()
                .csrf() //csrf 정책
                .disable() //스프링 시큐리티에서 제공하는 검증기능 사용안함.
                .httpBasic().disable() // 기본 시큐리티 인증 해제, 토큰 인증 쓸꺼니까
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //세션 인증 안함
                .and()
                .authorizeHttpRequests().requestMatchers("/**").permitAll()
                .anyRequest().authenticated(); //그 외의 경로는 모두 인증을 거쳐야함.

        return http.build();
    }


}
