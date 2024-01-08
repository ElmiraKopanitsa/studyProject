package kz.kopanitsa.service;

import kz.kopanitsa.dto.CustomUserDto;

import java.time.LocalDate;
import java.util.List;

public interface CustomUserService {

    CustomUserDto getByName(String name);

    CustomUserDto getBySurname(String surname);

    CustomUserDto getByAge(Integer age);

    CustomUserDto getByEmail(String email);

    CustomUserDto getByBirthday(LocalDate birthday);

    CustomUserDto getByPhone(String phone);

    CustomUserDto getByLogin(String login);

    List<CustomUserDto> getAllCustomUsers();

    CustomUserDto createCustomUser(CustomUserDto customUserDto);

    CustomUserDto updateCustomUser(Long id, CustomUserDto customUserDto);

    void deleteCustomUser(Long id);
}
