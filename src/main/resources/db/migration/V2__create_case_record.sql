CREATE TABLE case_record (
    id BIGSERIAL PRIMARY KEY,

    -- Связи
    doctor_id BIGINT NOT NULL,
    district_id BIGINT NOT NULL,
    report_date DATE NOT NULL,

    -- 1. Общие показатели
    total_on_du INT NOT NULL DEFAULT 0,
    new_cases INT NOT NULL DEFAULT 0,
    contacts_count INT NOT NULL DEFAULT 0,

    -- 2. Группы ГДУ
    gdu_i INT NOT NULL DEFAULT 0,
    gdu_iia INT NOT NULL DEFAULT 0,
    gdu_iib INT NOT NULL DEFAULT 0,
    gdu_iii INT NOT NULL DEFAULT 0,

    -- 3. Лечение
    amb_total INT NOT NULL DEFAULT 0,
    amb_video INT NOT NULL DEFAULT 0,
    stat_total INT NOT NULL DEFAULT 0,
    day_total INT NOT NULL DEFAULT 0,
    interrupted INT NOT NULL DEFAULT 0,

    -- 4. Режимы ХТ (Амбулаторно)
    amb_lch_long INT NOT NULL DEFAULT 0, amb_lch_short INT NOT NULL DEFAULT 0,
    amb_mlu_long INT NOT NULL DEFAULT 0, amb_mlu_short_6m INT NOT NULL DEFAULT 0, amb_mlu_short_9m INT NOT NULL DEFAULT 0,
    amb_preshlu_long INT NOT NULL DEFAULT 0, amb_preshlu_short_6m INT NOT NULL DEFAULT 0, amb_preshlu_short_9m INT NOT NULL DEFAULT 0,
    amb_shlu INT NOT NULL DEFAULT 0,

    -- 5. Режимы ХТ (Стационар)
    stat_lch_long INT NOT NULL DEFAULT 0, stat_lch_short INT NOT NULL DEFAULT 0,
    stat_mlu_long INT NOT NULL DEFAULT 0, stat_mlu_short_6m INT NOT NULL DEFAULT 0, stat_mlu_short_9m INT NOT NULL DEFAULT 0,
    stat_preshlu_long INT NOT NULL DEFAULT 0, stat_preshlu_short_6m INT NOT NULL DEFAULT 0, stat_preshlu_short_9m INT NOT NULL DEFAULT 0,
    stat_shlu INT NOT NULL DEFAULT 0,

    -- 6. Режимы ХТ (Дневной стационар)
    day_lch_long INT NOT NULL DEFAULT 0, day_lch_short INT NOT NULL DEFAULT 0,
    day_mlu_long INT NOT NULL DEFAULT 0, day_mlu_short_6m INT NOT NULL DEFAULT 0, day_mlu_short_9m INT NOT NULL DEFAULT 0,
    day_preshlu_long INT NOT NULL DEFAULT 0, day_preshlu_short_6m INT NOT NULL DEFAULT 0, day_preshlu_short_9m INT NOT NULL DEFAULT 0,
    day_shlu INT NOT NULL DEFAULT 0,

    -- 7. Режимы ХТ (Видеоконтроль)
    video_lch_long INT NOT NULL DEFAULT 0, video_lch_short INT NOT NULL DEFAULT 0,
    video_mlu_long INT NOT NULL DEFAULT 0, video_mlu_short_6m INT NOT NULL DEFAULT 0, video_mlu_short_9m INT NOT NULL DEFAULT 0,
    video_preshlu_long INT NOT NULL DEFAULT 0, video_preshlu_short_6m INT NOT NULL DEFAULT 0, video_preshlu_short_9m INT NOT NULL DEFAULT 0,
    video_shlu INT NOT NULL DEFAULT 0,

    CONSTRAINT fk_case_doctor FOREIGN KEY (doctor_id) REFERENCES app_user(id),
    CONSTRAINT fk_case_district FOREIGN KEY (district_id) REFERENCES district(id)
);

CREATE INDEX idx_case_record_date ON case_record(report_date);