package ru.udmurtia.tb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.udmurtia.tb.model.AppUser;
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username); // Spring сам поймет, что это SELECT * WHERE username = ?
}