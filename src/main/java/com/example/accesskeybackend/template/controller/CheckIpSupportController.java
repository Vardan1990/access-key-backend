package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.template.service.CheckIpSupportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.UnknownHostException;

@Slf4j
@RestController
@RequestMapping("/api/web")
@RequiredArgsConstructor
public class CheckIpSupportController {

    private final CheckIpSupportService checkIpSupportService;

    @PostMapping(path = "/checkIpv6Support")
    public ResponseEntity<?> checkForSupport(@RequestParam(name = "uri", required = false) URI siteUri) throws UnknownHostException {
        log.info("check ipv6 support by uri {}", siteUri);
        if (siteUri == null ) {
            return ResponseEntity.badRequest().body("null parameters");
        }
        boolean success = checkIpSupportService.checkIpForSupport(siteUri);
        if (success) {
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(true);
        }
        return ResponseEntity.ok(false);
    }
}
