# 📘 Documento de Referencia: Tabla `groups`

## 🧠 Contexto de Dominio
Este modelo es parte del **subdominio de Grupos**. Cada grupo puede tener múltiples usuarios con distintos roles (`ADMINISTRADOR`, `TESORERO`, `INVITADO`), y cada grupo organiza la información financiera, colaborativa y de miembros.

## 📌 Nombre de la tabla
**`public."groups"`**

## 📦 Propósito
Representa una unidad organizativa dentro de la plataforma. Un grupo puede ser un salón escolar, comunidad, equipo o cualquier entidad que requiera organización financiera o colaborativa.

## 🧩 Estructura de la tabla

| Columna                  | Tipo             | Descripción |
|--------------------------|------------------|-------------|
| `id`                     | `varchar`        | Identificador del grupo. Generado por `groups_id_seq`. Considerar `bigint` para coherencia. |
| `categoria`              | `varchar(50)`    | Categoría del grupo (ej. "Fiestas", "Eventos"). |
| `creado_por`             | `int8`           | ID del usuario que creó el grupo (FK a `users.id`). |
| `descripcion`            | `text`           | Descripción del grupo. |
| `es_publico`             | `boolean`        | Si el grupo es visible públicamente. |
| `estatus`                | `varchar(20)`    | Estado del grupo: "activo", "eliminado", etc. |
| `fecha_actualizacion`    | `timestamp`      | Última vez que se modificó. |
| `fecha_creacion`         | `timestamp`      | Fecha de creación. |
| `max_miembros`           | `int4`           | Límite de miembros permitidos (opcional). |
| `metadata`               | `jsonb`          | Configuraciones personalizadas. |
| `nombre`                 | `varchar(255)`   | Nombre visible del grupo. Unicidad por creador. |
| `tipo`                   | `varchar(50)`    | Tipo del grupo: "escolar", "comunidad", etc. |
| `ubicacion`              | `varchar(255)`   | Ubicación geográfica. |
| `configuracion_default`  | `jsonb`          | Configuraciones iniciales. |
| `requiere_aprobacion`    | `boolean`        | Si requiere aprobación para unirse. |

## 🔐 Restricciones

- `PRIMARY KEY (id)`
- `UNIQUE (nombre, creado_por)`
- `CHECK (max_miembros >= 1)`
- `FOREIGN KEY (creado_por)` → `users(id)`

## 🎯 Casos de Uso

- Crear grupos únicos por usuario.
- Buscar grupos públicos.
- Asociar usuarios mediante tabla `miembro_grupo`.
- Personalizar configuración y comportamiento por grupo.

## 🛠 Recomendaciones Técnicas

- Usa `metadata` para configuraciones dinámicas.
- `requiere_aprobacion` debe estar alineado con la lógica de invitaciones.

