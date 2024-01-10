package kz.kopznitsa.web1.feign;

import kz.kopznitsa.web1.dto.CustomUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@FeignClient(name = "userCoreFeignClient", url = "http://localhost:8080/users/")
public interface UserCoreFeignClient {

    @GetMapping(value = "/name/{name}")
    CustomUserDto getByName(@PathVariable("name") String name);

    @GetMapping(value = "/surname/{surname}")
    CustomUserDto getBySurname(@PathVariable("surname") String surname);

    @GetMapping(value = "/age/{age}")
    CustomUserDto getByAge(@PathVariable("age") Integer age);

    @GetMapping(value = "/email/{email}")
    CustomUserDto getByEmail(@PathVariable("email") String email);

    @GetMapping(value = "/birthday/{birthday}")
    CustomUserDto getByBirthday(@PathVariable("birthday") LocalDate birthday);

    @GetMapping(value = "/phone/{phone}")
    CustomUserDto getByPhone(@PathVariable("phone") String phone);

    @GetMapping(value = "/login/{login}")
    CustomUserDto getByLogin(@PathVariable("login") String login);

    @GetMapping("/allUsers")
    List<CustomUserDto> getAllCustomUsers();

    @PostMapping(value = "/create", consumes = "application/json")
    CustomUserDto createCustomUser(@RequestBody CustomUserDto customUserDto);

    @PutMapping(value = "/update/{id}", consumes = "application/json")
    CustomUserDto updateCustomUser(@PathVariable("id") Long id, @RequestBody CustomUserDto customUserDto);

    @DeleteMapping("/delete/{id}")
    void deleteCustomUser(@PathVariable Long id);
}
