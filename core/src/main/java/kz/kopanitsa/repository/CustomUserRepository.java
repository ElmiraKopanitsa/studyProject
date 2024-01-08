package kz.kopanitsa.repository;

import kz.kopanitsa.entity.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.Optional;

public interface CustomUserRepository extends JpaRepository<CustomUser, Long>, JpaSpecificationExecutor<CustomUser> {

    Optional<CustomUser> findByName(String name);

    Optional<CustomUser> findBySurname(String surname);

    Optional<CustomUser> findByAge(Integer age);

    Optional<CustomUser> findByEmail(String email);

    Optional<CustomUser> findByBirthday(LocalDate birthday);

    Optional<CustomUser> findByPhone(String phone);

    Optional<CustomUser> findByLogin(String login);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);
}