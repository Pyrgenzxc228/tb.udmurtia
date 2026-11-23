package ru.udmurtia.tb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.udmurtia.tb.model.CaseRecord;
import java.time.LocalDate;
import java.util.List;

public interface CaseRecordRepository extends JpaRepository<CaseRecord, Long> {
    // Найти все отчеты за конкретный месяц
    List<CaseRecord> findByReportDate(LocalDate reportDate);
}