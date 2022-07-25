package com.example.scope.scope;

import com.example.scope.ScopeSingletonBean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class ScopeSingletonBeanTest {

    @Test
    @DisplayName("[Scope가 Singleton인 경우] 스프링컨텍스트에서 관리하는 빈에서 가져온 빈은 동일한 객체이다.")
    void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeSingletonBean.class);
        ScopeSingletonBean bean1 = context.getBean(ScopeSingletonBean.class);
        ScopeSingletonBean bean2 = context.getBean(ScopeSingletonBean.class);
        assertThat(bean1).isSameAs(bean2);

        context.close();
    }
}