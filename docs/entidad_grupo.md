
# 🧩 Entidad `GrupoEntity`

La clase `GrupoEntity` representa la **raíz del agregado** del subdominio de Grupos en el sistema Tesora. Es una unidad organizativa que agrupa usuarios para fines colaborativos (como administrar eventos, fondos o actividades escolares/comunitarias).

---

## 📌 Tabla mapeada

```sql
@Table(name = "groups")
```

---

## 🧬 Atributos principales

| Campo                   | Tipo               | Descripción                                                                 |
|------------------------|--------------------|-----------------------------------------------------------------------------|
| `id`                   | Long               | Identificador único (PK autogenerada)                                      |
| `categoria`            | String             | Clasificación opcional (ej: Fiesta, Proyecto, etc.)                        |
| `descripcion`          | String (text)      | Detalle general del objetivo del grupo                                     |
| `esPublico`            | Boolean            | Indica si el grupo es visible para otros usuarios                          |
| `estatus`              | String             | Estado lógico del grupo (`activo`, `inactivo`, `eliminado`, etc.)          |
| `fechaCreacion`        | LocalDateTime      | Fecha en que se creó el grupo                                              |
| `fechaActualizacion`   | LocalDateTime      | Última vez que se modificó información del grupo                           |
| `maxMiembros`          | Integer            | Límite de usuarios que pueden pertenecer al grupo (opcional)              |
| `metadata`             | String (jsonb)     | Campo libre para almacenar datos dinámicos/configuraciones adicionales     |
| `nombre`               | String             | Nombre visible del grupo (único por creador)                               |
| `tipo`                 | String             | Naturaleza del grupo (`escolar`, `comunidad`, `empresa`, etc.)             |
| `ubicacion`            | String             | Lugar físico o ciudad del grupo                                            |
| `configuracionDefault`| String (jsonb)     | Preferencias iniciales del grupo (ej: moneda, visibilidad, etc.)           |
| `requiereAprobacion`   | Boolean            | Si se necesita aprobación para unirse al grupo                             |

---

## 🔗 Relaciones

| Relación       | Tipo      | Entidad relacionada     | Descripción                                                 |
|----------------|-----------|--------------------------|-------------------------------------------------------------|
| `creadoPor`    | @ManyToOne| `UserEntity`             | Usuario que creó el grupo (relación directa por FK)         |
| `miembros`     | @OneToMany| `MiembroGrupoEntity`     | Lista de miembros asociados al grupo (relación muchos a muchos con rol) |

---

## 📚 Reglas de negocio relevantes

- El campo `nombre` debe ser único por cada usuario creador.
- Al crearse un grupo, el creador se convierte automáticamente en **ADMINISTRADOR** (vía `MiembroGrupoEntity`).
- Si `esPublico = true`, otros usuarios pueden visualizarlo.
- `estatus` puede utilizarse para realizar eliminaciones lógicas.

---

## ✅ Ejemplo de uso en código

```java
GrupoEntity grupo = new GrupoEntity();
grupo.setNombre("Tesorería Escolar 2025");
grupo.setTipo("escolar");
grupo.setDescripcion("Grupo para administrar cooperaciones de la escuela");
grupo.setEsPublico(true);
grupo.setFechaCreacion(LocalDateTime.now());
grupo.setFechaActualizacion(LocalDateTime.now());
grupo.setCreadoPor(usuarioActual);
```

---

## 🧠 Consejos para evolución

- El campo `metadata` permite escalar sin alterar el modelo (ideal para flags u opciones).
- Se pueden usar enums para `estatus` o `tipo` si se requiere mayor control.
- Considerar mover `rol_grupo` a una entidad especializada si se agregan más reglas o jerarquías.

---

📄 Generado automáticamente el 2025-05-05 03:55:11
