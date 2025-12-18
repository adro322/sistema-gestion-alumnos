create database base_project2;

--Tabla Usuarios
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    usuario VARCHAR(100) UNIQUE,
    correo VARCHAR(100),
    contraseña VARCHAR(100),
    rol VARCHAR(50),
    pregunta_secreta TEXT,
    respuesta_secreta TEXT
);


--Tabla Sedes
CREATE TABLE sedes (
    id_sede SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion TEXT
);

--Tabla Alumnos
CREATE TABLE alumnos (
    id SERIAL PRIMARY KEY,
    codigo VARCHAR(10) UNIQUE NOT NULL,
	dni varchar(10) UNIQUE NOT NULL,
	telefono varchar(10),
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,    
    carrera VARCHAR(100),
    ciclo INTEGER CHECK (ciclo >= 1 AND ciclo <= 10),
	email VARCHAR(100),
    promedio NUMERIC(4,2) CHECK (promedio >= 0 AND promedio <= 20),
    estado VARCHAR(20) DEFAULT 'activo' CHECK (estado IN ('activo', 'egresado', 'retirado')),
    fecha_ingreso DATE,
    id_sede INTEGER REFERENCES sedes(id_sede)
);

--Insertar Datos de la Sede
INSERT INTO sedes (nombre, direccion) VALUES
('Lima Centro', 'Jr. Hernán Velarde 289, Lima'),
('Lima Norte', 'Av. Alfredo Mendiola 6377, Los Olivos'),
('Lima Sur', 'Carretera Panamericana Sur Km16, Villa El Salvador'),
('Lima Este - SJL', 'Av. El Sol cuadra 2, San Juan de Lurigancho'),
('Lima Este - ATE', 'Av. Carretera Central Km 11.6 (A una cuadra del Real Plaza Santa Clara, Ate)'),
('Arequipa', 'Av. Tacna y Arica 160, Arequipa'),
('Chiclayo', 'Esquina Prol. Augusto B. Leguía con Av. Hernán Meiner, Chiclayo'),
('Chimbote', 'Km 424 Panamericana Norte, Calle 56 S/N frente a Plaza Vea Nuevo Chimbote'),
('Piura', 'Av. Vice Cdra. 1. Al costado de Real Plaza'),
('Huancayo', 'Av. Circunvalación 449 (ex Av. Intihuatana) Urb. Acuario - El Tambo'),
('Ica', 'Av. Ayabaca S/N, Sector San José, al costado de la SUNAT'),
('Trujillo', 'Av. Nicolás de Piérola 1221, Trujillo');


--FUNCION MOSTRAR TABLA
CREATE OR REPLACE FUNCTION pa_mostrarAlumnos()
RETURNS TABLE (
    id INT,
    codigo VARCHAR,
    dni VARCHAR,
    telefono VARCHAR,
    nombres VARCHAR,
    apellidos VARCHAR,
    carrera VARCHAR,
    ciclo INT,
    email VARCHAR,
    sede VARCHAR,
    promedio NUMERIC,
    estado VARCHAR,
    fecha_ingreso DATE
)
AS $$
BEGIN
    RETURN QUERY
    SELECT a.id, a.codigo, a.dni, a.telefono, a.nombres, a.apellidos,
           a.carrera, a.ciclo, a.email, s.nombre AS sede,
           a.promedio, a.estado, a.fecha_ingreso
    FROM alumnos a
    JOIN sedes s ON a.id_sede = s.id_sede
    ORDER BY a.id;
END;
$$ LANGUAGE plpgsql;

-- Actualizamos la función para que incluya fecha_ingreso
CREATE OR REPLACE FUNCTION pa_buscaralumnosApellidos(vape VARCHAR)
RETURNS TABLE (
    id INT,
    codigo VARCHAR,
    dni VARCHAR,
    telefono VARCHAR,
    nombres VARCHAR,
    apellidos VARCHAR,
    carrera VARCHAR,
    ciclo INT,
    email VARCHAR,
    sede VARCHAR,
    promedio NUMERIC,
    estado VARCHAR,
    fecha_ingreso DATE  -- <--- AGREGADO AQUÍ
)
AS $$
BEGIN
    RETURN QUERY
    SELECT a.id, a.codigo, a.dni, a.telefono, a.nombres, a.apellidos,
           a.carrera, a.ciclo, a.email, s.nombre AS sede,
           a.promedio, a.estado, 
           a.fecha_ingreso -- <--- AGREGADO AQUÍ EN EL SELECT
    FROM alumnos a
    JOIN sedes s ON a.id_sede = s.id_sede
    WHERE a.apellidos ILIKE '%' || vape || '%'
    ORDER BY a.id;
END;
$$ LANGUAGE plpgsql;

-- 1. Primero eliminamos la versión anterior de la función
DROP FUNCTION IF EXISTS pa_buscaralumnosApellidos(VARCHAR);

SELECT * FROM usuarios
SELECT * FROM pa_buscaralumnosApellidos('Lopez');

SELECT * FROM SEDES;
SELECT * FROM ALUMNOS;
TRUNCATE TABLE alumnos RESTART IDENTITY CASCADE;

