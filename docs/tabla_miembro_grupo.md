# 📄 Tabla: miembro_grupo

La tabla `miembro_grupo` representa la relación **muchos a muchos** entre `users` y `groups`. Cada registro define a **qué grupo pertenece un usuario y con qué rol**, además de la fecha de ingreso.

## 📌 Propósito

Establecer la pertenencia de los usuarios a grupos con roles diferenciados: `ADMINISTRADOR`, `TESORERO` o `INVITADO`.

## 🧩 Estructura

| Campo            | Tipo         | Restricciones | Descripción                                                                 |
|------------------|--------------|----------------|-----------------------------------------------------------------------------|
| `usuario_id`     | `int8`       | PK, FK         | ID del usuario (referencia a `users.id`).                                  |
| `grupo_id`       | `int8`       | PK, FK         | ID del grupo (referencia a `groups.id`).                                   |
| `rol_grupo`      | `varchar(20)`| NOT NULL       | Rol del usuario en el grupo (`INVITADO`, `TESORERO`, `ADMINISTRADOR`).     |
| `fecha_ingreso`  | `timestamp`  | NOT NULL       | Fecha en la que el usuario fue agregado al grupo. Default: `now()`.        |

## 🔐 Claves y restricciones

- **Clave primaria compuesta**: `(usuario_id, grupo_id)` garantiza que un mismo usuario no se registre dos veces en el mismo grupo.
- **Check constraint**: limita `rol_grupo` a tres valores válidos.
- **Llaves foráneas**:
  - `usuario_id` → `users.id`
  - `grupo_id` → `groups.id`

## 🧠 Comportamiento esperado

- Un usuario puede estar en varios grupos.
- Un grupo puede tener múltiples usuarios.
- El rol contextual se maneja aquí (no en la tabla `users`).
- Permite lógica como:
  - Filtrar usuarios por grupo.
  - Saber qué rol tiene un usuario en determinado grupo.
  - Restringir acciones por rol.

## 🏗️ Ejemplo de uso

```sql
INSERT INTO miembro_grupo (usuario_id, grupo_id, rol_grupo)
VALUES (1, 2, 'TESORERO');
