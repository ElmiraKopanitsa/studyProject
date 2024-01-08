package kz.kopanitsa.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="users")
public class CustomUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private LocalDate birthday;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomUser that = (CustomUser) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) && Objects.equals(age, that.age) &&
                Objects.equals(email, that.email) && Objects.equals(birthday, that.birthday) &&
                Objects.equals(phone, that.phone) && Objects.equals(login, that.login) &&
                Objects.equals(password, that.password) && Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age, email, birthday, phone, login, password, roles);
    }
}