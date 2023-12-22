package repository;

import entity.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {

    Optional<CustomUser> findByFirstName(String firstName);

    Optional<CustomUser> findByLastName(String lastName);

    Optional<CustomUser> findByAge(Integer age);

    Optional<CustomUser> findByEmail(String email);

    Optional<CustomUser> findByBirthday(LocalDate birthday);

    Optional<CustomUser> findByPhone(String phone);

    Optional<CustomUser> findByLogin(String login);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);
}