package ru.udmurtia.tb.dto;

import java.util.ArrayList;
import java.util.List;

public record ValidationResult(List<String> errors, List<String> warnings) {

    // Конструктор по умолчанию создает пустые списки
    public ValidationResult() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    public void addError(String message) {
        errors.add(message);
    }

    public void addWarning(String message) {
        warnings.add(message);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}