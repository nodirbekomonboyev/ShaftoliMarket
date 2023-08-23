package uz.shaftolimarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.shaftolimarket.dto.UserDTO;
import uz.shaftolimarket.model.UserEntity;
import uz.shaftolimarket.service.UserService;
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    @PostMapping("/create")
    public ResponseEntity<UserEntity> signUp(
            @RequestBody UserDTO userDTO
    ) {
        return ResponseEntity.ok(userService.save(userDTO));
    }

    @PostMapping("/verification")
    public ResponseEntity<String> verification(
            @RequestParam String code
    ) {
        userService.verifyByEmail(code);
        return ResponseEntity.ok("xali davmi bor");
    }
}
