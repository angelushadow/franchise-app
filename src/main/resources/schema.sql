-- Crear la base de datos (requiere permisos de superusuario)
-- CREATE DATABASE franquicia_db;

-- Conéctate a la nueva base
-- \c franquicia_db;

-- Crear tablas

-- Tabla de franquicias
CREATE TABLE IF NOT EXISTS franchises (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Tabla de sucursales
CREATE TABLE IF NOT EXISTS branches (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    franchise_id BIGINT REFERENCES franchises(id) ON DELETE CASCADE
);

-- Tabla de productos
CREATE TABLE IF NOT EXISTS products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    stock INT NOT NULL,
    branch_id BIGINT REFERENCES branches(id) ON DELETE CASCADE
);
