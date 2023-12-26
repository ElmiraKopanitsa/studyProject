package service.impl;

import dto.CustomUserDto;
import dto.mapper.CustomUserMapper;
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

    @Override
    public CustomUserDto getByFistName(String firstName) {
        CustomUser customUser = customUserRepository.findByFirstName(firstName).orElseThrow();
        return CustomUserMapper.INSTANCE.customUserToCustomUserDto(customUser);
    }

    @Override
    public CustomUserDto getByLastName(String lastName) {
        CustomUser customUser = customUserRepository.findByLastName(lastName).orElseThrow();
        return CustomUserMapper.INSTANCE.customUserToCustomUserDto(customUser);
    }

    @Override
    public CustomUserDto getByAge(Integer age) {
        CustomUser customUser = customUserRepository.findByAge(age).orElseThrow();
        return CustomUserMapper.INSTANCE.customUserToCustomUserDto(customUser);
    }

    @Override
    public CustomUserDto getByEmail(String email) {
        CustomUser customUser = customUserRepository.findByEmail(email).orElseThrow();
        return CustomUserMapper.INSTANCE.customUserToCustomUserDto(customUser);
    }

    @Override
    public CustomUserDto getByBirthday(LocalDate birthday) {
        CustomUser customUser = customUserRepository.findByBirthday(birthday).orElseThrow();
        return CustomUserMapper.INSTANCE.customUserToCustomUserDto(customUser);
    }

    @Override
    public CustomUserDto getByPhone(String phone) {
        CustomUser customUser = customUserRepository.findByPhone(phone).orElseThrow();
        return CustomUserMapper.INSTANCE.customUserToCustomUserDto(customUser);
    }

    @Override
    public CustomUserDto getByLogin(String login) {
        CustomUser customUser = customUserRepository.findByLogin(login).orElseThrow();
        return CustomUserMapper.INSTANCE.customUserToCustomUserDto(customUser);
    }

    @Override
    public List<CustomUserDto> getAllCustomUsers() {
        List<CustomUser> customUserList = customUserRepository.findAll();
        return customUserList.stream()
                .map(CustomUserMapper.INSTANCE::customUserToCustomUserDto)
                .toList();
    }

    @Override
    public CustomUserDto createCustomUser(CustomUserDto customUserDto) {
        if(customUserRepository.existsByEmail(customUserDto.getEmail())) {
            CustomUser customUser = customUserRepository.findByEmail(customUserDto.getEmail()).orElseThrow();
            return CustomUserMapper.INSTANCE.customUserToCustomUserDto(customUser);
        }
        if(customUserRepository.existsByPhone(customUserDto.getPhone())) {
            CustomUser customUser = customUserRepository.findByPhone(customUserDto.getPhone()).orElseThrow();
            return CustomUserMapper.INSTANCE.customUserToCustomUserDto(customUser);
        }
        CustomUser customUser = CustomUserMapper.INSTANCE.customUserDtoToCustomUser(customUserDto);
        CustomUser newCustomerUser = customUserRepository.save(customUser);
        Set<Role> roles = roleRepository.findById(1L).stream().collect(Collectors.toSet());
        newCustomerUser.setRoles(roles);
        return CustomUserMapper.INSTANCE.customUserToCustomUserDto(newCustomerUser);
    }

    @Override
    public CustomUserDto updateCustomUser(Long id, CustomUserDto customUserDto) {
        CustomUser customUser = customUserRepository.findById(id).orElseThrow();
        customUser.setFirstName(customUserDto.getFirstName());
        customUser.setLastName(customUserDto.getLastName());
        customUser.setAge(customUserDto.getAge());
        customUser.setEmail(customUserDto.getEmail());
        customUser.setPhone(customUserDto.getPhone());
        customUser.setLogin(customUserDto.getLogin());
        customUser.setPassword(customUserDto.getPassword());
        Set<Role> roles = roleRepository.findById(1L).stream().collect(Collectors.toSet());
        customUser.setRoles(roles);
        CustomUser newCustomerUser = customUserRepository.save(customUser);
        return CustomUserMapper.INSTANCE.customUserToCustomUserDto(newCustomerUser);
    }

    @Override
    public void deleteCustomUser(Long id) {
        customUserRepository.deleteById(id);
    }
}
