package com.example.scope;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Getter
@Setter
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class ScopeRequestBean {

    String requtestURL;

    @PostConstruct
    public void init() {
        log.info("ScopeRequestBean PostConstruct 호출 : {}", this);
    }

    @PreDestroy
    public void end() {
        log.info("ScopeRequestBean PreDestroy 호출 : {}", this);
    }
}
