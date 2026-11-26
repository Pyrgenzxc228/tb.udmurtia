package ru.udmurtia.tb.validation;

import org.springframework.stereotype.Component;
import ru.udmurtia.tb.dto.ValidationResult;
import ru.udmurtia.tb.model.CaseRecord;

@Component
public class ContactsRule implements ValidationRule {
    @Override
    public void validate(CaseRecord record, ValidationResult result) {
        if (record.getNewCases() > 0) {
            double ratio = (double) record.getContactsCount() / record.getNewCases();
            if (ratio < 20) {
                result.addWarning(String.format("Мало контактных: %.1f на 1 больного (норма ≥ 20)", ratio));
            }
        }
    }
}