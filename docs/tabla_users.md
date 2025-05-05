# 📄 Tabla: users

La tabla `users` representa a los usuarios registrados en la plataforma Tesora. Cada usuario tiene atributos personales, credenciales y datos de contacto. Esta tabla es fundamental para identificar y autenticar a los miembros del sistema.

## 📌 Propósito

Almacenar la información básica y de autenticación de los usuarios, permitiendo su posterior asociación a grupos mediante la tabla `miembro_grupo`.

## 🧩 Estructura

| Campo             | Tipo           | Restricciones            | Descripción                                       |
|-------------------|----------------|---------------------------|---------------------------------------------------|
| `id`              | `bigserial`    | PK                        | Identificador único del usuario.                  |
| `apellido`        | `varchar(255)` | NOT NULL                  | Apellido del usuario.                             |
| `email`           | `varchar(255)` | NOT NULL, UNIQUE          | Correo electrónico único del usuario.             |
| `fecha_creacion`  | `timestamp`    | NOT NULL                  | Fecha de registro del usuario.                    |
| `nombre`          | `varchar(255)` | NOT NULL                  | Nombre(s) del usuario.                            |
| `password`        | `varchar(255)` | NOT NULL                  | Contraseña cifrada para autenticación.            |
| `role`            | `varchar(255)` | NOT NULL                  | Rol global del usuario (ej. `USER`, `ADMIN`) — *no confundir con rol en grupo*. |
| `telefono`        | `varchar(255)` | NOT NULL                  | Teléfono de contacto.                             |
| `username`        | `varchar(100)` | NOT NULL                  | Nombre de usuario visible o usado para login.     |

## 🔐 Restricciones y claves

- `PRIMARY KEY (id)` → garantiza identidad única.
- `UNIQUE (email)` → no permite que dos usuarios tengan el mismo correo.
- `role` → aunque es un string libre, se recomienda validar contra roles conocidos (`USER`, `ADMIN`).

## 🧠 Comportamiento esperado

- Los usuarios pueden crear grupos o ser invitados a ellos.
- El `role` en esta tabla **no** define su rol dentro de un grupo, sino su privilegio global en la plataforma.
- Los roles en grupos se manejan mediante `miembro_grupo`.