package com.example.scope.scope;

import com.example.scope.MixScopeBean;
import com.example.scope.ScopePrototypeBean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class MixScopeBeanTest {


    @Test
    @DisplayName("Singletom bean에 주입 한 경우에는 Prototype을 사용해도 주입할때마다 새로운 객체를 만들지 않아 값이 numberCount가 계속 증가한다.")
    void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MixScopeBean.class, ScopePrototypeBean.class);
        MixScopeBean bean1 = context.getBean(MixScopeBean.class);
        bean1.addCountNumber(1);
        int countNumber = bean1.getScopePrototypeBeanCountNumber();

        MixScopeBean bean2 = context.getBean(MixScopeBean.class);
        bean2.addCountNumber(1);
        int compareCountNumber = bean2.getScopePrototypeBeanCountNumber();

        assertThat(bean1).isSameAs(bean2);
        assertThat(countNumber).isNotEqualTo(compareCountNumber);
    }
}