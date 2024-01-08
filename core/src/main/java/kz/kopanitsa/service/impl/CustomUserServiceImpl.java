package kz.kopanitsa.service.impl;

import kz.kopanitsa.dto.CustomUserDto;
import kz.kopanitsa.dto.mapper.CustomUserMapper;
import kz.kopanitsa.entity.CustomUser;
import kz.kopanitsa.entity.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import kz.kopanitsa.repository.CustomUserRepository;
import kz.kopanitsa.repository.RoleRepository;
import kz.kopanitsa.service.CustomUserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserServiceImpl implements CustomUserService {

    private final CustomUserRepository customUserRepository;
    private final RoleRepository roleRepository;
    private final CustomUserMapper customUserMapper;

    @Override
    public CustomUserDto getByName(String name) {
        log.info("Try find User by name {}", name);
        CustomUser customUser = customUserRepository.findByName(name).orElseThrow();
        log.info("Find User by name {}", name);
        return customUserMapper.customUserToCustomUserDto(customUser);
    }

    @Override
    public CustomUserDto getBySurname(String surname) {
        log.info("Try find User by surname {}", surname);
        CustomUser customUser = customUserRepository.findBySurname(surname).orElseThrow();
        log.info("Find User by surname {}", surname);
        return customUserMapper.customUserToCustomUserDto(customUser);
    }

    @Override
    public CustomUserDto getByAge(Integer age) {
        log.info("Try find User by age {}", age);
        CustomUser customUser = customUserRepository.findByAge(age).orElseThrow();
        log.info("Find User by age {}", age);
        return customUserMapper.customUserToCustomUserDto(customUser);
    }

    @Override
    public CustomUserDto getByEmail(String email) {
        log.info("Try find User by email {}", email);
        CustomUser customUser = customUserRepository.findByEmail(email).orElseThrow();
        log.info("Find User by email {}", email);
        return customUserMapper.customUserToCustomUserDto(customUser);
    }

    @Override
    public CustomUserDto getByBirthday(LocalDate birthday) {
        log.info("Try find User by birthday {}", birthday);
        CustomUser customUser = customUserRepository.findByBirthday(birthday).orElseThrow();
        log.info("Find User by birthday {}", birthday);
        return customUserMapper.customUserToCustomUserDto(customUser);
    }

    @Override
    public CustomUserDto getByPhone(String phone) {
        log.info("Try find User by phone {}", phone);
        CustomUser customUser = customUserRepository.findByPhone(phone).orElseThrow();
        log.info("Find User by phone {}", phone);
        return customUserMapper.customUserToCustomUserDto(customUser);
    }

    @Override
    public CustomUserDto getByLogin(String login) {
        log.info("Try find User by login {}", login);
        CustomUser customUser = customUserRepository.findByLogin(login).orElseThrow();
        log.info("Find User by login {}", login);
        return customUserMapper.customUserToCustomUserDto(customUser);
    }

    @Override
    public List<CustomUserDto> getAllCustomUsers() {
        log.info("Try find all users");
        List<CustomUser> customUserList = customUserRepository.findAll();
        log.info("Find all users");
        return customUserList.stream()
                .map(customUserMapper::customUserToCustomUserDto)
                .toList();
    }

    @Override
    public CustomUserDto createCustomUser(CustomUserDto customUserDto) {
        log.info("Get User from UserDTO");
        CustomUser customUser = customUserMapper.customUserDtoToCustomUser(customUserDto);
        log.info("Try find User by email {}", customUserDto.getEmail());
        if(customUserRepository.existsByEmail(customUserDto.getEmail())) {
            log.info("Find User by email {}", customUserDto.getEmail());
            customUser = customUserRepository.findByEmail(customUserDto.getEmail()).orElseThrow();
            log.info("A new user has not been created because there is a user with the same email");
            return customUserMapper.customUserToCustomUserDto(customUser);
        }
        log.info("Try find User by phone {}", customUserDto.getPhone());
        if(customUserRepository.existsByPhone(customUserDto.getPhone())) {
            log.info("Find User by phone {}", customUserDto.getPhone());
            customUser = customUserRepository.findByPhone(customUserDto.getPhone()).orElseThrow();
            log.info("A new user has not been created because there is a user with the same phone");
            return customUserMapper.customUserToCustomUserDto(customUser);
        }
        log.info("Adding a role in User");
        Set<Role> roles = roleRepository.findById(1L).stream().collect(Collectors.toSet());
        customUser.setRoles(roles);
        log.info("Role is add in User");
        log.info("The new user is saved with role user");
        CustomUser newCustomerUser = customUserRepository.save(customUser);
        log.info("Save a new User");
        return customUserMapper.customUserToCustomUserDto(newCustomerUser);
    }

    @Override
    public CustomUserDto updateCustomUser(Long id, CustomUserDto customUserDto) {
        log.info("Try find User by id {}", id);
        CustomUser customUser = customUserRepository.findById(id).orElseThrow();
        log.info("Find User by id {}", id);
        customUser.setName(customUserDto.getName());
        log.info("Name change");
        customUser.setSurname(customUserDto.getSurname());
        log.info("Surname change");
        customUser.setAge(customUserDto.getAge());
        log.info("Age change");
        customUser.setEmail(customUserDto.getEmail());
        log.info("Email change");
        customUser.setBirthday(customUserDto.getBirthday());
        log.info("Birthday change");
        customUser.setPhone(customUserDto.getPhone());
        log.info("Phone change");
        customUser.setLogin(customUserDto.getLogin());
        log.info("Login change");
        customUser.setPassword(customUserDto.getPassword());
        log.info("Password change");
        CustomUser newCustomerUser = customUserRepository.save(customUser);
        log.info("Save a new User");
        return customUserMapper.customUserToCustomUserDto(newCustomerUser);
    }

    @Override
    public void deleteCustomUser(Long id) {
        customUserRepository.deleteById(id);
        log.info("User is delete");
    }
}
