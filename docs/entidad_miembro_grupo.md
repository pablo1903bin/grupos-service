
# Documentación de la Entidad `MiembroGrupoEntity`

La entidad `MiembroGrupoEntity` representa la relación de muchos a muchos entre los usuarios y los grupos. Específicamente, modela la membresía de un usuario dentro de un grupo, junto con su rol y fecha de ingreso.

## 📦 Paquete
`com.tesoramobil.grupos.entities`

## 🧩 Mapeo de la Tabla
```sql
CREATE TABLE public.miembro_grupo (
    usuario_id int8 NOT NULL,
    grupo_id int8 NOT NULL,
    rol_grupo varchar(20) DEFAULT 'INVITADO' NOT NULL,
    fecha_ingreso timestamp DEFAULT now() NOT NULL,
    CONSTRAINT miembro_grupo_pkey PRIMARY KEY (usuario_id, grupo_id),
    CONSTRAINT miembro_grupo_grupo_id_fkey FOREIGN KEY (grupo_id) REFERENCES public."groups"(id),
    CONSTRAINT miembro_grupo_usuario_id_fkey FOREIGN KEY (usuario_id) REFERENCES public.users(id),
    CONSTRAINT check_rol_grupo CHECK (rol_grupo IN ('INVITADO', 'TESORERO', 'ADMINISTRADOR'))
);
```

## 🔑 Clave Primaria
Llave compuesta embebida con `@EmbeddedId`, usando la clase `MiembroGrupoId`:
- `usuarioId`
- `grupoId`

## 🔗 Relaciones

- `@ManyToOne` con `UserEntity` (usuario)
- `@ManyToOne` con `GrupoEntity` (grupo)
- Ambas relaciones usan `@MapsId` para indicar que los valores de `usuarioId` y `grupoId` están dentro de la clave primaria compuesta.

## 🧠 Atributos

| Atributo        | Tipo              | Descripción                                       |
|-----------------|-------------------|---------------------------------------------------|
| `id`            | `MiembroGrupoId`  | Clave primaria compuesta                         |
| `usuario`       | `UserEntity`      | Usuario al que pertenece esta membresía          |
| `grupo`         | `GrupoEntity`     | Grupo al que pertenece el usuario                |
| `rolGrupo`      | `String`          | Rol dentro del grupo (`INVITADO`, `TESORERO`, `ADMINISTRADOR`) |
| `fechaIngreso`  | `LocalDateTime`   | Fecha en que el usuario ingresó al grupo         |

## 📝 Consideraciones

- El uso de `@EmbeddedId` permite que Hibernate/JPA entienda que la tabla tiene una clave primaria compuesta.
- Los `MapsId` aseguran que `usuario` y `grupo` correspondan con la clave compuesta.
- Esta tabla facilita gestionar roles dentro de un grupo y realizar consultas específicas como:
  - Listar todos los grupos de un usuario.
  - Ver los miembros de un grupo según su rol.

