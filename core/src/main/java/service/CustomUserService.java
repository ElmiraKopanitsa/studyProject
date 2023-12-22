package service;

import dto.CustomUserDto;
import entity.CustomUser;

import java.time.LocalDate;

public interface CustomUserService {

    CustomUserDto getByFistName(String firstName);

    CustomUserDto getByLastName(String lastName);

    CustomUserDto getByAge(Integer age);

    CustomUserDto getByEmail(String email);

    CustomUserDto getByBirthday(LocalDate birthday);

    CustomUserDto getByPhone(String phone);

    CustomUserDto getByLogin(String login);

    CustomUserDto getAllCustomUsers();

    CustomUserDto createCustomUser(CustomUser customUser);

    CustomUserDto updateCustomUser(CustomUser customUser);

    void deleteCustomUser(CustomUser customUser);
}
