package com.example.scope.controller;

import com.example.scope.ScopeRequestBean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ScopeController {

    private final ScopeRequestBean scopeRequestBean;

    @GetMapping("/api/call")
    public ResponseEntity<Void> requestCall(HttpServletRequest request) {
        String requestUrl = request.getRequestURL().toString();
        log.info("요청 URL : {}", requestUrl);

        scopeRequestBean.setRequtestURL(requestUrl);

        log.info(scopeRequestBean.getRequtestURL());
        return ResponseEntity.ok().build();
    }
}
