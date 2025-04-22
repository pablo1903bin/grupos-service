package com.tesoramobil.grupos.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

// Anotación para que esta clase sea un controlador REST
@RestController
@RequestMapping("/api/grupos") // Ruta base
public class GruposController {

    // Lista en memoria para almacenar grupos
    private List<String> grupos = new ArrayList<>();

    // Crear un nuevo grupo
    @PostMapping("/crear")
    public String crearGrupo(@RequestBody String nombreGrupo) {
        grupos.add(nombreGrupo);
        return "Grupo creado: " + nombreGrupo;
    }

    // Obtener todos los grupos
    @GetMapping("/listar")
    public List<String> listarGrupos() {
        return grupos;
    }

    // Actualizar un grupo por índice
    @PutMapping("/actualizar/{indice}")
    public String actualizarGrupo(@PathVariable int indice, @RequestBody String nuevoNombre) {
        if (indice >= 0 && indice < grupos.size()) {
            grupos.set(indice, nuevoNombre);
            return "Grupo actualizado en posición " + indice + ": " + nuevoNombre;
        } else {
            return "Índice inválido";
        }
    }

    // Eliminar un grupo por índice
    @DeleteMapping("/eliminar/{indice}")
    public String eliminarGrupo(@PathVariable int indice) {
        if (indice >= 0 && indice < grupos.size()) {
            String eliminado = grupos.remove(indice);
            return "Grupo eliminado: " + eliminado;
        } else {
            return "Índice inválido";
        }
    }
}
