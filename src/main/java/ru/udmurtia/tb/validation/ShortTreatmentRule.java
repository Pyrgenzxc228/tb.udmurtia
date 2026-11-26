package ru.udmurtia.tb.validation;

import org.springframework.stereotype.Component;
import ru.udmurtia.tb.dto.ValidationResult;
import ru.udmurtia.tb.model.CaseRecord;

@Component
public class ShortTreatmentRule implements ValidationRule {

    private static final double MIN_SHORT = 0.35;
    private static final double MAX_SHORT = 0.45;

    @Override
    public void validate(CaseRecord record, ValidationResult result) {
        int totalOnTreatment = record.getAmbTotal() + record.getStatTotal() + record.getDayTotal();

        if (totalOnTreatment > 0) {
            int shortCount = calculateShort(record);
            double share = (double) shortCount / totalOnTreatment;

            if (share < MIN_SHORT || share > MAX_SHORT) {
                result.addWarning(String.format(
                        "Доля короткого лечения %.1f%% выходит за рамки 35-45%%", share * 100
                ));
            }
        }
    }

    private int calculateShort(CaseRecord r) {
        return r.getAmbLchShort() + r.getAmbMluShort6m() + r.getAmbMluShort9m()
                + r.getAmbPreshluShort6m() + r.getAmbPreshluShort9m()
                + r.getStatLchShort() + r.getStatMluShort6m() + r.getStatMluShort9m()
                + r.getStatPreshluShort6m() + r.getStatPreshluShort9m()
                + r.getDayLchShort() + r.getDayMluShort6m() + r.getDayMluShort9m()
                + r.getDayPreshluShort6m() + r.getDayPreshluShort9m();
    }
}