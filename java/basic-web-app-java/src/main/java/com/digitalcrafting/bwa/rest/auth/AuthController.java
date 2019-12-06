package com.digitalcrafting.bwa.rest.auth;

import com.digitalcrafting.bwa.objects.enums.LoginStatusEnum;
import com.digitalcrafting.bwa.objects.enums.SignUpStatusEnum;
import com.digitalcrafting.bwa.rest.auth.objects.LoginRequest;
import com.digitalcrafting.bwa.rest.auth.objects.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthControllerService service;

    public AuthController(AuthControllerService service) {
        this.service = service;
    }

    @GetMapping("/")
    public LoginStatusEnum isLoggedIn() {
        return service.isLoggedIn();
    }

    @PostMapping("/")
    public ResponseEntity<LoginStatusEnum> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(service.login(request));
    }

    @PutMapping("/")
    public ResponseEntity<SignUpStatusEnum> singUp(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(service.signUp(request));
    }
}
