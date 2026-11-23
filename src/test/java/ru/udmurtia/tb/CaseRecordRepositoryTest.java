package ru.udmurtia.tb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.udmurtia.tb.model.*;
import ru.udmurtia.tb.repository.*;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional // Откатывает изменения после теста (чтобы не засорять базу)
class CaseRecordRepositoryTest {

    @Autowired private ClusterRepository clusterRepo;
    @Autowired private DistrictRepository districtRepo;
    @Autowired private AppUserRepository userRepo;
    @Autowired private CaseRecordRepository caseRepo;

    @Test
    void shouldSaveAndCalculateStatistics() {
        // 1. Создаем справочники
        Cluster cluster = new Cluster("МПТД");
        clusterRepo.save(cluster);

        District district = new District("г. Можга", cluster);
        districtRepo.save(district);

        AppUser doctor = new AppUser();
        doctor.setUsername("ivanov");
        doctor.setFullName("Иванов И.И.");
        doctor.setRole("DOCTOR");
        doctor.setPasswordHash("dummy_password_hash");
        doctor.setDistrict(district);
        userRepo.save(doctor);

        // 2. Создаем статистический отчет от этого врача
        CaseRecord record = new CaseRecord();
        record.setDoctor(doctor);
        record.setDistrict(district);
        record.setReportDate(LocalDate.of(2026, 10, 1)); // Октябрь 2026
        record.setTotalOnDu(100);
        record.setNewCases(10);
        record.setContactsCount(150);
        record.setAmbLchShort(30); // 30 человек на коротком лечении

        // 3. Сохраняем
        caseRepo.save(record);

        // 4. Проверяем, что данные записались и связи не потерялись
        CaseRecord saved = caseRepo.findByReportDate(LocalDate.of(2026, 10, 1)).get(0);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getDistrict().getName()).isEqualTo("г. Можга");
        assertThat(saved.getDoctor().getFullName()).isEqualTo("Иванов И.И.");
        assertThat(saved.getAmbLchShort()).isEqualTo(30);
    }
}