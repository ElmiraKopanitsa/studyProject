package kz.kopznitsa.web1.service;

import kz.kopznitsa.web1.dto.CustomUserDto;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface CustomUserWeb1Service {

    ResponseEntity<CustomUserDto> getByName(String name);

    ResponseEntity<CustomUserDto> getBySurname(String surname);

    ResponseEntity<CustomUserDto> getByAge(Integer age);

    ResponseEntity<CustomUserDto> getByEmail(String email);

    ResponseEntity<CustomUserDto> getByBirthday(LocalDate birthday);

    ResponseEntity<CustomUserDto> getByPhone(String phone);

    ResponseEntity<CustomUserDto> getByLogin(String login);

    ResponseEntity<List<CustomUserDto>> getAllCustomUsers();

    ResponseEntity<CustomUserDto> createCustomUser(CustomUserDto customUserDto);

    ResponseEntity<CustomUserDto> updateCustomUser(Long id, CustomUserDto customUserDto);

    ResponseEntity<Void> deleteCustomUser(Long id);
}
