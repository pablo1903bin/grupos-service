# Documentación de la Entidad `UserEntity`

La clase `UserEntity` representa a los usuarios del sistema en el subdominio de grupos. Es una entidad persistente que se mapea directamente con la tabla `users` de la base de datos PostgreSQL.

## Tabla relacionada

```sql
CREATE TABLE public.users (
    id bigserial NOT NULL,
    apellido varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    fecha_creacion timestamp NOT NULL,
    nombre varchar(255) NOT NULL,
    "password" varchar(255) NOT NULL,
    "role" varchar(255) NOT NULL,
    telefono varchar(255) NOT NULL,
    username varchar(100) NOT NULL,
    CONSTRAINT uk_6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email),
    CONSTRAINT users_pkey PRIMARY KEY (id)
);
```

## Atributos

| Campo             | Tipo             | Descripción                                   |
|------------------|------------------|-----------------------------------------------|
| `id`             | Long             | Identificador único del usuario (PK)          |
| `username`       | String           | Nombre de usuario                             |
| `password`       | String           | Contraseña del usuario                        |
| `name`           | String           | Nombre del usuario                            |
| `apellido`       | String           | Apellido del usuario                          |
| `telefono`       | String           | Número de teléfono del usuario                |
| `email`          | String           | Correo electrónico, único y obligatorio       |
| `fechaCreacion`  | LocalDateTime    | Fecha de creación del usuario                 |
| `role`           | Enum `Role`      | Rol general del usuario (e.g., ADMIN, USER)   |
| `token`          | String           | Campo transitorio para almacenar el token JWT |

## Anotaciones destacadas

- `@Entity` y `@Table(name = "users")`: Indican que esta clase representa una tabla.
- `@Enumerated(EnumType.STRING)`: El rol se guarda como texto.
- `@Transient`: El campo `token` no se persiste en base de datos.

## Relaciones

Actualmente, esta entidad se relaciona con:

- `GrupoEntity`: Puede ser el creador de muchos grupos (`creado_por`)
- `MiembroGrupoEntity`: Puede pertenecer a muchos grupos como miembro.

## Uso

Esta clase sirve como punto de acceso a los datos del usuario en toda la lógica de negocio y seguridad de la aplicación.

---

📁 **Ubicación sugerida:** `docs/entidades/user_entity.md`
