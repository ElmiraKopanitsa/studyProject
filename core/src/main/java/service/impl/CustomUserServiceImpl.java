package service.impl;

import dto.CustomUserDto;
import dto.mapper.CustomUserMapper;
import dto.mapper.RoleMapper;
import entity.CustomUser;
import entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.CustomUserRepository;
import repository.RoleRepository;
import service.CustomUserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserServiceImpl implements CustomUserService {

    private final CustomUserRepository customUserRepository;
    private final RoleRepository roleRepository;
    private final CustomUserMapper customUserMapper;
    private final RoleMapper roleMapper;

    @Override
    public CustomUserDto getByName(String name) {
        CustomUser customUser = customUserRepository.findByName(name).orElseThrow();
        return customUserMapper.customUserToCustomUserDto(customUser);
    }

    @Override
    public CustomUserDto getBySurname(String surname) {
        CustomUser customUser = customUserRepository.findBySurname(surname).orElseThrow();
        return customUserMapper.customUserToCustomUserDto(customUser);
    }

    @Override
    public CustomUserDto getByAge(Integer age) {
        CustomUser customUser = customUserRepository.findByAge(age).orElseThrow();
        return customUserMapper.customUserToCustomUserDto(customUser);
    }

    @Override
    public CustomUserDto getByEmail(String email) {
        CustomUser customUser = customUserRepository.findByEmail(email).orElseThrow();
        return customUserMapper.customUserToCustomUserDto(customUser);
    }

    @Override
    public CustomUserDto getByBirthday(LocalDate birthday) {
        CustomUser customUser = customUserRepository.findByBirthday(birthday).orElseThrow();
        return customUserMapper.customUserToCustomUserDto(customUser);
    }

    @Override
    public CustomUserDto getByPhone(String phone) {
        CustomUser customUser = customUserRepository.findByPhone(phone).orElseThrow();
        return customUserMapper.customUserToCustomUserDto(customUser);
    }

    @Override
    public CustomUserDto getByLogin(String login) {
        CustomUser customUser = customUserRepository.findByLogin(login).orElseThrow();
        return customUserMapper.customUserToCustomUserDto(customUser);
    }

    @Override
    public List<CustomUserDto> getAllCustomUsers() {
        List<CustomUser> customUserList = customUserRepository.findAll();
        return customUserList.stream()
                .map(customUserMapper::customUserToCustomUserDto)
                .toList();
    }

    @Override
    public CustomUserDto createCustomUser(CustomUserDto customUserDto) {
        if(customUserRepository.existsByEmail(customUserDto.getEmail())) {
            CustomUser customUser = customUserRepository.findByEmail(customUserDto.getEmail()).orElseThrow();
            return customUserMapper.customUserToCustomUserDto(customUser);
        }
        if(customUserRepository.existsByPhone(customUserDto.getPhone())) {
            CustomUser customUser = customUserRepository.findByPhone(customUserDto.getPhone()).orElseThrow();
            return customUserMapper.customUserToCustomUserDto(customUser);
        }
        CustomUser customUser = customUserMapper.customUserDtoToCustomUser(customUserDto);
        CustomUser newCustomerUser = customUserRepository.save(customUser);
        Set<Role> roles = roleRepository.findById(1L).stream().collect(Collectors.toSet());
        newCustomerUser.setRoles(roles);
        return customUserMapper.customUserToCustomUserDto(newCustomerUser);
    }

    @Override
    public CustomUserDto updateCustomUser(Long id, CustomUserDto customUserDto) {
        CustomUser customUser = customUserRepository.findById(id).orElseThrow();
        customUser.setName(customUserDto.getName());
        customUser.setSurname(customUserDto.getSurname());
        customUser.setAge(customUserDto.getAge());
        customUser.setEmail(customUserDto.getEmail());
        customUser.setBirthday(customUserDto.getBirthday());
        customUser.setPhone(customUserDto.getPhone());
        customUser.setLogin(customUserDto.getLogin());
        customUser.setPassword(customUserDto.getPassword());
        Set<Role> roles = roleRepository.findById(1L).stream().collect(Collectors.toSet());
        customUser.setRoles(roles);
        CustomUser newCustomerUser = customUserRepository.save(customUser);
        return customUserMapper.customUserToCustomUserDto(newCustomerUser);
    }

    @Override
    public void deleteCustomUser(Long id) {
        customUserRepository.deleteById(id);
    }
}
