package service.impl;

import dto.CustomUserDto;
import entity.CustomUser;
import service.CustomUserService;

import java.time.LocalDate;

public class CustomUserServiceImpl implements CustomUserService {
    @Override
    public CustomUserDto getByFistName(String firstName) {
        return null;
    }

    @Override
    public CustomUserDto getByLastName(String lastName) {
        return null;
    }

    @Override
    public CustomUserDto getByAge(Integer age) {
        return null;
    }

    @Override
    public CustomUserDto getByEmail(String email) {
        return null;
    }

    @Override
    public CustomUserDto getByBirthday(LocalDate birthday) {
        return null;
    }

    @Override
    public CustomUserDto getByPhone(String phone) {
        return null;
    }

    @Override
    public CustomUserDto getByLogin(String login) {
        return null;
    }

    @Override
    public CustomUserDto getAllCustomUsers() {
        return null;
    }

    @Override
    public CustomUserDto createCustomUser(CustomUser customUser) {
        return null;
    }

    @Override
    public CustomUserDto updateCustomUser(CustomUser customUser) {
        return null;
    }

    @Override
    public void deleteCustomUser(CustomUser customUser) {
    }
}
