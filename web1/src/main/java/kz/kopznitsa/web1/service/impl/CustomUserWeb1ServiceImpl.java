package kz.kopznitsa.web1.service.impl;

import kz.kopznitsa.web1.dto.CustomUserDto;
import kz.kopznitsa.web1.feign.UserCoreFeignClient;
import kz.kopznitsa.web1.service.CustomUserWeb1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserWeb1ServiceImpl implements CustomUserWeb1Service {

    private final UserCoreFeignClient userCoreFeignClient;

    @Override
    public ResponseEntity<CustomUserDto> getByName(String name) {
        CustomUserDto customUserDto = userCoreFeignClient.getByName(name);
        return ResponseEntity.ok(customUserDto);
    }

    @Override
    public ResponseEntity<CustomUserDto> getBySurname(String surname) {
        CustomUserDto customUserDto = userCoreFeignClient.getBySurname(surname);
        return ResponseEntity.ok(customUserDto);
    }

    @Override
    public ResponseEntity<CustomUserDto> getByAge(Integer age) {
        CustomUserDto customUserDto = userCoreFeignClient.getByAge(age);
        return ResponseEntity.ok(customUserDto);
    }

    @Override
    public ResponseEntity<CustomUserDto> getByEmail(String email) {
        CustomUserDto customUserDto = userCoreFeignClient.getByEmail(email);
        return ResponseEntity.ok(customUserDto);
    }

    @Override
    public ResponseEntity<CustomUserDto> getByBirthday(LocalDate birthday) {
        CustomUserDto customUserDto = userCoreFeignClient.getByBirthday(birthday);
        return ResponseEntity.ok(customUserDto);
    }

    @Override
    public ResponseEntity<CustomUserDto> getByPhone(String phone) {
        CustomUserDto customUserDto = userCoreFeignClient.getByPhone(phone);
        return ResponseEntity.ok(customUserDto);
    }

    @Override
    public ResponseEntity<CustomUserDto> getByLogin(String login) {
        CustomUserDto customUserDto = userCoreFeignClient.getByLogin(login);
        return ResponseEntity.ok(customUserDto);
    }

    @Override
    public ResponseEntity<List<CustomUserDto>> getAllCustomUsers() {
        List<CustomUserDto> listCustomUserDto = userCoreFeignClient.getAllCustomUsers();
        return ResponseEntity.ok(listCustomUserDto);
    }

    @Override
    public ResponseEntity<CustomUserDto> createCustomUser(CustomUserDto customUserDto) {
        CustomUserDto newCustomUserDto = userCoreFeignClient.createCustomUser(customUserDto);
        return ResponseEntity.ok(newCustomUserDto);
    }

    @Override
    public ResponseEntity<CustomUserDto> updateCustomUser(Long id, CustomUserDto customUserDto) {
        CustomUserDto updateCustomUserDto = userCoreFeignClient.updateCustomUser(id, customUserDto);
        return ResponseEntity.ok(updateCustomUserDto);
    }

    @Override
    public ResponseEntity<Void> deleteCustomUser(Long id) {
        userCoreFeignClient.deleteCustomUser(id);
        return ResponseEntity.noContent().build();
    }
}
