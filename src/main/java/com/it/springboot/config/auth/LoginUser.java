package com.it.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //메소드의 파라미터로 선언된 객체에 사용
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser { //어노테이션 클래스로 지정
}
