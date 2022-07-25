package com.example.scope;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Slf4j
@RequiredArgsConstructor
@Component
public class MixScopeBean {

    private final ScopePrototypeBean scopePrototypeBean;

    @PostConstruct
    public void init() {
        log.info("MixScopeBean PostConstruct 호출");
    }

    public int getScopePrototypeBeanCountNumber() {
        return scopePrototypeBean.getCountNumber();
    }

    public void addCountNumber(int number) {
        scopePrototypeBean.addCountNumber(number);
    }

    @PreDestroy
    public void end() {
        log.info("MixScopeBean PreDestroy 호출");
    }
}
