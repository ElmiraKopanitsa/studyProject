package kz.kopznitsa.web1.contoller;

import kz.kopznitsa.web1.dto.CustomUserDto;
import kz.kopznitsa.web1.service.CustomUserWeb1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/web1/users")
public class CustomUserWeb1Controller {

    private final CustomUserWeb1Service customUserWeb1Service;

    @GetMapping("/name/{name}")
    ResponseEntity<CustomUserDto> getByName(@PathVariable String name) {
        return customUserWeb1Service.getByName(name);
    }

    @GetMapping("/surname/{surname}")
    ResponseEntity<CustomUserDto> getBySurname(@PathVariable String surname) {
        return customUserWeb1Service.getBySurname(surname);
    }

    @GetMapping("/age/{age}")
    ResponseEntity<CustomUserDto> getByAge(@PathVariable Integer age) {
        return customUserWeb1Service.getByAge(age);
    }

    @GetMapping("/email/{email}")
    ResponseEntity<CustomUserDto> getByEmail(@PathVariable String email) {
        return customUserWeb1Service.getByEmail(email);
    }

    @GetMapping("/birthday/{birthday}")
    ResponseEntity<CustomUserDto> getByBirthday(@PathVariable LocalDate birthday) {
        return customUserWeb1Service.getByBirthday(birthday);
    }

    @GetMapping("/phone/{phone}")
    ResponseEntity<CustomUserDto> getByPhone(@PathVariable String phone) {
        return customUserWeb1Service.getByPhone(phone);
    }

    @GetMapping("/login/{login}")
    ResponseEntity<CustomUserDto> getByLogin(@PathVariable String login) {
        return customUserWeb1Service.getByLogin(login);
    }

    @GetMapping("/allUsers")
    ResponseEntity<List<CustomUserDto>> getAllCustomUsers() {
        return customUserWeb1Service.getAllCustomUsers();
    }

    @PostMapping("/create")
    ResponseEntity<CustomUserDto> createCustomUser(@RequestBody CustomUserDto customUserDto) {
        return customUserWeb1Service.createCustomUser(customUserDto);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<CustomUserDto> updateCustomUser(@PathVariable Long id, @RequestBody CustomUserDto customUserDto) {
        return customUserWeb1Service.updateCustomUser(id, customUserDto);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteCustomUser(@PathVariable Long id) {
        return customUserWeb1Service.deleteCustomUser(id);
    }
}
