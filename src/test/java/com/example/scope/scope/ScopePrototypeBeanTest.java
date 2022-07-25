package com.example.scope.scope;

import com.example.scope.ScopePrototypeBean;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ScopePrototypeBeanTest {

    @Test
    @DisplayName("[Scope가 Prototype인 경우] 스프링 빈에서 가져올 때마다 새로운 객체 생성된다.")
    void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopePrototypeBean.class);
        ScopePrototypeBean bean1 = context.getBean(ScopePrototypeBean.class);
        ScopePrototypeBean bean2 = context.getBean(ScopePrototypeBean.class);
        assertThat(bean1).isNotSameAs(bean2);
        context.close();
    }
}