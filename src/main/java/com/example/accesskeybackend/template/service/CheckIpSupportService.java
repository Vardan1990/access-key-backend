package com.example.accesskeybackend.template.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;

@Slf4j
@Service
@RequiredArgsConstructor
public class CheckIpSupportService {

    public boolean checkIpForSupport(URI uri) throws UnknownHostException {
        InetAddress inetSocketAddress = InetAddress.getByName(uri.getHost());
        return inetSocketAddress.isSiteLocalAddress();
        //one more way
//        if (inetSocketAddress instanceof Inet6Address) {
//            return inetSocketAddress.isSiteLocalAddress();
//        }
//        return false;
    }
}
