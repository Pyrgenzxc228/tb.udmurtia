package ru.udmurtia.tb.validation;

import org.springframework.stereotype.Component;
import ru.udmurtia.tb.dto.ValidationResult;
import ru.udmurtia.tb.model.CaseRecord;

@Component
public class GroupReconciliationRule implements ValidationRule {
    @Override
    public void validate(CaseRecord record, ValidationResult result) {
        int totalOnTreatment = record.getAmbTotal() + record.getStatTotal() + record.getDayTotal();
        if (record.getGduI() != totalOnTreatment) {
            result.addError("Не сходится 1-я группа: всего " + record.getGduI()
                    + " чел., а на лечении " + totalOnTreatment);
        }
    }
}