-- Добавляем администратора. Пароль: "admin" (зашифрован через BCrypt)
INSERT INTO app_user (username, password_hash, full_name, role, district_id)
VALUES ('admin', '$2a$10$tnMLXCLHxa4JI/L9UpzwFOZ2z9.FVEpAMOAz1nSlhOLnM5fw3AWkq', 'Администратор Системы', 'ADMIN', NULL);