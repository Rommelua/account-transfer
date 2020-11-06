package com.boot.test.demo.service;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class InjectDataService {
    private final AuthenticationService service;

    public InjectDataService(AuthenticationService service) {
        this.service = service;
    }

    @PostConstruct
    private void saveUsers() {
        service.register("Andrey", "1111");
        service.register("Svetlana", "1111");
        service.register("Ivan", "1111");
    }
}
