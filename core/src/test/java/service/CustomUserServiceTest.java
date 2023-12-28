package service;

import dto.CustomUserDto;
import dto.mapper.CustomUserMapper;
import dto.mapper.RoleMapper;
import entity.CustomUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import repository.CustomUserRepository;
import repository.RoleRepository;
import service.impl.CustomUserServiceImpl;

import java.time.LocalDate;
import java.util.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = core.CoreApplication.class)
class CustomUserServiceTest {

    @Mock
    CustomUserRepository customUserRepository;
    @Mock
    RoleRepository roleRepository;
    @Mock
    private CustomUserMapper customUserMapper;
    @Mock
    private RoleMapper roleMapper;
    @InjectMocks
    CustomUserServiceImpl customUserService;
    private CustomUser customUser;

    @BeforeEach
    public void setUp() {
        customUser = CustomUser.builder()
                .id(1L)
                .name("John")
                .surname("Doe")
                .age(30)
                .email("johndoe@example.com")
                .birthday(LocalDate.of(1991, 4, 25))
                .phone("+1234567890")
                .login("johndoe")
                .password("password123")
                .build();
    }

    @Test
    void testGetByName() {
        when(customUserRepository.findByName(customUser.getName())).thenReturn(Optional.of(customUser));
        when(customUserMapper.customUserToCustomUserDto(customUser)).thenReturn(CustomUserDto.builder()
                .name(customUser.getName())
                .surname(customUser.getSurname())
                .age(customUser.getAge())
                .email(customUser.getEmail())
                .birthday(customUser.getBirthday())
                .phone(customUser.getPhone())
                .login(customUser.getLogin())
                .password(customUser.getPassword())
                .build());
        CustomUserDto result = customUserService.getByName(customUser.getName());
        verify(customUserRepository).findByName(customUser.getName());
        Assertions.assertEquals(customUser.getName(), result.getName());
        Assertions.assertEquals(customUser.getSurname(), result.getSurname());
        Assertions.assertEquals(customUser.getAge(), result.getAge());
        Assertions.assertEquals(customUser.getEmail(), result.getEmail());
        Assertions.assertEquals(customUser.getPhone(), result.getPhone());
        Assertions.assertEquals(customUser.getLogin(), result.getLogin());
        Assertions.assertEquals(customUser.getPassword(), result.getPassword());
    }

    @Test
    void testGetByNameFailed() {
        when(customUserRepository.findByName(customUser.getName())).thenReturn(Optional.empty());
        Assertions.assertThrows(NoSuchElementException.class,
                () -> customUserService.getByName(customUser.getName()));
        verify(customUserRepository).findByName(customUser.getName());
    }

    @Test
    void testGetBySurname() {
        when(customUserRepository.findBySurname(customUser.getSurname())).thenReturn(Optional.of(customUser));
        when(customUserMapper.customUserToCustomUserDto(customUser)).thenReturn(CustomUserDto.builder()
                .name(customUser.getName())
                .surname(customUser.getSurname())
                .age(customUser.getAge())
                .email(customUser.getEmail())
                .birthday(customUser.getBirthday())
                .phone(customUser.getPhone())
                .login(customUser.getLogin())
                .password(customUser.getPassword())
                .build());
        CustomUserDto result = customUserService.getBySurname(customUser.getSurname());
        verify(customUserRepository).findBySurname(customUser.getSurname());
        Assertions.assertEquals(customUser.getName(), result.getName());
        Assertions.assertEquals(customUser.getSurname(), result.getSurname());
        Assertions.assertEquals(customUser.getAge(), result.getAge());
        Assertions.assertEquals(customUser.getEmail(), result.getEmail());
        Assertions.assertEquals(customUser.getPhone(), result.getPhone());
        Assertions.assertEquals(customUser.getLogin(), result.getLogin());
        Assertions.assertEquals(customUser.getPassword(), result.getPassword());
    }

    @Test
    void testGetBySurnameFailed() {
        when(customUserRepository.findBySurname(customUser.getName())).thenReturn(Optional.empty());
        Assertions.assertThrows(NoSuchElementException.class,
                () -> customUserService.getBySurname(customUser.getSurname()));
        verify(customUserRepository).findBySurname(customUser.getSurname());
    }

    @Test
    void testGetByAge() {
        when(customUserRepository.findByAge(customUser.getAge())).thenReturn(Optional.of(customUser));
        when(customUserMapper.customUserToCustomUserDto(customUser)).thenReturn(CustomUserDto.builder()
                .name(customUser.getName())
                .surname(customUser.getSurname())
                .age(customUser.getAge())
                .email(customUser.getEmail())
                .birthday(customUser.getBirthday())
                .phone(customUser.getPhone())
                .login(customUser.getLogin())
                .password(customUser.getPassword())
                .build());
        CustomUserDto result = customUserService.getByAge(customUser.getAge());
        verify(customUserRepository).findByAge(customUser.getAge());
        Assertions.assertEquals(customUser.getName(), result.getName());
        Assertions.assertEquals(customUser.getSurname(), result.getSurname());
        Assertions.assertEquals(customUser.getAge(), result.getAge());
        Assertions.assertEquals(customUser.getEmail(), result.getEmail());
        Assertions.assertEquals(customUser.getPhone(), result.getPhone());
        Assertions.assertEquals(customUser.getLogin(), result.getLogin());
        Assertions.assertEquals(customUser.getPassword(), result.getPassword());
    }

    @Test
    void testGetByAgeFailed() {
        when(customUserRepository.findByAge(customUser.getAge())).thenReturn(Optional.empty());
        Assertions.assertThrows(NoSuchElementException.class,
                () -> customUserService.getByAge(customUser.getAge()));
        verify(customUserRepository).findByAge(customUser.getAge());
    }

    @Test
    void testGetByEmail() {
        when(customUserRepository.findByEmail(customUser.getEmail())).thenReturn(Optional.of(customUser));
        when(customUserMapper.customUserToCustomUserDto(customUser)).thenReturn(CustomUserDto.builder()
                .name(customUser.getName())
                .surname(customUser.getSurname())
                .age(customUser.getAge())
                .email(customUser.getEmail())
                .birthday(customUser.getBirthday())
                .phone(customUser.getPhone())
                .login(customUser.getLogin())
                .password(customUser.getPassword())
                .build());
        CustomUserDto result = customUserService.getByEmail(customUser.getEmail());
        verify(customUserRepository).findByEmail(customUser.getEmail());
        Assertions.assertEquals(customUser.getName(), result.getName());
        Assertions.assertEquals(customUser.getSurname(), result.getSurname());
        Assertions.assertEquals(customUser.getAge(), result.getAge());
        Assertions.assertEquals(customUser.getEmail(), result.getEmail());
        Assertions.assertEquals(customUser.getPhone(), result.getPhone());
        Assertions.assertEquals(customUser.getLogin(), result.getLogin());
        Assertions.assertEquals(customUser.getPassword(), result.getPassword());
    }

    @Test
    void testGetByEmailFailed() {
        when(customUserRepository.findByEmail(customUser.getEmail())).thenReturn(Optional.empty());
        Assertions.assertThrows(NoSuchElementException.class,
                () -> customUserService.getByEmail(customUser.getEmail()));
        verify(customUserRepository).findByEmail(customUser.getEmail());
    }

    @Test
    void testGetByBirthday() {
        when(customUserRepository.findByBirthday(customUser.getBirthday())).thenReturn(Optional.of(customUser));
        when(customUserMapper.customUserToCustomUserDto(customUser)).thenReturn(CustomUserDto.builder()
                .name(customUser.getName())
                .surname(customUser.getSurname())
                .age(customUser.getAge())
                .email(customUser.getEmail())
                .birthday(customUser.getBirthday())
                .phone(customUser.getPhone())
                .login(customUser.getLogin())
                .password(customUser.getPassword())
                .build());
        CustomUserDto result = customUserService.getByBirthday(customUser.getBirthday());
        verify(customUserRepository).findByBirthday(customUser.getBirthday());
        Assertions.assertEquals(customUser.getName(), result.getName());
        Assertions.assertEquals(customUser.getSurname(), result.getSurname());
        Assertions.assertEquals(customUser.getAge(), result.getAge());
        Assertions.assertEquals(customUser.getEmail(), result.getEmail());
        Assertions.assertEquals(customUser.getPhone(), result.getPhone());
        Assertions.assertEquals(customUser.getLogin(), result.getLogin());
        Assertions.assertEquals(customUser.getPassword(), result.getPassword());
    }

    @Test
    void testGetByBirthdayFailed() {
        when(customUserRepository.findByBirthday(customUser.getBirthday())).thenReturn(Optional.empty());
        Assertions.assertThrows(NoSuchElementException.class,
                () -> customUserService.getByBirthday(customUser.getBirthday()));
        verify(customUserRepository).findByBirthday(customUser.getBirthday());
    }

    @Test
    void testGetByPhone() {
        when(customUserRepository.findByPhone(customUser.getPhone())).thenReturn(Optional.of(customUser));
        when(customUserMapper.customUserToCustomUserDto(customUser)).thenReturn(CustomUserDto.builder()
                .name(customUser.getName())
                .surname(customUser.getSurname())
                .age(customUser.getAge())
                .email(customUser.getEmail())
                .birthday(customUser.getBirthday())
                .phone(customUser.getPhone())
                .login(customUser.getLogin())
                .password(customUser.getPassword())
                .build());
        CustomUserDto result = customUserService.getByPhone(customUser.getPhone());
        verify(customUserRepository).findByPhone(customUser.getPhone());
        Assertions.assertEquals(customUser.getName(), result.getName());
        Assertions.assertEquals(customUser.getSurname(), result.getSurname());
        Assertions.assertEquals(customUser.getAge(), result.getAge());
        Assertions.assertEquals(customUser.getEmail(), result.getEmail());
        Assertions.assertEquals(customUser.getPhone(), result.getPhone());
        Assertions.assertEquals(customUser.getLogin(), result.getLogin());
        Assertions.assertEquals(customUser.getPassword(), result.getPassword());
    }

    @Test
    void testGetByPhoneFailed() {
        when(customUserRepository.findByPhone(customUser.getPhone())).thenReturn(Optional.empty());
        Assertions.assertThrows(NoSuchElementException.class,
                () -> customUserService.getByPhone(customUser.getPhone()));
        verify(customUserRepository).findByPhone(customUser.getPhone());
    }

    @Test
    void testGetByLogin() {
        when(customUserRepository.findByLogin(customUser.getLogin())).thenReturn(Optional.of(customUser));
        when(customUserMapper.customUserToCustomUserDto(customUser)).thenReturn(CustomUserDto.builder()
                .name(customUser.getName())
                .surname(customUser.getSurname())
                .age(customUser.getAge())
                .email(customUser.getEmail())
                .birthday(customUser.getBirthday())
                .phone(customUser.getPhone())
                .login(customUser.getLogin())
                .password(customUser.getPassword())
                .build());
        CustomUserDto result = customUserService.getByLogin(customUser.getLogin());
        verify(customUserRepository).findByLogin(customUser.getLogin());
        Assertions.assertEquals(customUser.getName(), result.getName());
        Assertions.assertEquals(customUser.getSurname(), result.getSurname());
        Assertions.assertEquals(customUser.getAge(), result.getAge());
        Assertions.assertEquals(customUser.getEmail(), result.getEmail());
        Assertions.assertEquals(customUser.getPhone(), result.getPhone());
        Assertions.assertEquals(customUser.getLogin(), result.getLogin());
        Assertions.assertEquals(customUser.getPassword(), result.getPassword());
    }

    @Test
    void testGetByLoginFailed() {
        when(customUserRepository.findByLogin(customUser.getLogin())).thenReturn(Optional.empty());
        Assertions.assertThrows(NoSuchElementException.class,
                () -> customUserService.getByLogin(customUser.getLogin()));
        verify(customUserRepository).findByLogin(customUser.getLogin());
    }

    @Test
    void testGetAllCustomUsers() {
        List<CustomUser> customUserList = new ArrayList<>();
        customUserList.add(customUser);
        when(customUserRepository.findAll()).thenReturn(customUserList);
        when(customUserMapper.customUserToCustomUserDto(customUser)).thenReturn(CustomUserDto.builder()
                .name(customUser.getName())
                .surname(customUser.getSurname())
                .age(customUser.getAge())
                .email(customUser.getEmail())
                .birthday(customUser.getBirthday())
                .phone(customUser.getPhone())
                .login(customUser.getLogin())
                .password(customUser.getPassword())
                .build());
        List<CustomUserDto> expectedCustomUserList = customUserList.stream()
                .map(customUserMapper::customUserToCustomUserDto)
                .toList();
        List<CustomUserDto> result = customUserService.getAllCustomUsers();
        verify(customUserRepository).findAll();
        Assertions.assertEquals(expectedCustomUserList, result);
    }

    @Test
    void testCreateCustomUser() {
        CustomUserDto customUserDto = CustomUserDto.builder()
                .name("John")
                .surname("Doe")
                .age(30)
                .email("johndoe@example.com")
                .phone("1234567890")
                .login("johndoe")
                .password("password123")
                .build();
        when(customUserRepository.existsByEmail(customUserDto.getEmail())).thenReturn(false);
        when(customUserRepository.existsByPhone(customUserDto.getPhone())).thenReturn(false);
        CustomUser customUser = CustomUser.builder()
                .name(customUserDto.getName())
                .surname(customUserDto.getSurname())
                .age(customUserDto.getAge())
                .email(customUserDto.getEmail())
                .phone(customUserDto.getPhone())
                .login(customUserDto.getLogin())
                .password(customUserDto.getPassword())
                .build();
        CustomUser newCustomerUser = CustomUser.builder()
                .name("New John")
                .surname("New Doe")
                .age(35)
                .email("newjohndoe@example.com")
                .phone("9876543210")
                .login("newjohndoe")
                .password("newpassword123")
                .build();
        when(customUserRepository.save(customUser)).thenReturn(newCustomerUser);
        when(customUserMapper.customUserDtoToCustomUser(customUserDto)).thenReturn(customUser);
        when(customUserMapper.customUserToCustomUserDto(newCustomerUser)).thenReturn(CustomUserDto.builder()
                .name(newCustomerUser.getName())
                .surname(newCustomerUser.getSurname())
                .age(newCustomerUser.getAge())
                .email(newCustomerUser.getEmail())
                .phone(newCustomerUser.getPhone())
                .login(newCustomerUser.getLogin())
                .password(newCustomerUser.getPassword())
                .build());
        CustomUserDto result = customUserService.createCustomUser(customUserDto);
        verify(customUserRepository).save(customUser);
        Assertions.assertEquals(newCustomerUser.getName(), result.getName());
        Assertions.assertEquals(newCustomerUser.getSurname(), result.getSurname());
        Assertions.assertEquals(newCustomerUser.getAge(), result.getAge());
        Assertions.assertEquals(newCustomerUser.getEmail(), result.getEmail());
        Assertions.assertEquals(newCustomerUser.getPhone(), result.getPhone());
        Assertions.assertEquals(newCustomerUser.getLogin(), result.getLogin());
        Assertions.assertEquals(newCustomerUser.getPassword(), result.getPassword());
    }

    @Test
    void testUpdateCustomUser() {
        CustomUserDto updateCustomUserDto = CustomUserDto.builder()
                .name("John")
                .surname("Black")
                .age(30)
                .email("johndoe@example.com")
                .birthday(LocalDate.of(1991, 4, 25))
                .phone("+1234567890")
                .login("johndoe")
                .password("password123")
                .build();
        CustomUser updateCustomUser = CustomUser.builder()
                .name(updateCustomUserDto.getName())
                .surname(updateCustomUserDto.getSurname())
                .age(updateCustomUserDto.getAge())
                .email(updateCustomUserDto.getEmail())
                .birthday(updateCustomUserDto.getBirthday())
                .phone(updateCustomUserDto.getPhone())
                .login(updateCustomUserDto.getLogin())
                .password(updateCustomUserDto.getPassword())
                .build();
        when(customUserRepository.findById(1L)).thenReturn(Optional.of(customUser));
        when(customUserMapper.customUserDtoToCustomUser(updateCustomUserDto)).thenReturn(updateCustomUser);
        when(customUserRepository.save(customUser)).thenReturn(updateCustomUser);
        when(customUserMapper.customUserToCustomUserDto(updateCustomUser)).thenReturn(CustomUserDto.builder()
                .name(updateCustomUser.getName())
                .surname(updateCustomUser.getSurname())
                .age(updateCustomUser.getAge())
                .email(updateCustomUser.getEmail())
                .birthday(updateCustomUser.getBirthday())
                .phone(updateCustomUser.getPhone())
                .login(updateCustomUser.getLogin())
                .password(updateCustomUser.getPassword())
                .build());
        CustomUserDto result = customUserService.updateCustomUser(1L, updateCustomUserDto);
        verify(customUserRepository).findById(1L);
        verify(customUserRepository).save(customUser);
        Assertions.assertEquals(customUser.getName(), result.getName());
        Assertions.assertEquals(customUser.getSurname(), result.getSurname());
        Assertions.assertEquals(customUser.getAge(), result.getAge());
        Assertions.assertEquals(customUser.getEmail(), result.getEmail());
        Assertions.assertEquals(customUser.getBirthday(), result.getBirthday());
        Assertions.assertEquals(customUser.getPhone(), result.getPhone());
        Assertions.assertEquals(customUser.getLogin(), result.getLogin());
        Assertions.assertEquals(customUser.getPassword(), result.getPassword());
    }

    @Test
    void testDeleteCustomUser() {
        // Создаем объект CustomUser
        CustomUser customUser = CustomUser.builder()
                .id(1L)
                .name("John")
                .surname("Doe")
                .age(30)
                .email("johndoe@example.com")
                .birthday(LocalDate.of(1991, 4, 25))
                .phone("+1234567890")
                .login("johndoe")
                .password("password123")
                .build();
        when(customUserRepository.findById(1L)).thenReturn(Optional.of(customUser));
        customUserService.deleteCustomUser(1L);
        verify(customUserRepository).deleteById(1L);
    }
}