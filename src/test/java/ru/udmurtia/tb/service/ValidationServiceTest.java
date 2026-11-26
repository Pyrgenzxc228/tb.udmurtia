package ru.udmurtia.tb.service;

import org.junit.jupiter.api.Test;
import ru.udmurtia.tb.dto.ValidationResult;
import ru.udmurtia.tb.model.CaseRecord;
import ru.udmurtia.tb.validation.ContactsRule;
import ru.udmurtia.tb.validation.GroupReconciliationRule;
import ru.udmurtia.tb.validation.ShortTreatmentRule;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationServiceTest {

    // Вручную собираем наш сервис с правилами (как это сделал бы Spring)
    private final ValidationService service = new ValidationService(
            List.of(new ContactsRule(), new GroupReconciliationRule(), new ShortTreatmentRule())
    );

    @Test
    void shouldWarnIfNotEnoughContacts() {
        CaseRecord record = new CaseRecord();
        record.setNewCases(5);
        record.setContactsCount(50); // 50 / 5 = 10 (меньше 20)

        ValidationResult result = service.validate(record);

        assertThat(result.warnings()).hasSize(1);
        assertThat(result.warnings().get(0)).contains("Мало контактных");
    }

    @Test
    void shouldErrorIfGroupOneDoesNotMatchTreatment() {
        CaseRecord record = new CaseRecord();
        record.setGduI(100); // В первой группе 100
        record.setAmbTotal(50);
        record.setStatTotal(20);
        record.setDayTotal(10); // На лечении всего 80. Разница 20!

        ValidationResult result = service.validate(record);

        assertThat(result.hasErrors()).isTrue();
        assertThat(result.errors().get(0)).contains("Не сходится 1-я группа");
    }

    @Test
    void shouldWarnIfShortTreatmentIsTooHigh() {
        CaseRecord record = new CaseRecord();
        record.setGduI(100);
        record.setAmbTotal(100); // На лечении 100
        record.setAmbLchShort(60); // Короткое лечение 60 (это 60%, а норма 35-45%)

        ValidationResult result = service.validate(record);

        assertThat(result.warnings()).hasSize(1);
        assertThat(result.warnings().get(0)).contains("выходит за рамки 35-45%");
    }

    @Test
    void shouldPassIfEverythingIsFine() {
        CaseRecord record = new CaseRecord();
        record.setNewCases(1);
        record.setContactsCount(25); // Норма контактных
        record.setGduI(100);
        record.setAmbTotal(100); // Сходится
        record.setAmbLchShort(40); // 40% короткого лечения (в коридоре)

        ValidationResult result = service.validate(record);

        assertThat(result.hasErrors()).isFalse();
        assertThat(result.warnings()).isEmpty();
    }
}