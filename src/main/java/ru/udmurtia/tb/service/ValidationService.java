package ru.udmurtia.tb.service;

import org.springframework.stereotype.Service;
import ru.udmurtia.tb.dto.ValidationResult;
import ru.udmurtia.tb.model.CaseRecord;
import ru.udmurtia.tb.validation.ValidationRule;

import java.util.List;

@Service
public class ValidationService {

    private final List<ValidationRule> rules;

    // Spring автоматически внедрит сюда все наши правила (ContactsRule, ShortTreatmentRule и т.д.)
    public ValidationService(List<ValidationRule> rules) {
        this.rules = rules;
    }

    public ValidationResult validate(CaseRecord record) {
        ValidationResult result = new ValidationResult();

        // Просто проходим по всем правилам и применяем их
        for (ValidationRule rule : rules) {
            rule.validate(record, result);
        }

        return result;
    }
}