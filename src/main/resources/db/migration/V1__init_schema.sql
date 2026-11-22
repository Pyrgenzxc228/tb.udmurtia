-- 1. Таблица кустов (МПТД, ГМПТД, СМПТД и т.д.)
CREATE TABLE cluster (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- 2. Таблица районов (или участков для Ижевска)
CREATE TABLE district (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    cluster_id BIGINT NOT NULL,
    CONSTRAINT fk_district_cluster FOREIGN KEY (cluster_id) REFERENCES cluster(id)
);

-- 3. Таблица пользователей (Врачей)
CREATE TABLE app_user (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL, -- 'DOCTOR', 'ADMIN' и т.д.
    district_id BIGINT,
    CONSTRAINT fk_user_district FOREIGN KEY (district_id) REFERENCES district(id)
);