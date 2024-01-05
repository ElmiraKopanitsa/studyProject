package controller;

import dto.CustomUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import service.CustomUserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class CustomUserCoreController {

    private final CustomUserService customUserService;

    @GetMapping("/name/{name}")
    public CustomUserDto getByName(@PathVariable String name) {
        return customUserService.getByName(name);
    }

    @GetMapping("/surname/{surname}")
    public CustomUserDto getBySurname(@PathVariable String surname) {
        return customUserService.getBySurname(surname);
    }

    @GetMapping("/age/{age}")
    public CustomUserDto getByAge(@PathVariable Integer age) {
        return customUserService.getByAge(age);
    }

    @GetMapping("/email/{email}")
    public CustomUserDto getByEmail(@PathVariable String email) {
        return customUserService.getByEmail(email);
    }

    @GetMapping("/getByEmail")
    public CustomUserDto getByEmail(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        return customUserService.getByEmail(email);
    }

    @GetMapping("/birthday/{birthday}")
    public CustomUserDto getByBirthday(@PathVariable LocalDate birthday) {
        return customUserService.getByBirthday(birthday);
    }

    @GetMapping("/phone/{phone}")
    public CustomUserDto getByPhone(@PathVariable String phone) {
        return customUserService.getByPhone(phone);
    }

    @GetMapping("/login/{login}")
    public CustomUserDto getByLogin(@PathVariable String login) {
        return customUserService.getByLogin(login);
    }

    @GetMapping("/allUsers")
    public List<CustomUserDto> getAllCustomUsers() {
        return customUserService.getAllCustomUsers();
    }

    @PostMapping("/create")
    public CustomUserDto createCustomUser(@RequestBody CustomUserDto customUserDto) {
        return customUserService.createCustomUser(customUserDto);
    }

    @PutMapping("/update/{id}")
    public CustomUserDto updateCustomUser(@PathVariable Long id, @RequestBody CustomUserDto customUserDto) {
        return customUserService.updateCustomUser(id, customUserDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomUser(@PathVariable Long id) {
        customUserService.deleteCustomUser(id);
    }
}
