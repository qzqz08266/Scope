package com.example.scope;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
public class ScopeSingletonBean {

    public ScopeSingletonBean() {
        log.info("기본생성자 호출");
    }

    @PostConstruct
    public void init() {
        log.info("ScopeSingletonBean PostConstruct 호출 : {}", this);
    }

    @PreDestroy
    public void end() {
        log.info("ScopeSingletonBean PreDestroy 호출 : {}", this);
    }
}
