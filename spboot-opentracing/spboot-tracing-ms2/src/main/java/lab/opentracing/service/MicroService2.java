package lab.opentracing.controller;

import org.springframework.stereotype.Service;

@Service
public class MicroService2 {

    public String serviceMS2() {
        return " reply from microservice 2";
    }
}