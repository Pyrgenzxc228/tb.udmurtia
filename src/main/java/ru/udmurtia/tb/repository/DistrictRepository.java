package ru.udmurtia.tb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.udmurtia.tb.model.District;
public interface DistrictRepository extends JpaRepository<District, Long> {}