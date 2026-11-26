package ru.udmurtia.tb.validation;

import ru.udmurtia.tb.dto.ValidationResult;
import ru.udmurtia.tb.model.CaseRecord;

public interface ValidationRule {
    void validate(CaseRecord record, ValidationResult result);
}